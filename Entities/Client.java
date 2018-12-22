package Entities;

import java.io.Serializable;

public class Client implements Serializable{
    String username;
    String name;
    String password;
    String email;
    String address;
    String job;
    String nationalNumber;
    int age;
    int ID;

    public Client(String username, String name, String password, String email, String address, String job, String nationalNumber, int age) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.job = job;
        this.nationalNumber = nationalNumber;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
