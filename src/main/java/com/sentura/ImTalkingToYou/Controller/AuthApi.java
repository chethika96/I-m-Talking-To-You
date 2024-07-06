
package com.sentura.ImTalkingToYou.Controller;

import com.sentura.ImTalkingToYou.Configuration.JwtAuthController;
import com.sentura.ImTalkingToYou.Dto.ResponseDto;
import com.sentura.ImTalkingToYou.Configuration.JwtRequest;
import com.sentura.ImTalkingToYou.Configuration.JwtResponse;
import com.sentura.ImTalkingToYou.Dto.AuthDto;
import com.sentura.ImTalkingToYou.Dto.UserDto;
import com.sentura.ImTalkingToYou.Entity.User;
import com.sentura.ImTalkingToYou.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/auth")
public class AuthApi {

    @Autowired
    private JwtAuthController jwtAuthenticationController;

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseDto authenticate(@RequestBody AuthDto authDto) {

        try {
            JwtRequest jwtRequest = new JwtRequest();
            jwtRequest.setUsername(authDto.getEmail());
            jwtRequest.setPassword(authDto.getPassword());

            JwtResponse jwtResponse = jwtAuthenticationController.generateAuthenticationToken(jwtRequest);

            return new ResponseDto(null, jwtResponse.getToken());

        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }
    @PostMapping("/signUp")
    public ResponseDto signUp(@RequestBody UserDto userDto) {

        return authService.signUp(userDto);
    }

    @PostMapping("/changePassword")
    public ResponseDto changePassword(@RequestBody UserDto userDto) {

        return authService.changePassword(userDto);
    }






}