package com.sentura.ImTalkingToYou.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class Main_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mainName;
    private String description;
    private Date createdate= new Date();
    private boolean isactive=true;
    private String thumbImgUrl;
   /* @ManyToMany(mappedBy = "main_category")
    private List<User_Package> user_Package;*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "id")
    private List<Sub_Category> sub_category;

    @Override
    public String toString() {
        return "Main_Category{" +
                "id=" + id +
                ", mainName='" + mainName + '\'' +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                ", thumbImgUrl='" + thumbImgUrl + '\'' +
               /* ", user_Package=" + user_Package +*/
                ", sub_category=" + sub_category +
                '}';
    }
}
