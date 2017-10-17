package com.example.restdemo.daoimpl;

import com.example.restdemo.dao.ProfileDao;
import com.example.restdemo.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDaoJdbc implements ProfileDao {
    @Override
    public List<Profile> getAll() {
        return null;
    }
}
