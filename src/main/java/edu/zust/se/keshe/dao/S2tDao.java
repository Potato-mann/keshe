package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.S2t;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface S2tDao extends Repository<S2t,Integer> {
    public List<S2t> findAll();
}
