/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.entity;

import com.leapfrog.lfaproject.dao.EmailDAO;
import com.leapfrog.lfaproject.dao.EventDAO;
import com.leapfrog.lfaproject.dao.EventMailListDAO;
import com.leapfrog.lfaproject.dao.UserDAO;
import com.leapfrog.lfaproject.dao.impl.EmailDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventMailListDAOImpl;
import com.leapfrog.lfaproject.dao.impl.UserDAOImpl;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Lenovo
 */
public class SendEmail {

    private String from, to, host, subject, body;

    public SendEmail() {
    }

    public SendEmail(String from, String to, String host, String subject, String body) {
        this.from = from;
        this.to = to;
        this.host = host;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void send() {

        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendMultipleMessage(int userId, int event_id, boolean confirm) {
        EmailDAO emailDAO = new EmailDAOImpl();
        EventMailListDAO emlDAO = new EventMailListDAOImpl();
        EventDAO eventDAO = new EventDAOImpl();
        UserDAO userDAO=new UserDAOImpl();

        

        try {
            // Create a default MimeMessage object.

            // Set To: header field of the header.
            try {
                Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
                for (Email e : emailDAO.getAll(userId)) {
                    MimeMessage message = new MimeMessage(session);

                    // Set From: header field of the header.
                    message.setFrom(new InternetAddress(from));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(e.getEmail_id()));
                    // Set Subject: header field
                    message.setSubject(subject);

                    // Now set the actual message
                    message.setText(body);

                    // Send message
                    Transport.send(message);
                    System.out.println("Sent message successfully....");

                    EventMailList eml = new EventMailList();
                    Event event = eventDAO.getById(event_id);
                    eml.setEvent(event);
                    Email em = emailDAO.getById(e.getId());
                    eml.setEmail(em);

                    eml.setConfirm(confirm);
                User user=userDAO.getById(userId);
                    eml.setUser(user);
                    emlDAO.insert(eml);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
