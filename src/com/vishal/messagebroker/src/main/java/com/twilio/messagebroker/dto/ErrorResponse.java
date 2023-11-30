package com.twilio.messagebroker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private int errorCode;
    private String errorDesc;

}
