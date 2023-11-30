package com.twilio.messagebroker.validation;

import com.twilio.messagebroker.dto.ErrorResponse;
import com.twilio.messagebroker.model.Topic;
import com.twilio.messagebroker.service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicValidator {

    public TopicValidator(){

    }

    @Autowired
    private EventDataService eventDataService;

    public Optional<ErrorResponse> validate(Topic topic){
        //Validate topic id
        if(topic.getId() == null || topic.getId().length() < 3){
            return Optional.of(ErrorResponse.builder()
                    .errorCode(400)
                    .errorDesc("Topic ID should contain at least 3 characters")
                    .build());
        }
        //Validate if already exists
        if(this.eventDataService.getTopicEventData().containsKey(topic.getId())){
            return Optional.of(ErrorResponse.builder()
                    .errorCode(400)
                    .errorDesc("Topic ID already exists")
                    .build());
        }
        return Optional.ofNullable(null);
    }

}
