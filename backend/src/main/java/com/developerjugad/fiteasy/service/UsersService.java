package com.developerjugad.fiteasy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developerjugad.fiteasy.db.entity.Users;
import com.developerjugad.fiteasy.db.repository.UsersRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersService {
    @Autowired
    private UsersRepo userRepo;

    public Users createUser(Users user) {
        return userRepo.save(user);
    }

    public Users getUser(int id) {
        return userRepo.findById(id).get();
    }

    public List<Users> getAllUsers(String gender) {
        List<Users> listOfUsers = userRepo.findAll();
        List<Users> listOfMaleUsers = new ArrayList<>();
        List<Users> listOfFemaleUsers = new ArrayList<>();
        log.info("Gender {}", gender);
        if (gender != null) {
            boolean isMale = gender.equalsIgnoreCase("male") ? true : false;
            log.info("isMale {}", isMale);
            for (Users user : listOfUsers) {
                if (user.getIsMale()) {
                    log.info("in if");
                    listOfMaleUsers.add(user);
                } else {
                    log.info("in else");
                    listOfFemaleUsers.add(user);
                }
                log.info("in for");
            }
            return isMale ? listOfMaleUsers : listOfFemaleUsers;
        }
        return listOfUsers;
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
