package com.palladium.palladiumtestapp.serviceImpl;

import com.palladium.palladiumtestapp.GeneralResponseEnum;
import com.palladium.palladiumtestapp.dto.UserRequest;
import com.palladium.palladiumtestapp.dto.UserResponse;
import com.palladium.palladiumtestapp.exception.UserAlreadyExistException;
import com.palladium.palladiumtestapp.exception.UserNotFoundException;
import com.palladium.palladiumtestapp.model.User;
import com.palladium.palladiumtestapp.repository.UserRepository;
import com.palladium.palladiumtestapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest userRequest) {

        Optional<User> user = userRepository.findByEmail( userRequest.getEmail());
        log.info("user gotten: {}", user);
        if (user.isPresent()){
            throw new UserAlreadyExistException(" user already exist");
        }

        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPhoneNumber(userRequest.getPhoneNumber());
        newUser.setCreateAt(LocalDateTime.now());
        newUser.setStatus(true);


        User saveUser = userRepository.save(newUser);
        log.info("User saved to the database ....{}", saveUser);

        return UserResponse.builder()
                .ResponseCode(GeneralResponseEnum.SUCCESS.getResponseCode())
                .message(GeneralResponseEnum.SUCCESS.getMessage())
                .details(newUser)
                .build();

    }

    @Override
    public UserResponse getAllUser() {
        List<User> users = userRepository.findAll();
        log.info("user: {}", users);


        if( users.isEmpty()){
            throw  new UserNotFoundException("user not found");
        }

        return UserResponse.builder()
                .ResponseCode(GeneralResponseEnum.SUCCESS.getResponseCode())
                .message(GeneralResponseEnum.SUCCESS.getMessage())
                .details(users)
                .build();
    }
}
