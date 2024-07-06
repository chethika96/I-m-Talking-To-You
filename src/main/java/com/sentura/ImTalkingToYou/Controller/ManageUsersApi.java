package com.sentura.ImTalkingToYou.Controller;

import com.sentura.ImTalkingToYou.Dto.ResponseDto;
import com.sentura.ImTalkingToYou.Dto.UserDto;
import com.sentura.ImTalkingToYou.Service.ManageUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/manageUsers")
public class ManageUsersApi {


    @Autowired
    private ManageUsersService manageService;

    @GetMapping("/getAll")
    public ResponseDto getAll(String name) {

        return manageService.getAll(name);
    }


    @DeleteMapping("/delete")
    public ResponseDto delete(@RequestBody UserDto userDto){

        return manageService.delete(userDto);
    }
}



