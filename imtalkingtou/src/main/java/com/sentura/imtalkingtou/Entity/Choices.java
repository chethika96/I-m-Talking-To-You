package com.sentura.imtalkingtou.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Choices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="FkSub_Category")
        private Sub_Category fkSub_Category;

    @Column(name = "Choice_Name")
    private String choice_Name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;

    @Column(name = "Thumb_Img_Url")
    private String thumbImgUrl;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fkMultimedia")
    private List<Multimedia> contentList;
}
