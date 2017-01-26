package org.skylabase.sms.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by daniel on 1/26/17.
 */
@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    private Set<Receiver> receivers;

    public Group() {}

    public Group(String name, String description, Set<Receiver> receivers) {
        this.name = name;
        this.description = description;
        this.receivers = receivers;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "receivers_groups", joinColumns = @JoinColumn(name="groups_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="receivers_id", referencedColumnName = "id"))
    public Set<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<Receiver> receivers) {
        this.receivers = receivers;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", receivers=" + receivers +
                '}';
    }
}
