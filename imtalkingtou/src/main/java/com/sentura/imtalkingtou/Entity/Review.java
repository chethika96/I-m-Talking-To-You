package com.sentura.imtalkingtou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name="Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="FkMultimedia")
    private Multimedia fkMultimedia;

    @ManyToOne
    @JoinColumn(name="FkUser")
    private Multimedia fkUser;

    @Column(name = "Rate")
    private String rate;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;



}
