package com.sentura.ImTalkingToYou.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubDto {

    private long id;
    private String subName;
    private String description;
    private boolean active;
    private String thumbImgUrl;


}
