package edu.zust.se.keshe.dto;

import java.util.List;

public class Award {
    String contestName;
    TeamDto teamDto;
    String teacher;

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public TeamDto getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.teamDto = teamDto;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Award{" +
                "contestName='" + contestName + '\'' +
                ", teamDto=" + teamDto +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
