package com.klasevich.console.project.entity;

import java.util.List;

public class User {
    private String name;
    private String surname;
    private String email;
    private List<Role> roles;
    private List<PhoneNumber> phoneNumbers;

    public User() {
    }

    public User(String name, String surname, String email, List<Role> roles, List<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        return phoneNumbers != null ? phoneNumbers.equals(user.phoneNumbers) : user.phoneNumbers == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (phoneNumbers != null ? phoneNumbers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", roles=").append(roles);
        sb.append(", phoneNumbers=").append(phoneNumbers);
        sb.append('}');
        return sb.toString();
    }
}
