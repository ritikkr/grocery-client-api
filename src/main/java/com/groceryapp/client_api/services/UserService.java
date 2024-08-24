package com.groceryapp.client_api.services;

import com.groceryapp.client_api.dto.AccountUpdateRequest;
import com.groceryapp.client_api.exception.UserNotFoundException;
import com.groceryapp.client_api.model.User;


public interface UserService {

    public User createUser(User user);
    public User getUserById(Long id) throws UserNotFoundException;
    public User deleteUserById(Long id) throws UserNotFoundException;

    User updateAccout(AccountUpdateRequest accountUpdateRequest) throws UserNotFoundException;
}
