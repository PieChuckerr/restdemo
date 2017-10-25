package com.example.restdemo.service;

import com.example.restdemo.exception.ProfileException;
import com.example.restdemo.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Profile getProfile(long profileId) throws ProfileException;
    Profile createProfile(Profile profile);
    Profile updateProfile(long profileId, Profile profile) throws ProfileException;
    boolean deleteProfile(long profileId);
}
