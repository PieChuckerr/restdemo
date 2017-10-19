package com.example.restdemo.dao;

import com.example.restdemo.exception.ProfileException;
import com.example.restdemo.model.Profile;

import java.util.List;

public interface ProfileDao {
    List<Profile> getAll();
    Profile get(long profileId) throws ProfileException;
    Profile persist(Profile profile);
    boolean delete(long profileId);
    Profile update(long profileId, Profile profile) throws Exception;
}
