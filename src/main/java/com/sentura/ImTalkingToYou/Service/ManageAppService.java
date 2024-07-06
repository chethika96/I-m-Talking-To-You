package com.sentura.ImTalkingToYou.Service;

import com.sentura.ImTalkingToYou.Dto.*;
import com.sentura.ImTalkingToYou.Entity.Main_Category;
import com.sentura.ImTalkingToYou.Entity.Package_Type;
import com.sentura.ImTalkingToYou.Entity.Sub_Category;
import com.sentura.ImTalkingToYou.Entity.User;
import com.sentura.ImTalkingToYou.Repository.MainRepository;
/*import com.sentura.ImTalkingToYou.Repository.PackageRepository;
import com.sentura.ImTalkingToYou.Repository.SubRepository;*/
import com.sentura.ImTalkingToYou.Repository.PackageRepository;
import com.sentura.ImTalkingToYou.Repository.SubRepository;
import com.sentura.ImTalkingToYou.Repository.UserRepository;
import com.sentura.ImTalkingToYou.Util.ObjectEntityConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ManageAppService {
    @Autowired
    private MainRepository mainRepository;

    @Autowired
    private SubRepository subRepository;

    @Autowired
    private PackageRepository packageRepository;

    /* @Autowired
     private PackageRepository packageRepository;
 */
    private Logger logger = LoggerFactory.getLogger(AuthService.class);


    public ResponseDto getAllMain() {
        try {
            List<MainDto> mains = new ArrayList<>();
            List<Main_Category> mainList = mainRepository.findAll();
            if (!mainList.isEmpty()) {
                for (Main_Category main : mainList) {
                    mains.add(new ObjectEntityConverter().mainEntityToDto(main));
                }
            }
            return new ResponseDto("success", mains);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }


    }

    public ResponseDto getAllSub() {
        try {
            List<SubDto> subs = new ArrayList<>();
            List<Sub_Category> subList = subRepository.findAll();
            if (!subList.isEmpty()) {
                for (Sub_Category sub : subList) {
                    subs.add(new ObjectEntityConverter().subEntityToDto(sub));
                }
            }
            return new ResponseDto("success", subs);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }


    }

    public ResponseDto updateMain(MainDto mainDto) {

        try {
            Main_Category mainCat = mainRepository.findById(mainDto.getId());
            mainCat.setMainName(mainDto.getMainName());
            mainCat.setDescription(mainDto.getDescription());
            mainCat.setThumbImgUrl(mainDto.getThumbImgUrl());


            mainRepository.saveAndFlush(mainCat);
            return new ResponseDto("success", mainCat);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }


    public ResponseDto updateSub(SubDto subDto) {

        try {
            Sub_Category subCat = subRepository.findById(subDto.getId());
            subCat.setSub_Name(subDto.getSubName());
            subCat.setDescription(subDto.getDescription());
            subCat.setThumbImgUrl(subDto.getThumbImgUrl());


            subRepository.saveAndFlush(subCat);
            return new ResponseDto("success", subCat);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }


    public ResponseDto deleteMain(MainDto mainDto) {

        try {
            Main_Category main_category;
            if (mainDto.getId() != 0) {


                main_category = mainRepository.findById(mainDto.getId());
                main_category.setIsactive(false);
                mainRepository.saveAndFlush(main_category);
                mainDto.setActive(false);
                return new ResponseDto("success", mainDto);
            } else {

                return new ResponseDto("Main Category not found", null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }

    }

    public ResponseDto deleteSub(SubDto subDto) {

        try {
            Sub_Category sub_category;
            if (subDto.getId() != 0) {


                sub_category = subRepository.findById(subDto.getId());
                sub_category.setIsactive(false);
                subRepository.saveAndFlush(sub_category);
                subDto.setActive(false);
                return new ResponseDto("success", subDto);
            } else {

                return new ResponseDto("Main Category not found", null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }

    }


    public ResponseDto addMain(MainDto mainDto) {

        try {
            mainRepository.saveAndFlush(new ObjectEntityConverter().mainDtoToEntity(mainDto));
            return new ResponseDto("Success", mainDto);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }


    }

    public ResponseDto addSub(SubDto subDto) {

        try {

            subRepository.saveAndFlush(new ObjectEntityConverter().subDtoToEntity(subDto));

            return new ResponseDto("Success", subDto);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }


    }




   /* public ResponseDto getcategory(String name) {
        try {

            List<Main_Category> main = mainRepository.findByMainName(name);
            List<Sub_Category> sub = subRepository.findBySub_Name(name);
            if (!main.isEmpty()) {
                List<MainDto> mainDto = new ArrayList<>();
                for (Main_Category mains : main) {
                    mainDto.add(new ObjectEntityConverter().mainEntityToDto(mains));

                }


                return new ResponseDto("Success", mainDto);
            } else {
                if (!sub.isEmpty()) {
                    List<SubDto> subDto = new ArrayList<>();
                    for (Sub_Category subs : sub) {

                        subDto.add(new ObjectEntityConverter().subEntityToDto(subs));
                    }

                    return new ResponseDto("Success", subDto);

                } else {
                    return new ResponseDto("No Categories Found", null);

                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);

        }
    }*/



    public ResponseDto getPackages() {
        try {
            List<PackageDto> packageDto = new ArrayList<>();
            List<Package_Type> package_type= packageRepository.findAll();
            if(!package_type.isEmpty()){
                for(Package_Type package_types:package_type){
                    packageDto.add(new ObjectEntityConverter().packageEntityToPackageDto(package_types));

                }

                return new ResponseDto("success",packageDto);
            }
    else
        return new ResponseDto("No packages available",null);

        } catch(Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(), "500", null);
        }
    }




    public ResponseDto updatePackage(PackageDto packageDto){

        try{
            if(packageDto.getPackageName()!=null) {
                Package_Type packageType = packageRepository.findByPackageName(packageDto.getPackageName());
                packageType.setPackageName(packageDto.getPackageName());
                packageType.setDescription(packageDto.getDescription());
                packageRepository.saveAndFlush(packageType);
                return new ResponseDto("Success", packageDto);
            }
            else
                return new ResponseDto("No packages found", null);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(),"500",null);


        }


    }

    public ResponseDto addPackage(PackageDto packageDto){

        try {


            packageRepository.saveAndFlush(new ObjectEntityConverter().packageDtoToPackageEntity(packageDto));


            return new ResponseDto("Success", packageDto);

        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseDto(e.getMessage(),"500",null);



        }



    }

    public ResponseDto getPayments(){
        try{




        }

        catch{}


    }


        }







