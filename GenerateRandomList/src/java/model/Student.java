/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuant
 */
public class Student {
    private int id;
    private String name;
    private boolean gender;
    private Date dob;

    public Student() {
    }

    public Student(int id, String name, boolean gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

     public String getDob() {
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(dob);
    }

    public Date getDateOB(){
        return dob;
    }
    public void setDob(String dob) {
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dob = new java.sql.Date(sd.parse(dob).getTime());
        } catch (ParseException ex) {
            throw new RuntimeException("Invalid DOB");
        }
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + '}';
    }
    
    
    
}
