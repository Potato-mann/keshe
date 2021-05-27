package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.Contest;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ContestDao extends Repository<Contest,Integer> {
    public List<Contest> findAll();
    Contest findById(int id);
}
