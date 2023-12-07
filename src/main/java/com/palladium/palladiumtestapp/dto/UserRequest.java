package com.palladium.palladiumtestapp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRequest {
    private String name;
    private String email;
    private String phoneNumber;
}
