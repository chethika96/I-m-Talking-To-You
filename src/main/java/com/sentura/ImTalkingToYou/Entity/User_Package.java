package com.sentura.ImTalkingToYou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class User_Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdate = new Date();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Package_Type package_Type;
 /*   @ManyToMany
    private List<Main_Category> main_Category;*/

    @Override
    public String toString() {
        return "User_Package{" +
                "id=" + id +
                ", createdate=" + createdate +
                ", user=" + user +
                ", package_Type=" + package_Type +
               /* ", main_Category=" + main_Category +*/
                '}';
    }
}
