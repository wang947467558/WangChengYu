package com.wcy.education.entity;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

//用户信息类
public class UserInfo {
    String name;
    String passWord;
    String sex;
    String number;
    String school;

    public UserInfo() {
    }

    public UserInfo(String name, String passWord, String sex, String number, String school) {
        this.name = name;
        this.passWord = passWord;
        this.sex = sex;
        this.number = number;
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getSex() {
        return sex;
    }

    public String getNumber() {
        return number;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex='" + sex + '\'' +
                ", number='" + number + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
