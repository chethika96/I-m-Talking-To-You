package com.sentura.ImTalkingToYou.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDto {

    private String userName;
    private String packageType;
    private String startDate;
    private String endDate;


}
