package edu.zust.se.keshe.controller;

import edu.zust.se.keshe.dao.StudentDao;
import edu.zust.se.keshe.dto.ContestDto;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.dto.TeamMassage;
import edu.zust.se.keshe.entity.Teacher;
import edu.zust.se.keshe.service.ContestService;
import edu.zust.se.keshe.service.StudentService;
import edu.zust.se.keshe.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ContestService contestService;
    @Autowired
    private TeamService teamService;

    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public String Login(String id, String password, HttpSession session, Model model){
        int ID=Integer.parseInt(id);
        StudentDto studentDto=studentService.login(ID,password);
        if(studentDto!=null){
            session.setAttribute("student",studentDto);
            session.setAttribute("contests",contestService.showAllContest());
            session.setAttribute("Award",studentService.showMyAward(studentDto.getId()));
            session.setAttribute("team",teamService.showMyTeam(studentDto.getId()));
//            model.addAttribute("student",studentDto);
//            model.addAttribute("contests",contestService.showAllContest());
//            model.addAttribute("Award",studentService.showMyAward(studentDto.getId()));
//            model.addAttribute("team",teamService.showMyTeam(studentDto.getId()));
            return "home";
        }
        return "failed";
    }
    @RequestMapping("/myAward")
    public String showMyAward(HttpSession session,Model model){
        return "myAward";
    }
    @RequestMapping("/myInfo")
    public String showMyInfo(HttpSession session,Model model){
        return "myInfo";
    }
    @RequestMapping("/myTeam")
    public String showMyTeam(){
        return "myTeam";
    }
    @RequestMapping("/myContest")
    public String shouMyContext(HttpSession session,Model model){
        StudentDto studentDto=(StudentDto) session.getAttribute("student");
        System.out.println(studentDto);
        session.setAttribute("myContests",contestService.showMyContest(studentDto.getId()));
        return "myContest";
    }
    @RequestMapping("/allContest")
    public String showAllContext(HttpSession session,Model model){
        return "allContest";
    }
    @RequestMapping("/home")
    public String goToHome(HttpSession session,Model model){
        return "home";
    }
    @RequestMapping("/showTeam")//展示该队伍的所有信息
    public String showTeam(int tid,HttpSession session,Model model){
        List<StudentDto> studentDtos=teamService.showStudentInTeam(tid);
        Teacher teacher=teamService.showTeacherInTeam(tid);
        TeamDto teamDto =teamService.showThisTeam(tid);
        TeamMassage teamMassage=new TeamMassage();
        teamMassage.setStudentDtoList(studentDtos);
        teamMassage.setTeacher(teacher);
        teamMassage.setTeamDto(teamDto);
        session.setAttribute("teamMassage",teamMassage);
        return "showTeam";
    }
    @RequestMapping("/showStudent")
    public String showStudent(int sid,HttpSession session,Model model){
        StudentDto studentDto=studentService.showStudentInfo(sid);
        session.setAttribute("studentInfo",studentDto);
        return "showStudent";
    }
}
