package edu.zust.se.keshe.service.impl;

import edu.zust.se.keshe.dao.ContestDao;
import edu.zust.se.keshe.dto.ContestDto;
import edu.zust.se.keshe.entity.Contest;
import edu.zust.se.keshe.service.ContestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ContestServiceImpl implements ContestService {
    @Autowired
    ContestDao contestDao;
    public List<ContestDto> showAllContest(){
        List<Contest> contests=contestDao.findAll();
        List<ContestDto> contestDtos=new LinkedList<>();
        for(Contest contest :contests){
            contestDtos.add(e2d(contest));
        }
        return contestDtos;
    }
    ContestDto e2d(Contest contest){
        ContestDto contestDto=new ContestDto();
        BeanUtils.copyProperties(contest,contestDto);
        return contestDto;
    }
}
