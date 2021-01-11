package com.sentura.imtalkingtou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Multimedia")
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="FkChoices")
    private Choices fkChoices;

    @Column(name = "Description")
    private String description;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;

    @Column(name = "Thumb_Img_Url")
    private String thumbImgUrl;

    @Column(name = "Video_Title")
    private String videoTitle;

    @Column(name = "Video_Url")
    private String videoUrl;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fkReview")
    private List<Review> contentList;

}
