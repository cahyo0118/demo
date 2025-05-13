package com.example.snap.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCodeEnum {
    SUCCESS_73("2007300", "Successful"),
    UNAUTHORIZED_73("4017300", "Unauthorized. [reason]"),
    PARTNER_NOT_FOUND_73("4047316", "Partner Not Found"),

    PARTNER_NOT_FOUND_07("4040716", "Partner Not Found");

    private final String code;
    private final String message;
}
