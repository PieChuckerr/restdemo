package com.example.restdemo.web;

import com.example.restdemo.model.Message;
import com.example.restdemo.model.Profile;
import com.example.restdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    Map<Long, Message> listOfMessages = new LinkedHashMap<>();

    public List<Profile> getAllProfiles(){

        return profileService.getAllProfiles();
    }

    @GetMapping("/{profileId}")
    public Profile getProfileById(@PathVariable("profileId") long profileId) {
        return profileService.getProfile(profileId);
    }

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON)
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @PutMapping(value="/{profileId}",consumes = MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathVariable("profileId") long profileId, @RequestBody Profile profile) {
        return profileService.updateProfile(profileId, profile);
    }

    @DeleteMapping(value="/{profileId}",consumes = MediaType.APPLICATION_JSON)
    public void deleteProfile(@PathVariable("profileId") long profileId) {
        profileService.deleteProfile(profileId);
    }
}
