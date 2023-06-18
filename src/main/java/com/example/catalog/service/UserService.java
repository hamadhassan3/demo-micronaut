package com.example.catalog.service;

import com.example.catalog.model.User;
import com.example.catalog.model.dto.request.UserRequest;
import com.example.catalog.model.dto.response.UserResponse;
import com.example.catalog.repository.UserRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long countUsers(){
        return userRepository.count();
    }

    public List<UserResponse> readAllUsers(){
        return userRepository.find();
    }

    public UserResponse readUser(Long id){

        Optional<UserResponse> optionalUserResponse = userRepository.find(id);

        if(optionalUserResponse.isEmpty()){
            throw new NoSuchElementException("A User with this id does not exist!");
        }

        return optionalUserResponse.get();
    }

    public UserResponse readUserByUsername(String username){

        Optional<UserResponse> optionalUserResponse = userRepository.findByUsername(username);

        if(optionalUserResponse.isEmpty()){
            throw new NoSuchElementException("A User with this username does not exist!");
        }

        return optionalUserResponse.get();
    }

    @Transactional
    public UserResponse createUser(UserRequest userRequest){

        User user = new User();
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        user.setRoles(userRequest.roles());
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
            user.setRoles(userRequest.roles());
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
