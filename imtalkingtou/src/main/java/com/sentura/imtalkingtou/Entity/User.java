package com.sentura.imtalkingtou.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "FName")
    private String fName;

    @Column(name = "LName")
    private String lName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Number")
    private String number;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;

    @Column(name = "Is_Delete")
    private String isdelete;






}
