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
public class Email {

    private int id;
    private String name,email_id;
    private User user;

    public Email() {
    }

    public Email(int id, String name, String email_id, User user) {
        this.id = id;
        this.name = name;
        this.email_id = email_id;
        this.user = user;
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
    
    

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
