package edu.zust.se.keshe.entity;

import javax.persistence.*;

@Entity
public class S2t {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int tid;
    @Column
    private int sid;
    @Column
    private  int check;

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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "S2t{" +
                "id=" + id +
                ", tid=" + tid +
                ", sid=" + sid +
                ", check=" + check +
                '}';
    }
}
