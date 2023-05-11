package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String firstname;
    private String lastname;
    private String address;
    private String email;

    @Min(value = 10)
    @Max(value = 10)
    private String phone;

    //Recruitment Date
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date recruitmentDate;

    @ManyToOne
    private Job job;

    public Employee() {
        super();
    }

    public Employee(String firstname, String lastname, String address, String email, String phone, Date recruitmentDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.recruitmentDate=recruitmentDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Date getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(Date recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", recruitmentDate=" + recruitmentDate +
                '}';
    }
}
