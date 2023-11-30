package com.twilio.messagebroker.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventData {
    private String id;
    private Object data;
}
