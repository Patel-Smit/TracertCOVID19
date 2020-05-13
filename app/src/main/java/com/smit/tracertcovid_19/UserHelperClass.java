package com.smit.tracertcovid_19;

public class UserHelperClass {
    String name;
    String dob;
    String city;
    String email;
    String password;

    /////Constructors

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String dob, String city, String email, String password) {
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.email = email;
        this.password = password;
    }


    /////////Getters

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    /////////Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
