package com.example.restdemo.serviceimpl;

import com.example.restdemo.dao.ProfileDao;
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
}
