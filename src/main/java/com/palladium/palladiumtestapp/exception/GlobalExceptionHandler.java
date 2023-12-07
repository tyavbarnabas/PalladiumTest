package com.palladium.palladiumtestapp.exception;

import com.palladium.palladiumtestapp.GeneralResponseEnum;
import com.palladium.palladiumtestapp.dto.UserResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<UserResponse> handlePayloadException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new UserResponse(GeneralResponseEnum.FAILED.getResponseCode(),
                ex.getAllErrors().get(0).getDefaultMessage(),
                GeneralResponseEnum.FAILED.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserResponse> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(new UserResponse(GeneralResponseEnum.FAILED.getResponseCode(),
                ex.getMessage(),
                GeneralResponseEnum.FAILED.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<UserResponse> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return new ResponseEntity<>(new UserResponse(GeneralResponseEnum.FAILED.getResponseCode(),
                ex.getMessage(),
                GeneralResponseEnum.FAILED.getMessage()), HttpStatus.NOT_FOUND);
    }

}
