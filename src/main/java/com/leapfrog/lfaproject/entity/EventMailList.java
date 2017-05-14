/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.entity;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class EventMailList {

    private int id;
    private Event event;
    private Email email;
    private Date invite_date;
    private boolean confirm;
    private User user;

    public EventMailList() {
    }

    public EventMailList(int id, Event event, Email email, Date invite_date, boolean confirm) {
        this.id = id;
        this.event = event;
        this.email = email;
        this.invite_date = invite_date;
        this.confirm = confirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Date getInvite_date() {
        return invite_date;
    }

    public void setInvite_date(Date invite_date) {
        this.invite_date = invite_date;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    

}
