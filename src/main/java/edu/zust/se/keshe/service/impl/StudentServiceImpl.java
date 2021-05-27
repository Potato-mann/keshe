package edu.zust.se.keshe.service.impl;

import edu.zust.se.keshe.dao.S2tDao;
import edu.zust.se.keshe.dao.StudentDao;
import edu.zust.se.keshe.dao.T2tDao;
import edu.zust.se.keshe.dao.TeamDao;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.entity.S2t;
import edu.zust.se.keshe.entity.Student;
import edu.zust.se.keshe.entity.T2t;
import edu.zust.se.keshe.entity.Team;
import edu.zust.se.keshe.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeamDao teamDao;
    @Autowired
    T2tDao t2tDao;
    @Autowired
    S2tDao s2tDao;
    public StudentDto login(int id, String password){
        List<Student> students=studentDao.findById(id);
        if(students==null||students.size()==0){
            return null;
        }
        if(!students.get(0).getPassword().equals(password)){
            return null;
        }
        StudentDto studentDto=e2d(students.get(0));
        return studentDto;
    }
    StudentDto e2d(Student student){
        StudentDto studentDto=new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return studentDto;
    }
    Student d2e(StudentDto studentDto){
        Student student =new Student();
        BeanUtils.copyProperties(studentDto,student);
        return student;
    }
    public Boolean isInContest(int sid,int cid){
        boolean flag=false;
        List<Team> teams=teamDao.findByCid(cid);
        for(Team team:teams){
            S2t s2t=s2tDao.findByTid(team.getId());
            if(s2t.getSid()==sid){
                flag=true;
            }
        }
        return flag;
    }
    public TeamDto showMyTeamInContest(int sid, int cid){
        List<S2t> s2tList=s2tDao.findBySid(sid);
        for(S2t s2t:s2tList){
            Team team=teamDao.findById(s2t.getTid());
            if(team.getCid()==cid){
                TeamDto teamDto =e2d(team);
                return teamDto;
            }
        }
        return null;
    }
    TeamDto e2d(Team team){
        TeamDto teamDto=new TeamDto();
        BeanUtils.copyProperties(team,teamDto);
        return teamDto;
    }
}
