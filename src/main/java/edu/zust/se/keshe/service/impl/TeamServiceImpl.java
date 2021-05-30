package edu.zust.se.keshe.service.impl;

import edu.zust.se.keshe.dao.ContestDao;
import edu.zust.se.keshe.dao.S2tDao;
import edu.zust.se.keshe.dao.StudentDao;
import edu.zust.se.keshe.dao.TeamDao;
import edu.zust.se.keshe.dto.ContestDto;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.entity.Contest;
import edu.zust.se.keshe.entity.S2t;
import edu.zust.se.keshe.entity.Student;
import edu.zust.se.keshe.entity.Team;
import edu.zust.se.keshe.service.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    S2tDao s2tDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeamDao teamDao;
    @Autowired
    ContestDao contestDao;
    public List<TeamDto> showMyTeam(int id){
        List<S2t> s2ts=s2tDao.findBySid(id);
        System.out.println(id);
        System.out.println(s2ts.size());
        if(s2ts==null||s2ts.size()==0){
            return null;
        }else{
            List<TeamDto> teams=new LinkedList<>();
            for(S2t s2t:s2ts){
                Team team =teamDao.findById(s2t.getTid());
                System.out.println(team);
                TeamDto teamDto=e2d(team);
                teamDto.setContest(e2d(contestDao.findById(team.getCid())));
                teams.add(teamDto);
            }
            return teams;
        }
    }
    TeamDto e2d(Team team){
        TeamDto teamDto=new TeamDto();
        BeanUtils.copyProperties(team,teamDto);
        return teamDto;
    }
    ContestDto e2d(Contest contest){
        ContestDto contestDto=new ContestDto();
        BeanUtils.copyProperties(contest,contestDto);
        return contestDto;
    }
    public String showTeamStatus(int tid){
        Team team=teamDao.findById(tid);
        if(team.getS_check()==-1){
            return "有同学拒绝参加该队伍";
        }else if(team.getT_check()==-1){
            return "老师拒绝了队伍的指导申请";
        }else if(team.getS_check()!=team.getTeam_number()){
            return "还有同学未确认参加该队伍";
        }else if(team.getT_check()==0){
            return "指导老师正在对你的队伍进行审核";
        }else{
            return "报名成功";
        }
    }
    StudentDto e2d(Student student){
        StudentDto studentDto=new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return studentDto;
    }
    public List<StudentDto> showStudentInTeam(int tid){
        List<StudentDto> studentDtos=new LinkedList<>();
        List<S2t> s2ts= s2tDao.findByTid(tid);
        for(S2t s2t:s2ts){
            Student student=studentDao.findById(s2t.getSid());
            studentDtos.add(e2d(student));
        }
        return studentDtos;
    }
}
