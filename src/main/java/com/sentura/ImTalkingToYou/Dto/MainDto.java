package com.sentura.ImTalkingToYou.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class MainDto {

    private long id;
    private String mainName;
    private String description;
    private boolean active;
    private String thumbImgUrl;

}
