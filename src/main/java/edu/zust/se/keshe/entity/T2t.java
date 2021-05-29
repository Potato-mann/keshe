package edu.zust.se.keshe.entity;

import javax.persistence.*;

@Entity
public class T2t {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int tid;
    @Column
    private int teacher_id;

    @Override
    public String toString() {
        return "T2t{" +
                "id=" + id +
                ", tid=" + tid +
                ", teacher_id=" + teacher_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
