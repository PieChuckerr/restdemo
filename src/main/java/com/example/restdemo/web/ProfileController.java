package com.example.restdemo.web;

import com.example.restdemo.exception.InvalidProfileIdException;
import com.example.restdemo.exception.ProfileException;
import com.example.restdemo.exception.ProfileNotFoundException;
import com.example.restdemo.model.Message;
import com.example.restdemo.model.Profile;
import com.example.restdemo.resource.MessageResource;
import com.example.restdemo.resource.ProfileResource;
import com.example.restdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    Map<Long, Message> listOfMessages = new LinkedHashMap<>();

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity <Resources< ProfileResource >> getAllProfiles() throws URISyntaxException {
        List<Profile> profiles = profileService.getAllProfiles();
        List<ProfileResource> profileResources = new ArrayList<>();
        for(Profile profile : profiles) {
            profileResources.add(new ProfileResource(profile));
        }

        Resources<ProfileResource> messageResourceEntities = new Resources<>(profileResources);
        return  ResponseEntity.ok(messageResourceEntities);
    }

    @GetMapping(value = "/{profileId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable("profileId") long profileId) {
        ProfileResource profileResource = null;
        profileResource = new ProfileResource(profileService.getProfile(profileId));
        return ResponseEntity.ok(profileResource);
    }

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProfileResource> createProfile(@RequestBody Profile profile) {
        ProfileResource profileResource = new ProfileResource(profileService.createProfile(profile));
        return ResponseEntity.status(HttpStatus.CREATED).body(profileResource);
    }

    @PutMapping(value="/{profileId}",consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ProfileResource> updateProfile(@PathVariable("profileId") long profileId, @RequestBody Profile profile) {
        ProfileResource profileResource = null;

         profileResource = new ProfileResource(profileService.updateProfile(profileId, profile));
         return ResponseEntity.ok(profileResource);
    }

    @DeleteMapping(value="/{profileId}",consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> deleteProfile(@PathVariable("profileId") long profileId) {
        profileService.deleteProfile(profileId);
        return ResponseEntity.status(204).build();
    }
}
