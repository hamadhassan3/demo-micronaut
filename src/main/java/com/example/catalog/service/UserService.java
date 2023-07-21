package com.example.catalog.service;

import com.example.catalog.model.User;
import com.example.catalog.model.dto.request.UserRequest;
import com.example.catalog.model.dto.response.UserResponse;
import com.example.catalog.repository.UserRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public long countUsers(){
        return userRepository.count();
    }

    public List<UserResponse> readAllUsers(){
        return userRepository.find().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    public UserResponse readUser(Long id){

        Optional<User> optionalUserResponse = userRepository.find(id);

        if(optionalUserResponse.isEmpty()){
            throw new NoSuchElementException("A User with this id does not exist!");
        }

        return new UserResponse(optionalUserResponse.get());
    }

    public User readUserByUsername(String username){

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isEmpty()){
            throw new NoSuchElementException("A User with this username does not exist!");
        }

        return optionalUser.get();
    }

    @Transactional
    public UserResponse createUser(UserRequest userRequest){

        Optional<User> optionalUser = userRepository.findByUsername(userRequest.username());
        if(optionalUser.isPresent()){
            throw new NoSuchElementException("A User with this id already exists!");
        }

        User user = new User();
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());

        user.setRole(roleService.getRoleById(userRequest.role()));

        userRepository.save(user);

        return new UserResponse(user);
    }

    @Transactional
    public UserResponse updateUser(Long id, UserRequest userRequest){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new NoSuchElementException("A User with this id does not exist!");
        }
        else {
            User user = optionalUser.get();
            user.setUsername(userRequest.username());
            user.setPassword(userRequest.password());
            user.setRole(roleService.getRoleById(userRequest.role()));
            return new UserResponse(user);
        }
    }

    @Transactional
    public String deleteUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new NoSuchElementException("A User with this id does not exist!");
        }
        else {
            userRepository.delete(optionalUser.get());
            return "success";
        }
    }
}
