package com.example.caobotao.activitylifecircle;

import java.io.Serializable;

/**
 * Created by caobotao on 15/11/29.
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private String school;
    private String address;
    public Person(){}
    public Person(String name,int age,String school,String address){
        this.name = name;
        this.age = age;
        this.school = school;
        this.address = address;
    }

    @Override
    public String toString() {
        return "姓名: " + name + "\n年龄: " + age + "\n学校: " + school + "\n地址: " + address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
