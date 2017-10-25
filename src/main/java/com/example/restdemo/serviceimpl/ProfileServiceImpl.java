package com.example.restdemo.serviceimpl;

import com.example.restdemo.dao.ProfileDao;
import com.example.restdemo.exception.ProfileException;
import com.example.restdemo.model.Profile;
import com.example.restdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDao profileDao;

    @Override
    public List<Profile> getAllProfiles() {
        return profileDao.getAll();
    }

    @Override
    public Profile getProfile(long profileId) throws ProfileException {
        return profileDao.get(profileId);
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileDao.persist(profile);
    }

    @Override
    public Profile updateProfile(long profileId, Profile profile) {
        return profileDao.update(profileId,profile);
    }

    @Override
    public boolean deleteProfile(long profileId) {
        return profileDao.delete(profileId);
    }


}
