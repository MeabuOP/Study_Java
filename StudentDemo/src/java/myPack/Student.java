/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPack;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Student {
    private int ID;
    private String name;
    private boolean gender;
    private Date dob;

    public Student(int ID, String name, boolean gender, Date dob) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
}
