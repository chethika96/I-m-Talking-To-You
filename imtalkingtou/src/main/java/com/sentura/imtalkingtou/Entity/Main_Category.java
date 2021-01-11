package com.sentura.imtalkingtou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name="Main_Category")
public class Main_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "MainName")
    private String mainName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;

    @Column(name = "Thumb_Img_Url")
    private String thumbImgUrl;

    @ManyToMany
    @JoinColumn(name="FkUser_Package")
    private User fkUser_Package;





}
