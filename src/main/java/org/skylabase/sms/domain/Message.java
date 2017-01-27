package org.skylabase.sms.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by daniel on 1/26/17.
 */
@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;

    @Column
    private String sender;

    @Column
    private Date sendTime;

    @Column
    private User user;

    private Set<Receiver> receivers;

    @Access(AccessType.PROPERTY)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "message_receiver", joinColumns = @JoinColumn(name = "message_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="receiver_id", referencedColumnName = "id"))
    public Set<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<Receiver> receivers) {
        this.receivers = receivers;
    }

    public Message() {}

    public Message(String message, String sender, Date sendTime, User user) {
        this.message = message;
        this.sender = sender;
        this.sendTime = sendTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                ", sendTime=" + sendTime +
                ", user=" + user +
                '}';
    }
}
