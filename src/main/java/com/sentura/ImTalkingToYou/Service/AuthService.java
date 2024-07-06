package com.sentura.ImTalkingToYou.Service;

import com.sentura.ImTalkingToYou.Dto.ResponseDto;
import com.sentura.ImTalkingToYou.Dto.UserDto;
import com.sentura.ImTalkingToYou.Dto.UserdataDto;
import com.sentura.ImTalkingToYou.Entity.User;
import com.sentura.ImTalkingToYou.Repository.UserRepository;
import com.sentura.ImTalkingToYou.Util.ObjectEntityConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(AuthService.class);

    public User findUserByEmail(String email) {
        return authRepository.findFirstByEmail(email);
    }
    public User findUserById(Long id){return authRepository.findFirstById(id);}

    public ResponseDto signUp(UserDto userDto) {

        try {
            User user;
            if (userDto.getId() != 0 || userDto.getEmail() != null) {
                user = findUserByEmail(userDto.getEmail());
                if (user != null) {
                    throw new Exception("user already exists!");
                } else {
                    userDto.setId(0);
                    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
                    userDto.setActive(true);
                    user = authRepository.saveAndFlush(new ObjectEntityConverter().userDtoToEntity(userDto));
                }
            } else {
                userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userDto.setActive(true);
                user = authRepository.saveAndFlush(new ObjectEntityConverter().userDtoToEntity(userDto));
            }
            userDto.setPassword(null);
            userDto.setId(user.getId());
            return new ResponseDto("success", userDto);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }

    public ResponseDto changePassword(UserDto userDto) {

        try {
            User user;
            if (userDto.getId() != 0 && userDto.getEmail() != null) {
                user = findUserByEmail(userDto.getEmail());
                if (user != null && user.getId() == userDto.getId()) {
                    if (userDto.getPassword() != null)
                        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
                    authRepository.saveAndFlush(new ObjectEntityConverter().userDtoToEntity(userDto));
                } else {
                    throw new Exception("user not found!");
                }
            } else {
                throw new Exception("user not found!");
            }
            userDto.setPassword(null);
            return new ResponseDto("success", userDto);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }


/*###########################################################################################################*/
public ResponseDto del(UserDto userDto) {

    try {
        User user;
        if (userDto.getId() != 0 && userDto.getEmail() != null) {
            user = findUserByEmail(userDto.getEmail());
            if (user != null && user.getId() == userDto.getId()) {
                if (userDto.getPassword() != null)
                    userDto.setActive(false);
                authRepository.saveAndFlush(new ObjectEntityConverter().userDtoToEntity(userDto));
            } else {
                throw new Exception("user not found!");
            }
        } else {
            throw new Exception("user not found!");
        }
        userDto.setPassword(null);
        return new ResponseDto("success", userDto);

    } catch (Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        return new ResponseDto(e.getMessage(), "500", null);
    }
}


}
