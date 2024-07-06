package com.sentura.ImTalkingToYou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Multimedia multimedia;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private String rate;
    private String comment;
    private Date createdate= new Date();
    private Boolean isactive;


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", multimedia=" + multimedia +
                ", user=" + user +
                ", rate='" + rate + '\'' +
                ", comment='" + comment + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                '}';
    }
}
