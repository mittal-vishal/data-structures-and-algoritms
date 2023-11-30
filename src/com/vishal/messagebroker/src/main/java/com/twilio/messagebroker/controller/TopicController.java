package com.twilio.messagebroker.controller;

import com.twilio.messagebroker.dto.ErrorResponse;
import com.twilio.messagebroker.model.Topic;
import com.twilio.messagebroker.service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.messagebroker.validation.TopicValidator;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private EventDataService eventDataService;

    @Autowired
    private TopicValidator topicValidator;

    @PostMapping("/v1/topic")
    public ResponseEntity<Object> createTopic(@RequestBody Topic topic){
        Optional<ErrorResponse> validateResponse = topicValidator.validate(topic);
        if(validateResponse.isPresent()){
            return new ResponseEntity(validateResponse.get(), HttpStatus.BAD_REQUEST);
        }
        eventDataService.getTopicEventData().putIfAbsent(topic.getId(), new ArrayList<>());
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

}
