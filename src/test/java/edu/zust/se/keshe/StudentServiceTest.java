package edu.zust.se.keshe;

import edu.zust.se.keshe.dto.Award;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.service.StudentService;
import edu.zust.se.keshe.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;
    @Test
    public void testLogin(){
        StudentDto studentDto=studentService.login(1180199152,"123456");
        if(studentDto==null){
            System.out.println("failed");
        }else{
            System.out.println(studentDto);
        }
    }
    @Test
    public void testIsInContest(){
        System.out.println(studentService.isInContest(1180199152,1001));
        System.out.println(studentService.isInContest(1,1001));
    }
    @Test
    public void testShowMyTeamInContest(){
        TeamDto teamDto=studentService.showMyTeamInContest(1180199152,1001);
        System.out.println(teamDto);
    }
    @Test
    public void showMyAllAwards(){
        List<Award> awardList=studentService.showMyAward(1180199152);
        System.out.println(awardList);
    }
    @Test
    public void testDate(){
        Date now =new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date =dateFormat.format(now);
        System.out.println(date);
    }
    @Test
    public void testShowMyAwardInContest(){
        Award award=studentService.showMyAwardInContest(1180199152,1001);
        System.out.println(award);
    }
    @Test
    public void testSignUp(){
        List<Integer> students=new LinkedList<>();
        students.add(1180199152);
        System.out.println(studentService.signUp(1, 1003, students, 1001, "yyff", "yyf"));
    }
    @Test
    public void testMyApply(){
        System.out.println(studentService.myApply(1));
    }
    @Test
    public void testAccept(){
        System.out.println(studentService.accept(3,25));
    }
    @Test
    public void testRefuse(){
        System.out.println(studentService.refuse(4,25));
    }
}
