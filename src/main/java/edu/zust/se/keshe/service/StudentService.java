package edu.zust.se.keshe.service;

import edu.zust.se.keshe.dto.Award;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;

import java.util.List;

public interface StudentService {
    StudentDto login(int id , String password);
    Boolean isInContest(int sid,int cid);
    TeamDto showMyTeamInContest(int sid,int cid);
    List<Award> showMyAward(int sid);
}
