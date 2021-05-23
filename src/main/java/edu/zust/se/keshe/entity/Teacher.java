package edu.zust.se.keshe.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Teacher {
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
    private String professional_title;
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

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
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

    public String getProfessional_title() {
        return professional_title;
    }

    public void setProfessional_title(String professional_title) {
        this.professional_title = professional_title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", ture_name='" + true_name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", professional_title='" + professional_title + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
