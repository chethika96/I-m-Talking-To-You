package com.sentura.ImTalkingToYou.Util;

import com.sentura.ImTalkingToYou.Dto.*;
import com.sentura.ImTalkingToYou.Entity.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ObjectEntityConverter {

    private DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public UserDto userEntityToDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getFName() + " " + user.getLName());
        userDto.setEmail(user.getEmail());
        userDto.setActive(user.getIsactive());
        userDto.setPassword(user.getPassword());

        return userDto;
    }


    public User userDtoToEntity(UserDto userDto) {

        User user = new User();
        user.setEmail(userDto.getEmail());
//        user.setFullName(userDto.getFullName());
        user.setId(userDto.getId());
        user.setIsactive(userDto.isActive());
        if (userDto.getPassword() != null) user.setPassword(userDto.getPassword());

        return user;
    }

    public Main_Category mainDtoToEntity(MainDto mainDto) {
        Main_Category main = new Main_Category();
        main.setMainName(mainDto.getMainName());
        main.setDescription(mainDto.getDescription());
        main.setIsactive(mainDto.isActive());


        return main;
    }

    public MainDto mainEntityToDto(Main_Category mainCat) {
        MainDto mainDto = new MainDto();
        mainDto.setId(mainCat.getId());
        mainDto.setMainName(mainCat.getMainName());
        mainDto.setDescription(mainCat.getDescription());
        mainDto.setActive(mainCat.isIsactive());


        return mainDto;
    }



    public Sub_Category subDtoToEntity(SubDto subDto) {
        Sub_Category sub= new Sub_Category();
        sub.setId(subDto.getId());
        sub.setSub_Name(subDto.getSubName());
        sub.setDescription(subDto.getDescription());
        sub.setIsactive(subDto.isActive());




        return sub;
    }
    public SubDto subEntityToDto(Sub_Category subCat) {
        SubDto subDto = new SubDto();
        subDto.setId(subCat.getId());
        subDto.setSubName(subCat.getSub_Name());
        subDto.setDescription(subCat.getDescription());
        subDto.setActive(subCat.isIsactive());

        return subDto;
    }

    public PackageDto packageEntityToPackageDto(Package_Type package_type){

        PackageDto packageDto= new PackageDto();
        packageDto.setPackageName(package_type.getPackageName());
        packageDto.setDescription(package_type.getDescription());

        return packageDto;


    }

    public Package_Type packageDtoToPackageEntity(PackageDto packageDto){

        Package_Type package_type= new Package_Type();
        package_type.setPackageName(packageDto.getPackageName());
        package_type.setDescription(packageDto.getDescription());
        package_type.setIsactive(true);
        return package_type;

    }

}
