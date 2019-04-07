package com.kelompok5.golelang.service;

import com.kelompok5.golelang.entity.User;
import com.kelompok5.golelang.exception.UserNameException;
import com.kelompok5.golelang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        try{
            return userRepository.save(user);
        } catch (Exception e){
            throw new UserNameException("userName '"+user.getUserName()+"' already exist");
        }
    }

    public User findUserByUsername(String username){
        User user = userRepository.findByUserName(username);

        return user;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}
