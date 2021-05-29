package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {

    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
}
