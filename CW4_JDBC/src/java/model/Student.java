/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Date DOB;

    public Student() {
    }

    public Student(int id, String name, boolean gender, Date DOB) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
    }
    public Student(String name, boolean gender, Date DOB) {
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
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

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDob() {
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(DOB);
    }

    public Date getDateOB(){
        return DOB;
    }
    public void setDob(String dob) {
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.DOB = new Date(sd.parse(dob).getTime());
        } catch (ParseException ex) {
            throw new RuntimeException("Invalid DOB");
        }
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", DOB=" + DOB + '}';
    }
    
    
}
