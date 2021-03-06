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
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
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
    @RequestMapping("/showTeam")//??????????????????????????????
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
    @RequestMapping("/showTeacher")
    public String showTeacher(int tid,HttpSession session,Model model){
        Teacher teacher=teamService.showTeacherInTeam(tid);
        session.setAttribute("teacher",teacher);
        return "showTeacher";
    }
    @RequestMapping("/goToApply")
    public String goToApply(int cid,HttpSession session,Model model){
        ContestDto contest=contestService.findById(cid);
        session.setAttribute("applyContest",contest);
        String message=new String();
        System.out.println(contest);
        if(contest.getStatus().equals("?????????")){
            StudentDto student=(StudentDto) session.getAttribute("student");
            int flag=studentService.isInContest(student.getId(),contest.getId());

            if (flag==1||flag==0){
                return "apply";
            }else {
                if (flag==2) message="????????????????????????????????????????????????";
                else if(flag==3) message="????????????????????????";
            }
        }else{
            message= contest.getStatus();
        }
        session.setAttribute("applyMessage",message);
        return "filedapply";
    }
    @RequestMapping("/signUp")
    public String signUp(String student1,
                         String student2,
                         String student3,
                         String student4,
                         String student5,
                         String student6,
                         String student7,
                         String student8,
                         String student9,
                         String student10,
                         String teacher_id,
                         String teamName,
                         String description,
                         HttpSession session,
                         Model model){
        List<Integer> student =new LinkedList<>();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        String massage="";

        if(teacher_id==null||teacher_id==""){
            massage="?????????????????????";
            return "applyFailed";
        }
        if(teamName==null||teamName==""){
            massage="??????????????????????????????????????????";
            return "applyFailed";
        }
        if(student1!=null) student.add(Integer.parseInt(student1));
        if(student2!=null) student.add(Integer.parseInt(student2));
        if(student3!=null) student.add(Integer.parseInt(student3));
        if(student4!=null) student.add(Integer.parseInt(student4));
        if(student5!=null) student.add(Integer.parseInt(student5));
        if(student6!=null) student.add(Integer.parseInt(student6));
        if(student7!=null) student.add(Integer.parseInt(student7));
        if(student8!=null) student.add(Integer.parseInt(student8));
        if(student9!=null) student.add(Integer.parseInt(student9));
        if(student10!=null) student.add(Integer.parseInt(student10));
        StudentDto studentDto=(StudentDto)session.getAttribute("student");
        ContestDto contestDto=(ContestDto)session.getAttribute("applyContest");
        massage=studentService.signUp(studentDto.getId(),contestDto.getId(),student,Integer.parseInt(teacher_id),teamName,description);
        if(massage=="????????????"){
            return "successApply";
        }else {
            session.setAttribute("failedApplyMassage",massage);
            return "applyFailed";
        }
    }

    @RequestMapping("/message")
    public String message(HttpSession session, Model model){
        StudentDto studentDto=(StudentDto)session.getAttribute("student");
        List<TeamDto> myApply=studentService.myApply(studentDto.getId());
        System.out.println("*************");
        System.out.println(myApply);
        session.setAttribute("myApply",myApply);
        return "message";
    }
    @RequestMapping("/accept")
    public String accept(int tid,HttpSession session,Model model){
        StudentDto studentDto =(StudentDto)session.getAttribute("student");
        String message=studentService.accept(studentDto.getId(),tid);
        session.setAttribute("acceptMessage",message);
        return "successAccept";
    }
    @RequestMapping("/refuse")
    public String refuse(int tid,HttpSession session,Model model){
        StudentDto studentDto=(StudentDto)session.getAttribute("student");
        String message=studentService.refuse(studentDto.getId(),tid);
        session.setAttribute("refuseMessage",message);
        return "successRefuse";
    }
}
