/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.entity;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Event {
    private int id;
   private String title;
   private String description;
   private Date added_date;
   private String start_date;
   private String end_date;
   private boolean invite,status;
   private User user;

    public Event() {
    }

    public Event(int id, String title, String description, Date added_date, String start_date, String end_date, boolean invite, boolean status, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.added_date = added_date;
        this.start_date = start_date;
        this.end_date = end_date;
        this.invite = invite;
        this.status = status;
        this.user = user;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }
    
    

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public boolean isInvite() {
        return invite;
    }

    public void setInvite(boolean invite) {
        this.invite = invite;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
   
    
}
