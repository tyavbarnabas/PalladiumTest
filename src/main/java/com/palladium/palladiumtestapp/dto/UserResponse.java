package com.palladium.palladiumtestapp.dto;



import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String ResponseCode;
    private String message;
    private Object details;



}
