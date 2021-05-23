package edu.zust.se.keshe.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String sponsor;
    @Column
    private int number_limit;
    @Column
    private Date register_start_time;
    @Column
    private Date register_end_time;
    @Column
    private Date contest_start_time;
    @Column
    private Date contest_end_time;
    @Column
    private String description;

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

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getNumber_limit() {
        return number_limit;
    }

    public void setNumber_limit(int number_limit) {
        this.number_limit = number_limit;
    }

    public Date getRegister_start_time() {
        return register_start_time;
    }

    public void setRegister_start_time(Date register_start_time) {
        this.register_start_time = register_start_time;
    }

    public Date getRegister_end_time() {
        return register_end_time;
    }

    public void setRegister_end_time(Date register_end_time) {
        this.register_end_time = register_end_time;
    }

    public Date getContest_start_time() {
        return contest_start_time;
    }

    public void setContest_start_time(Date contest_start_time) {
        this.contest_start_time = contest_start_time;
    }

    public Date getContest_end_time() {
        return contest_end_time;
    }

    public void setContest_end_time(Date contest_end_time) {
        this.contest_end_time = contest_end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", number_limit=" + number_limit +
                ", register_start_time=" + register_start_time +
                ", register_end_time=" + register_end_time +
                ", contest_start_time=" + contest_start_time +
                ", contest_end_time=" + contest_end_time +
                ", description='" + description + '\'' +
                '}';
    }
}
