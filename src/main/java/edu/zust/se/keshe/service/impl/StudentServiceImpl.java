package edu.zust.se.keshe.service.impl;

import edu.zust.se.keshe.dao.*;
import edu.zust.se.keshe.dto.Award;
import edu.zust.se.keshe.dto.ContestDto;
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
        Student student=studentDao.findById(id);
        if(student==null){
            return null;
        }
        if(!student.getPassword().equals(password)){
            return null;
        }
        StudentDto studentDto=e2d(student);
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
    public int isInContest(int sid,int cid){//0表示未报名，1表示报名失败，2表示报名进行中，3表示报名成功
        List<Team> teams=teamDao.findByCid(cid);
        for(Team team:teams){
            List<S2t> s2t=s2tDao.findByTid(team.getId());
            for(S2t s2t1:s2t){
                if(s2t1.getSid()==sid){
                    if(team.getS_check()==-1||team.getT_check()==-1){
                        return 1;
                    }else{
                        if(team.getS_check()==team.getTeam_number()&&team.getT_check()==1){
                            return 3;
                        }else{
                            return 2;
                        }
                    }
                }
            }

        }
        return 0;
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
    public Award showMyAwardInContest(int sid,int cid){
        List<S2t> s2ts=s2tDao.findBySid(sid);
        for(S2t s2t:s2ts){
            Team team =teamDao.findById(s2t.getTid());
            if(team.getCid()==cid){
                Contest contest=contestDao.findById(cid);
                T2t t2t=t2tDao.findByTid(team.getId());
                Teacher teacher =teacherDao.findById(t2t.getTeacher_id());
                Award award=new Award();
                award.setTeamDto(e2d(team));
                award.setContestName(contest.getName());
                award.setTeacher(teacher.getTrue_name());
                return award;
            }
        }
        return null;
    }
    public String signUp(int sid,int cid,List<Integer> students,int teacher_id,String teamName,String description){
        Student student=studentDao.findById(sid);
        List<S2t> s2ts=s2tDao.findBySid(sid);
        for(S2t s2t:s2ts){
            Team team =teamDao.findById(s2t.getTid());
            if(team.getCid()==cid&&team.getT_check()!=-1&&team.getS_check()!=-1){
                return "你已经报名了该比赛";
            }
        }
        Teacher teacher =teacherDao.findById(teacher_id);
        System.out.println(teacher);
        if(teacher==null){
            return "查询不到该老师的身份信息";
        }
        System.out.println("1111111111111111");
        System.out.println(sid);
        System.out.println(cid);
        System.out.println(students);
        System.out.println(teacher_id);
        System.out.println(teamName);
        System.out.println(description);
        List<Integer> nonExistent=new LinkedList<>();
        List<Integer> isInContest=new LinkedList<>();
        if(students!=null){
            for(int studentId: students){
                Student student1=studentDao.findById(studentId);
                if(student1==null){
                    nonExistent.add(studentId);
                }else{
                    List<S2t> s2ts1=s2tDao.findBySid(studentId);
                    for(S2t s2t:s2ts1){
                        Team team=teamDao.findById(s2t.getTid());
                        if(team.getCid()==cid){
                            isInContest.add(studentId);
                        }
                    }
                }
            }
        }
        if(nonExistent.size()!=0){
            return "查询不到"+nonExistent.toString()+"的信息";
        }
        if(isInContest.size()!=0){
            return isInContest.toString()+"已经报名了该比赛";
        }
        Team team11=teamDao.findByCidAndName(cid,teamName);
        if (team11!=null){
            return "名字已经被人抢走了，换个名字吧";
        }
        //创建team
        Team team =new Team();
        team.setName(teamName);
        if(students==null){
            team.setTeam_number(1);
        }else {
            team.setTeam_number(students.size()+1);
        }

        team.setDescription(description);
        team.setCid(cid);
        team.setS_check(1);
        team.setT_check(0);
        team.setScore("暂未公布成绩");
        System.out.println(team);
        Team t=teamDao.save(team);
        int tid=t.getId();
        S2t s2t=new S2t();
        s2t.setTid(tid);
        s2t.setScheck(1);
        s2t.setSid(sid);
        System.out.println(s2t);
        s2tDao.save(s2t);
        if(students!=null){
            for(int studentId:students){
                S2t s2t2 =new S2t();
                s2t2.setTid(tid);
                s2t2.setScheck(0);
                s2t2.setSid(studentId);
                s2tDao.save(s2t2);
            }
        }

        T2t t2t=new T2t();
        t2t.setTeacher_id(teacher_id);
        t2t.setTid(tid);
        t2tDao.save(t2t);
        return "报名成功";
    }
    public List<TeamDto> myApply(int sid){
        List<S2t> s2ts=s2tDao.findBySidAndScheck(sid,0);
        List<TeamDto> teamDtos=new LinkedList<>();
        for(S2t s2t:s2ts){
            Team team=teamDao.findById(s2t.getTid());
            TeamDto teamDto=e2d(team);
            teamDto.setContest(e2d(contestDao.findById(team.getCid())));
            teamDtos.add(teamDto);
        }
        return teamDtos;
    }
    ContestDto e2d(Contest contest){
        ContestDto contestDto=new ContestDto();
        BeanUtils.copyProperties(contest,contestDto);
        return contestDto;
    }
    public String accept(int sid,int tid){
        Team team=teamDao.findById(tid);
        team.setS_check(team.getS_check()+1);
        S2t s2t=s2tDao.findBySidAndTid(sid,tid);
        s2t.setScheck(1);
        teamDao.save(team);
        s2tDao.save(s2t);
        return "组队申请已经确认";
    }
    public String refuse(int sid,int tid){
        Team team=teamDao.findById(tid);
        team.setS_check(-1);
        S2t s2t=s2tDao.findBySidAndTid(sid,tid);
        s2t.setScheck(-1);
        teamDao.save(team);
        s2tDao.save(s2t);
        return "组队申请已经拒绝";
    }
    public String signOut(int sid,int tid){
        Team team=teamDao.findById(tid);
        return "退出成功";
    }
    public StudentDto showStudentInfo(int sid){
        Student student=studentDao.findById(sid);
        StudentDto studentDto=e2d(student);
        return studentDto;
    }
}
