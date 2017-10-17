package com.example.restdemo.web;

import com.example.restdemo.model.Profile;
import com.example.restdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/profile/")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    public List<Profile> getAllProfiles(){

        return profileService.getAllProfiles();
    }
}
