package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.Teacher;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TeacherDao extends Repository<Teacher,Integer> {
    List<Teacher> findAll();
    Teacher findById(int teacher_id);
}
