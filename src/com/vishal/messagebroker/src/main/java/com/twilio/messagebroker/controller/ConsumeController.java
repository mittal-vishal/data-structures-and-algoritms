package com.twilio.messagebroker.controller;

import com.twilio.messagebroker.model.EventData;
import com.twilio.messagebroker.model.Topic;
import com.twilio.messagebroker.service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ConsumeController {

    @Autowired
    private EventDataService eventDataService;

    @PostMapping("/v1/consume/topics/{topic_id}")
    public ResponseEntity<List<EventData>> createTopic(@PathVariable("topic_id") String topicId){
        //Get all the event from the topic, and return
        List<EventData> events = eventDataService.getTopicEventData().get(topicId);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}
