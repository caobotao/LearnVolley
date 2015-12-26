package com.example.caobotao.sendargs;

import java.io.Serializable;

/**
 * Created by caobotao on 15-9-30.
 */
public class User implements Serializable{
    private String name;
    private int age;
    public User(String name,int age){
        this.age = age;
        this.name = name;
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
}
