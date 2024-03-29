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
    private Date sendTime;

    @Column
    private User user;

    private Set<Receiver> receivers;

    @Access(AccessType.PROPERTY)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "receivers_messages", joinColumns = @JoinColumn(name = "messages_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="receivers_id", referencedColumnName = "id"))
    public Set<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<Receiver> receivers) {
        this.receivers = receivers;
    }

    public Message() {}

    public Message(String message, Date sendTime, User user) {
        this.message = message;
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne
    @JoinColumn(name = "users_id")
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
                ", sendTime=" + sendTime +
                ", user=" + user +
                '}';
    }
}
