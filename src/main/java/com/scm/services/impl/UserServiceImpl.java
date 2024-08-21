package com.scm.services.impl;

import java.util.*;
import java.util.Optional;

//import org.hibernate.validator.constraints.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositeries.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo UserRepo;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //geneate user id
        String userid = "2";
        user.setUserId(userid);
        return UserRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        
        return UserRepo.findById(id); 

    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = UserRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        //update user2 to user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderId(user.getProviderId());

        //save in DB

        User save = UserRepo.save(user2);

        return Optional.ofNullable(save);


    }

    @Override
    public void deleteUser(String id) {
        User user2 = UserRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        //update user2 to user
         UserRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userid) {
        User user2 = UserRepo.findById(userid).orElse(null);
        return user2 != null ? true : false;
        
    }

    @Override
    public boolean isUserExistByEmail(String email) {
       User user = UserRepo.findByEmail(email);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepo.findAll();
    }

}
