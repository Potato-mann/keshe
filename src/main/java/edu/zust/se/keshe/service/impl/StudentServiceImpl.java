package edu.zust.se.keshe.service.impl;

import edu.zust.se.keshe.dao.*;
import edu.zust.se.keshe.dto.Award;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.entity.*;
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
    @Autowired
    ContestDao contestDao;
    @Autowired
    TeacherDao teacherDao;
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
    public List<Award> showMyAward(int sid) {
        List<S2t> s2ts=s2tDao.findBySid(sid);
        List<Award> awards=new LinkedList<>();
        for(S2t s2t:s2ts){
            Team team =teamDao.findById(s2t.getTid());
            Award award =new Award();
            Contest contest =contestDao.findById(team.getCid());
            award.setContestName(contest.getName());
            T2t t2t =t2tDao.findByTid(team.getId());
            Teacher teacher=teacherDao.findById(t2t.getTeacher_id());
            award.setTeamDto(e2d(team));
            awards.add(award);
        }
        return awards;
    }
}
