package edu.zust.se.keshe.service;

import edu.zust.se.keshe.dto.StudentDto;
import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.entity.Teacher;

import java.util.List;

public interface TeamService {
    List<TeamDto> showMyTeam(int id);
    String showTeamStatus(int tid);
    List<StudentDto> showStudentInTeam(int tid);
    Teacher showTeacherInTeam(int tid);
    TeamDto showThisTeam(int tid);
}
