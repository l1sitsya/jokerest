	package com.example.demo.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserRepository;
import com.example.demo.model.comment;
import com.example.demo.model.user;

@Service
public class UserServiceimpl {
    final UserRepository userRepository;;
    public UserServiceimpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
        } 
    
    public user findById(long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
    public user edit(long id, user newUser) {
    	user oldUser = userRepository.getOne(id);
    	if (newUser.getUsername() != null) oldUser.setUsername(newUser.getUsername());
    	if (newUser.getLogin() != null) oldUser.setLogin(newUser.getLogin());
    	if (newUser.getPassword() != null) oldUser.setPassword(newUser.getPassword());
    	return userRepository.save(oldUser);
    }
    
    public void delete(long id) {
    	user user = userRepository.getOne(id);
    	List<comment> usercomments = user.getComments();
    }
}

