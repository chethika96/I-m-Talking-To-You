package com.sentura.ImTalkingToYou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private String description;
    private Date createdate= new Date();

    @Override
    public String toString() {
        return "Notifications{" +
                "id=" + id +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}
