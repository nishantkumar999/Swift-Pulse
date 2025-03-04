package com.accioshoppingbackend.Shopping_Backend.service;

import com.accioshoppingbackend.Shopping_Backend.exception.WrongCredentialsException;
import com.accioshoppingbackend.Shopping_Backend.model.ApplicationUser;
import com.accioshoppingbackend.Shopping_Backend.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonUserService {

    @Autowired //jpa will create object
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    UserUtil userUtil;

    public void createUser(ApplicationUser user){
        applicationUserRepository.save(user);
    }

    //it will call repository layer to fetch record from user table
    public boolean authenticateUser(String email, String password){
        ApplicationUser user = userUtil.checkEmailExists(email);

        if(user == null){
            //"User entered wrong %s email" if user with that email dosen't exist.
            throw new WrongCredentialsException(String.format("User entered wrong email %s", email));
        }

        String actualPassword = user.getPassword();
        if(actualPassword.equals(password)){
            return true;
        }
        else{
            throw new WrongCredentialsException(String.format("Wrong password entered %s", password));
        }
    }

}
