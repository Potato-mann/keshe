package edu.zust.se.keshe.entity;

import javax.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int team_number;
    @Column
    private String description;
    @Column
    private int cid;
    @Column
    private int s_check;
    @Column
    private int t_check;
    @Column
    private String score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeam_number() {
        return team_number;
    }

    public void setTeam_number(int team_number) {
        this.team_number = team_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getS_check() {
        return s_check;
    }

    public void setS_check(int s_check) {
        this.s_check = s_check;
    }

    public int getT_check() {
        return t_check;
    }

    public void setT_check(int t_check) {
        this.t_check = t_check;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team_number=" + team_number +
                ", description='" + description + '\'' +
                ", cid=" + cid +
                ", s_check=" + s_check +
                ", t_check=" + t_check +
                ", score='" + score + '\'' +
                '}';
    }
}
