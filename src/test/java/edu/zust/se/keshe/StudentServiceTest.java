package edu.zust.se.keshe;

import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.service.StudentService;
import edu.zust.se.keshe.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;

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
}
