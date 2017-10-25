package com.example.restdemo.daoimpl;

import com.example.restdemo.dao.MessageDao;
import com.example.restdemo.dao.ProfileDao;
import com.example.restdemo.exception.InvalidProfileIdException;
import com.example.restdemo.exception.ProfileException;
import com.example.restdemo.exception.ProfileNotFoundException;
import com.example.restdemo.model.Message;
import com.example.restdemo.model.Profile;
import com.example.restdemo.util.DbStoreStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProfileDaoJdbc implements ProfileDao {

    @Autowired
    DbStoreStub dbStoreStub;

    @Autowired
    MessageDao messageDao;

    @Override
    public List<Profile> getAll() {
        return (List<Profile>) dbStoreStub.profileMap.values();
    }

    @Override
    public Profile get(long profileId) throws ProfileException {

        if(profileId == 0 || profileId < 0 || profileId > DbStoreStub.nextProfileId) {
            throw new InvalidProfileIdException ("Invalid Profile ID: "+profileId);
        }

        return dbStoreStub.profileMap.get(profileId);
    }

    @Override
    public Profile persist(Profile profile) {
        profile.setId(DbStoreStub.getProfileId());
        dbStoreStub.profileMap.put(profile.getId(),profile);
        return profile;
    }

    @Override
    @Transactional
    public boolean delete(long profileId) {
        List<Message> messagesToBeRemoved = messageDao.getMessageSentByProfileId(profileId);
        for(Message message: messagesToBeRemoved) {
            dbStoreStub.messageMap.remove(message.getId());
        }
        Profile profile = dbStoreStub.profileMap.remove(profileId);
        return profile != null ? true : false;
    }

    @Override
    public Profile update(long profileId, Profile profile) throws ProfileNotFoundException{
        Profile profileFromSource =  dbStoreStub.profileMap.get(profileId);
        if(profileFromSource!=null) {
            profile.setId(profileId);
            return profile;
        }
        throw new ProfileNotFoundException("No profile found!");
    }
}

