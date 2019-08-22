package com.zhiquan.cai.sbootredis.vi;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="UserInfo")
public class UserInfo {

    @Id
    private String id;
    private String username;
    private String password;
    private int age;

    public UserInfo() {}

    public UserInfo(String id, String username, String password, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
