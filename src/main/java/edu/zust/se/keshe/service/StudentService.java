package edu.zust.se.keshe.service;

import edu.zust.se.keshe.dto.Award;
import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;

import java.util.List;

public interface StudentService {
    StudentDto login(int id , String password);
    int isInContest(int sid,int cid);
    TeamDto showMyTeamInContest(int sid,int cid);
    List<Award> showMyAward(int sid);
    Award showMyAwardInContest(int sid,int cid);
    String signUp(int sid,int cid,List<Integer> students,int teacher_id,String teamName,String description);
    List<TeamDto> myApply(int sid);
    String accept(int sid,int tid);
    String refuse(int sid,int tid);
    String signOut(int sid,int tid);
}
