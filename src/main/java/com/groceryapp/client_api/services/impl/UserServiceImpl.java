package com.groceryapp.client_api.services.impl;

import com.groceryapp.client_api.dto.AccountUpdateRequest;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.User;
import com.groceryapp.client_api.repository.UserRepository;
import com.groceryapp.client_api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No User found with id:"+id));
    }

    @Override
    public User deleteUserById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No User found with id:"+id));
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User updateAccout(AccountUpdateRequest accountUpdateRequest) throws UserNotFoundException {
        User user = userRepository.findById(accountUpdateRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("No User found with id: "+accountUpdateRequest.getUserId()));

        user.setAddress(accountUpdateRequest.getAddress());
        user.setFirstName(accountUpdateRequest.getFirstName());
        user.setLastName(accountUpdateRequest.getLastName());
        user.setPhoneNumber(accountUpdateRequest.getPhoneNumber());
        user.setPassword(accountUpdateRequest.getPassword());

        return user;
    }
}
