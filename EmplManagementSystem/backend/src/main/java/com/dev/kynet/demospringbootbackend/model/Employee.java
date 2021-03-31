package com.dev.kynet.demospringbootbackend.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empID;
    @Column(name="first_name")
    private String fname;
    @Column(name="last_name")
    private String lname;
    @Column(name = "emp_email")
    private String email;

    public Employee() {

    }

    public Employee(long empID, String fname, String lname, String email) {
        super();
        this.empID = empID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
