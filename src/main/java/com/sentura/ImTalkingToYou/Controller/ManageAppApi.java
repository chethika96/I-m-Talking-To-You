package com.sentura.ImTalkingToYou.Controller;

import com.sentura.ImTalkingToYou.Dto.MainDto;
import com.sentura.ImTalkingToYou.Dto.PackageDto;
import com.sentura.ImTalkingToYou.Dto.ResponseDto;
import com.sentura.ImTalkingToYou.Dto.SubDto;
import com.sentura.ImTalkingToYou.Entity.Package_Type;
import com.sentura.ImTalkingToYou.Service.ManageAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manageApp")
public class ManageAppApi {
    @Autowired
    private ManageAppService appService;

    @GetMapping("/getallmain")
    public ResponseDto getAllMain() {
        return appService.getAllMain();

    }

    @GetMapping("/getallsub")
    public ResponseDto getAllSub() {
        return appService.getAllSub();

    }

    @PutMapping("/updatemain")
    private ResponseDto updateMain(@RequestBody MainDto mainDto) {

        return appService.updateMain(mainDto);
    }

    @PutMapping("/updatesub")
    private ResponseDto updateSub(@RequestBody SubDto subDto) {

        return appService.updateSub(subDto);
    }


    @DeleteMapping("/deletemain")
    private ResponseDto deleteMain(@RequestBody MainDto mainDto) {

        return appService.deleteMain(mainDto);
    }


    @DeleteMapping("/deletesub")
    private ResponseDto deleteSub(@RequestBody SubDto subDto) {

        return appService.deleteSub(subDto);
    }

    @PostMapping("/addMain")
    private ResponseDto addMain(MainDto mainDto) {

        return appService.addMain(mainDto);
    }


    @PostMapping("/addSub")
    private ResponseDto addSub(SubDto subDto) {
        return appService.addSub(subDto);

    }
   /* @PostMapping("/getcategory")
    private ResponseDto getcategory(String name) {

        return appService.getcategory(name);

    }*/


    @GetMapping("/getpackages")
    private ResponseDto getPackages() {

        return appService.getPackages();
    }


    @PutMapping("/updatepackage")
    private ResponseDto updatePackage(@RequestBody PackageDto packageDto) {

        return appService.updatePackage(packageDto);
    }


    @PostMapping("/addpackage")
    private ResponseDto addPackage(PackageDto packageDto){

        return appService.addPackage(packageDto);

    }
  @GetMapping("/getpayments")
    private ResponseDto getPayments()
  {
      return appService.getPayments();

  }
/*
    @PutMapping("/uploadvideo")
    private ResponseDto uploadVideo(VideoDto videoDto) {

        return ResponseDto appService.uploadVideo(videoDto);

    }*/
}

