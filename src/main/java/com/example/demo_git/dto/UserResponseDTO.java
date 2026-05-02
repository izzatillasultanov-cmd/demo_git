package com.example.demo_git.dto;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String fullName;
    private int age;
    private Boolean deleted;


    public UserResponseDTO(Long id, String name, String fullName, int age,Boolean deleted) {

        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.deleted = deleted;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
