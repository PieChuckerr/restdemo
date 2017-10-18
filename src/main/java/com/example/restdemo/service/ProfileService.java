package com.example.restdemo.service;

import com.example.restdemo.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Profile getProfile(long profileId);
    Profile createProfile(Profile profile);
    Profile updateProfile(long profileId, Profile profile);
    boolean deleteProfile(long profileId);
}
