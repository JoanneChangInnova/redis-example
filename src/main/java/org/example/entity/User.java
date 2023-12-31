package org.example.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private Integer passWord;

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassWord() {
        return passWord;
    }

    public void setPassWord(Integer passWord) {
        this.passWord = passWord;
    }
}