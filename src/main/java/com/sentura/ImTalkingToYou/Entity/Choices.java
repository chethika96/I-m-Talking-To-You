package com.sentura.ImTalkingToYou.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class Choices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Sub_Category sub_Category;


    private String choice_Name;
    private String description;
    private Date createdate= new Date();
    private Boolean isactive;
    private String thumbImgUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<Multimedia> contentList;

    @Override
    public String toString() {
        return "Choices{" +
                "id=" + id +
                ", sub_Category=" + sub_Category +
                ", choice_Name='" + choice_Name + '\'' +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                ", thumbImgUrl='" + thumbImgUrl + '\'' +
                ", contentList=" + contentList +
                '}';
    }
}
