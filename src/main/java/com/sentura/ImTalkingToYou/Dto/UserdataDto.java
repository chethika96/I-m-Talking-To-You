package com.sentura.ImTalkingToYou.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class UserdataDto {

    private long id;
    private String UserName;
    private String Email;
    private boolean active;

}
