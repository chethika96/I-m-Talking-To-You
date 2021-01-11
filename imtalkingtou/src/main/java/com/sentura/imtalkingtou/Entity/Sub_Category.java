package com.sentura.imtalkingtou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Sub_Category")
public class Sub_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FkMain_Category")
    private Main_Category fkMain_Category;

    @Column(name = "Sub_Name")
    private String sub_Name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Create_Date")
    private Date createdate= new Date();

    @Column(name = "Is_Active")
    private Boolean isactive;

    @Column(name = "Thumb_Img_Url")
    private String thumbImgUrl;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fkChoices")
    private List<Choices> contentList;

}
