package com.hqyj.hx.pojo;

import java.util.Date;

/**
 * @author xfy
 * @create 2021-08-31 16:00
 */
/*
* 使用user对象封装数据库user表中的数据
* */

public class User {
    private int id;
    private String name;
    private int sex;//0男1女
    private String address;
    private String phone;
    private String email;
    private String username;
    private String password;
    private int deleted;//0正常 1删除
    private Date updateTime;//记录更新时间


    public User() {
    }

    public User(int id, String name, int sex, String address, String phone, String email, String username, String password, int deleted, Date updateTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.deleted = deleted;
        this.updateTime = updateTime;
    }

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deleted=" + deleted +
                ", updateTime=" + updateTime +
                '}';
    }
}
