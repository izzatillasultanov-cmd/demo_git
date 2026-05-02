package com.example.demo_git.dto;

public class UserCreateDTO {
    private String name;
    private String fullName;
    private int age;
    private Boolean deleted;

    public UserCreateDTO(String name, String fullName,int age,Boolean deleted) {
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
