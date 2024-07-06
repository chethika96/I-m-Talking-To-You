
package com.sentura.ImTalkingToYou.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table
public class Package_Type {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id", referencedColumnName="id")
    private List<User_Package> contentList1;
    private String packageName;
    private String description;
    private Date createdate= new Date();
    private Boolean isactive;

    @Override
    public String toString() {
        return "Package_Type{" +
                "id=" + id +
                ", contentList1=" + contentList1 +
                ", packageName='" + packageName + '\'' +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                ", isactive=" + isactive +
                '}';
    }
}
