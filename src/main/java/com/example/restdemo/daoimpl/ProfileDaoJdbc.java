package com.example.restdemo.daoimpl;

import com.example.restdemo.dao.ProfileDao;
import com.example.restdemo.model.Profile;
import com.example.restdemo.util.DbStoreStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDaoJdbc implements ProfileDao {

    @Autowired
    DbStoreStub dbStoreStub;

    @Override
    public List<Profile> getAll() {
        return (List<Profile>) dbStoreStub.profileMap.values();
    }

    @Override
    public Profile get(long profileId) {
        return dbStoreStub.profileMap.get(profileId);
    }

    @Override
    public Profile persist(Profile profile) {
        profile.setId(DbStoreStub.getProfileId());
        dbStoreStub.profileMap.put(profile.getId(),profile);
        return profile;
    }

    @Override
    public boolean delete(long profileId) {
        Profile profile = dbStoreStub.profileMap.remove(profileId);
        return profile != null ? true : false;
    }

    @Override
    public Profile update(long profileId, Profile profile) throws RuntimeException{
        Profile profileFromSource =  dbStoreStub.profileMap.get(profileId);
        if(profileFromSource!=null) {
            profile.setId(profileId);
            return profile;
        }
        throw new RuntimeException("No profile found!");
    }
}

