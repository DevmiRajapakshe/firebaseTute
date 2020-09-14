package com.example.firebaselab02;

public class Student {
    private String ID;
    private String name;
    private String address;
    private Integer conno;

    public Student() {
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getConno() {
        return conno;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setConno(Integer conno) {
        this.conno = conno;
    }
}
