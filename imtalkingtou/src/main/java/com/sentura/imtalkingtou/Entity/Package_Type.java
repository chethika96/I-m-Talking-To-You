package com.sentura.imtalkingtou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name="Package_Type")
public class Package_Type {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fkPackage_Type")
    private List<User_Package> contentList;

    @Column(name = "Package_name")
    private String packageName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;
}
