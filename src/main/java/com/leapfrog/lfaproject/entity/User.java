/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.entity;

/**
 *
 * @author Lenovo
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String reactivatinCode;
    private String email;
    private boolean status;

    public User() {
    }

    public User(int id, String name, String password, String reactivatinCode, String email, boolean status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.reactivatinCode = reactivatinCode;
        this.email = email;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReactivatinCode() {
        return reactivatinCode;
    }

    public void setReactivatinCode(String reactivatinCode) {
        this.reactivatinCode = reactivatinCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
    
}
