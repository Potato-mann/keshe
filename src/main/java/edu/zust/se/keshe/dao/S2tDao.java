package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.S2t;
import edu.zust.se.keshe.entity.T2t;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface S2tDao extends Repository<S2t,Integer> {
    public List<S2t> findAll();
    List<S2t> findBySid(int id);
    List<S2t> findByTid(int tid);
    S2t save(S2t s2t);
    List<S2t> findBySidAndScheck(int sid,int check);
    S2t findBySidAndTid(int sid,int tid);
}
