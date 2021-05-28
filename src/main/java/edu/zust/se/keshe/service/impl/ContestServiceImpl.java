package edu.zust.se.keshe.service.impl;

import edu.zust.se.keshe.dao.ContestDao;
import edu.zust.se.keshe.dto.ContestDto;
import edu.zust.se.keshe.entity.Contest;
import edu.zust.se.keshe.service.ContestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String showContestStatus(int cid){
        Contest contest=contestDao.findById(cid);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String now=simpleDateFormat.format(date);
        System.out.println(now);
        System.out.println(contest);
        System.out.println(contest.getContest_start_time().toString().compareTo(now));
        if(contest.getRegister_start_time().toString().compareTo(now)>0){
            return "报名还未开始";
        }else if(contest.getRegister_end_time().toString().compareTo(now)<0&&contest.getContest_start_time().toString().compareTo(now)>0){
            return "报名时间已经结束";
        }else if(contest.getContest_end_time().toString().compareTo(now)>=0&&contest.getContest_start_time().toString().compareTo(now)<=0){
            return "比赛进行中";
        }else if(contest.getContest_end_time().toString().compareTo(now)<0){
            return "比赛已结束";
        }
        return "报名中";
    }
}
