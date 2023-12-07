package com.palladium.palladiumtestapp;

import lombok.Getter;

@Getter
public enum GeneralResponseEnum {

    SUCCESS("000", "SUCCESS", "Completed Successfully"),
    FAILED("000", "FAILED", "ERROR OCCURED");


    private final String responseCode;
    private final String status;
    private final String message;

    GeneralResponseEnum(String responseCode, String status, String message) {
        this.responseCode = responseCode;
        this.status = status;
        this.message = message;
    }
}
