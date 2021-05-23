package edu.zust.se.keshe;

import edu.zust.se.keshe.dao.*;
import edu.zust.se.keshe.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JpaTest {
    @Autowired
    StudentDao studentDao;
    @Test
    public void testStudentDao(){
        List<Student> students = studentDao.findAll();
        System.out.println(students);
    }
    @Autowired
    TeacherDao teacherDao;
    @Test
    public void testTeacherDao(){
        List<Teacher> teachers =teacherDao.findAll();
        System.out.println(teachers);
    }
    @Autowired
    ContestDao contestDao;
    @Test
    public void testContestDao(){
        List<Contest> contests=contestDao.findAll();
        System.out.println(contests);
    }
    @Autowired
    TeamDao teamDao;
    @Test
    public void testTeamDao(){
        List<Team> teams =teamDao.findAll();
        System.out.println(teams);
    }
    @Autowired
    S2tDao s2tDao;
    @Test
    public void testS2tDao(){
        List<S2t> s2ts=s2tDao.findAll();
        System.out.println(s2ts);
    }
    @Autowired
    T2tDao t2tDao;
    @Test
    public void testT2tDao(){
        List<T2t> t2ts=t2tDao.findAll();
        System.out.println(t2ts);
    }
}
