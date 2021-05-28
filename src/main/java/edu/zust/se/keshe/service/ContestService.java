package edu.zust.se.keshe.service;

import edu.zust.se.keshe.dto.ContestDto;
import edu.zust.se.keshe.entity.Contest;

import java.util.List;

public interface ContestService {
    List<ContestDto> showAllContest();
    String showContestStatus(int cid);
}
