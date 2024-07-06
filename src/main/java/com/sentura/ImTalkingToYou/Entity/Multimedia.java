package com.sentura.ImTalkingToYou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Choices choices;
    private String description;
    private Date createdate = new Date();
    private Boolean isactive;
    private String thumbImgUrl;
    private String videoTitle;
    private String videoUrl;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name ="id", referencedColumnName="id")
    private List<Review> contentList;

    @Override
    public String toString() {
        return "Multimedia{" +
                "id=" + id +
                ", choices=" + choices +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                ", thumbImgUrl='" + thumbImgUrl + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", contentList=" + contentList +
                '}';
    }
}
