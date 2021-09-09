package com.project.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double cash_account;
    private Role role;

    public User(String firstName, String secondName, String email, String password, double cash_account, Role role) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.email = email;
        this.password = password;
        this.cash_account = cash_account;
        this.role = role;
    }

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCash_account(double cash_account) {
        this.cash_account = cash_account;
    }

    public double getCash_account() {
        return cash_account;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getFio_user() {
        return getFirstName() + " " +  getLastName();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(firstName).append('\'');
        sb.append(", surname='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", cash account='").append(cash_account).append('\'');
        sb.append(", role =").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                cash_account == cash_account;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, cash_account);
    }

}
