package com.twilio.messagebroker.service;

import com.twilio.messagebroker.model.EventData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EventDataService {
    private HashMap<String, List<EventData>> topicEventData;

    public EventDataService(){
        this.topicEventData = new HashMap<>();
    }

    public HashMap<String, List<EventData>> getTopicEventData() {
        return topicEventData;
    }

    public void setTopicEventData(HashMap<String, List<EventData>> topicEventData) {
        this.topicEventData = topicEventData;
    }
}
