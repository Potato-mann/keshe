package edu.zust.se.keshe.dao;

import edu.zust.se.keshe.entity.Team;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TeamDao extends Repository<Team,Integer> {
    public List<Team> findAll();
}
