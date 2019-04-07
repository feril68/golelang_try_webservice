package com.kelompok5.golelang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required")
    @Column(updatable = false, unique = true, nullable = false)
    @Size(max = 50, message = "Max is 50 char")
    private String userName;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Max is 50 char")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    private String biodata;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date join_date;

    public User() {

    }

    @PrePersist
    protected void onCreate() {
        this.join_date = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }
}
