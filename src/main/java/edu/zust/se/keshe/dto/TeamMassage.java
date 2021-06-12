package edu.zust.se.keshe.dto;

import edu.zust.se.keshe.entity.Teacher;

import java.util.List;

public class TeamMassage {
    private TeamDto teamDto;
    private Teacher teacher;
    List<StudentDto> studentDtoList;

    public TeamDto getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.teamDto = teamDto;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<StudentDto> getStudentDtoList() {
        return studentDtoList;
    }

    public void setStudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }

    @Override
    public String toString() {
        return "teamMassage{" +
                "teamDto=" + teamDto +
                ", teacher=" + teacher +
                ", studentDtoList=" + studentDtoList +
                '}';
    }
}
