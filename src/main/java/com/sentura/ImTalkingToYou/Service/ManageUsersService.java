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

import java.util.ArrayList;
import java.util.List;

@Service
public class ManageUsersService {
    @Autowired
    private UserRepository userRepository;



    private Logger logger = LoggerFactory.getLogger(AuthService.class);

    public User findUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
    public User findUserById(Long id){return userRepository.findFirstById(id);}


    public ResponseDto getAll(String name) {

        try {
            if(name !=null) {
                List<UserDto> users = new ArrayList<>();
                List<User> userList = userRepository.findByFNameOrLName(name);
                if (!userList.isEmpty()) {
                    for (User user : userList) {
                        users.add(new ObjectEntityConverter().userEntityToDto(user));

                    }
                }
                return new ResponseDto("success", users);
            }
            else{

                List<UserDto> users = new ArrayList<>();
                List<User> userList = userRepository.findAll();
                if (!userList.isEmpty()) {
                    for (User user : userList) {
                        users.add(new ObjectEntityConverter().userEntityToDto(user));

                    }
                }
                return new ResponseDto("success", users);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }
    public ResponseDto delete(UserDto userDto) {

        try {
            User user;
            if(userDto.getId()!=0){

            user = findUserById(userDto.getId());
            if (user != null ) {
                user.setIsactive(false);
                userRepository.saveAndFlush(user);
                user.setPassword(null);
                userDto =new ObjectEntityConverter().userEntityToDto(user);


            } else {
                throw new Exception("user not found!");
            }
            }



            return new ResponseDto("success", userDto);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }

    }
}
