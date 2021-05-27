package edu.zust.se.keshe.dto;

public class StudentDto {
    private int id;
    private String true_name;
    private String gender;
    private String department;
    private String major;
    private String clazz;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrueName() {
        return true_name;
    }

    public void setTrueName(String true_name) {
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
        return "StudentDto{" +
                "id=" + id +
                ", true_name='" + true_name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", clazz='" + clazz + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
