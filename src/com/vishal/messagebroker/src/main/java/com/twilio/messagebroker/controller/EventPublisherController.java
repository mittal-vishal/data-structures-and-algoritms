package com.twilio.messagebroker.controller;

import com.twilio.messagebroker.model.EventData;
import com.twilio.messagebroker.model.Topic;
import com.twilio.messagebroker.request.PublishEventRequest;
import com.twilio.messagebroker.service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventPublisherController {

    @Autowired
    private EventDataService eventDataService;

    @PostMapping("/v1/event")
    public ResponseEntity<Void> publishEvent(@RequestBody PublishEventRequest publishEventRequest){
        //Get topic from HashMap, and add in that topic
        String topicId = publishEventRequest.getTopicId();
        if(eventDataService.getTopicEventData().containsKey(topicId)){
            eventDataService.getTopicEventData().get(topicId).add(publishEventRequest.getEventData());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
