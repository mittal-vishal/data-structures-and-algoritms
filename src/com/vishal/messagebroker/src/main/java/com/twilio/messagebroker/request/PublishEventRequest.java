package com.twilio.messagebroker.request;

import com.twilio.messagebroker.model.EventData;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublishEventRequest {

    private String topicId;
    private EventData eventData;

}
