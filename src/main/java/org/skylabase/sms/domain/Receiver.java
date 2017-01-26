package org.skylabase.sms.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by daniel on 1/26/17.
 */
@Entity
@Table(name="receivers")
public class Receiver implements Serializable {

    private static final long serialVersionUID = 2650562120259097985L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String countryCode;

    private Set<Group> groups;

    public Receiver() {}

    public Receiver(String firstName, String lastName, String countryCode, Set<Group> groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Access(AccessType.PROPERTY)
    @ManyToMany(mappedBy = "receivers")
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", groups=" + groups +
                '}';
    }
}