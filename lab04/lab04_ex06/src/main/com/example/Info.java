package com.example;

import java.util.Arrays;

public class Info {
    private String name;
    private String email;
    private String birthday;
    private String birthTime;
    private String gender;
    private String country;
    private String[] ides;
    private double toeic;
    private String message;

    public Info(String name, String email, String birthday, String birthTime, String gender, String country, String[] ides, double toeic, String message) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.birthTime = birthTime;
        this.gender = gender;
        this.country = country;
        this.ides = ides;
        this.toeic = toeic;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getIdes() {
        return ides;
    }

    public void setIdes(String[] ides) {
        this.ides = ides;
    }

    public double getToeic() {
        return toeic;
    }

    public void setToeic(double toeic) {
        this.toeic = toeic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birthTime='" + birthTime + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", ides=" + Arrays.toString(ides) +
                ", toeic=" + toeic +
                ", message='" + message + '\'' +
                '}';
    }
}
