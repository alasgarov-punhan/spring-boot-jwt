package com.haydikodlayalim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PUNHAN
 * @created 09/02/2022
 * @project spring-boot-jwt
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    private Integer id;
    private String name;

    @Column(name = "USER_NAME")
    private String userName;

    private Integer age;

    @Column(name = "PASS")
    private Integer password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
