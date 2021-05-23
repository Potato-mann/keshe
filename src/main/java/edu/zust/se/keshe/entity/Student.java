package edu.zust.se.keshe.entity;

import com.sun.javafx.beans.IDProperty;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String password;
    @Column
    private String true_name;
    @Column
    private String gender;
    @Column
    private String department;
    @Column
    private String major;
    @Column
    private String clazz;
    @Column
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTureName() {
        return true_name;
    }

    public void setTureName(String trueName) {
        this.true_name = trueName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", trueName='" + true_name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", clazz='" + clazz + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    
}
