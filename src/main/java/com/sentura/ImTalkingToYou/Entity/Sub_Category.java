package com.sentura.ImTalkingToYou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class Sub_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Main_Category main_Category;
    private String sub_Name;
    private String description;
    private Date createdate= new Date();
    private boolean isactive=true;
    private String thumbImgUrl;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<Choices> contentList;

    @Override
    public String toString() {
        return "Sub_Category{" +
                "id=" + id +
                ", main_Category=" + main_Category +
                ", sub_Name='" + sub_Name + '\'' +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                ", thumbImgUrl='" + thumbImgUrl + '\'' +
                ", contentList=" + contentList +
                '}';
    }
}
