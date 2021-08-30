package com.project.entity;

import java.util.Objects;

public class Master {
    private int id;
    private String firstName;
    private String secondName;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Master{");
        sb.append("id=").append(id);
        sb.append(", name='").append(firstName).append('\'');
        sb.append(", surname='").append(secondName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        Master master = (Master) o;
        return id == master.id &&
                firstName.equals(master.firstName) &&
                secondName.equals(master.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName);
    }
}
