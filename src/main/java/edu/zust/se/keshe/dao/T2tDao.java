package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.T2t;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface T2tDao extends Repository<T2t,Integer> {
    List<T2t> findAll();
    T2t findByTid(int tid);
    T2t save(T2t t2t);
}
