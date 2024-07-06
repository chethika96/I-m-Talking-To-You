package com.sentura.ImTalkingToYou.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName;
    private String lName;
    private String email;
    private String password;
    private String number;
    private Date createdate= new Date();
    private Boolean isactive;
    private String isDelete;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name ="id", referencedColumnName="id")
    private List<Notifications> notifications;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name ="id", referencedColumnName="id")
    private List<User_Package> user_package;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name ="id", referencedColumnName="id")
    private List<Review> review;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                ", isDelete='" + isDelete + '\'' +
                ", notifications=" + notifications +
                ", user_package=" + user_package +
                ", review=" + review +
                '}';
    }
}



