package com.example.domain;

public class Employee {
    private int id;
    private String loginname;
    private String password;
    private String name;
    private String sex;
    private int age;
    private String phone;
    private double sal;
    private String state;

    public Employee() {
    }

    public Employee(String loginname, String password,
                    String name, String sex, int age,
                    String phone, double sal, String state) {
        this.loginname = loginname;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.sal = sal;
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public double getSal() {
        return sal;
    }

    public String getState() {
        return state;
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", loginname=" + loginname
                + ", password=" + password + ", name=" + name + ", sex=" + sex
                + ", age=" + age + ", phone=" + phone + ", sal=" + sal
                + ", state=" + state + "]";
    }
}
