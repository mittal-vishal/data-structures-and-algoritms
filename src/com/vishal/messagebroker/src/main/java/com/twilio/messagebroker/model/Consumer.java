package com.twilio.messagebroker.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    private String id;
    private String name;
}
