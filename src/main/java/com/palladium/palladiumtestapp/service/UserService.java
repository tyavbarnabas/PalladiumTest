package com.palladium.palladiumtestapp.service;

import com.palladium.palladiumtestapp.dto.UserRequest;
import com.palladium.palladiumtestapp.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
    UserResponse getAllUser();
}
