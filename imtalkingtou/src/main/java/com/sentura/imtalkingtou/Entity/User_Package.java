package com.sentura.imtalkingtou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="User_Package")
public class User_Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @ManyToOne
    @JoinColumn(name="FkUser")
    private User fkUser;

    @ManyToOne
    @JoinColumn(name="FkPackage_Type")
    private User fkPackage_Type;

    @ManyToMany
    @JoinColumn(name="FkMain_Category")
    private User fkMain_Category;



}
