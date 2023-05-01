/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.springbootweb.mvc;

/**
 *
 * @author vanting
 */
public class Student {

    private long id;
    private String fname;
    private String lname;
    private String gender;

    public Student(long id, String fname, String lname, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
    }

    // getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fname + " " + lname;
    }

}
