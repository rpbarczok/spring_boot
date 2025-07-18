package com.example.demo.model;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageRepo {

    static List<Message> messages = new ArrayList<Message>();

    public List<Message> getAllMessages(){
        return messages;
    }

    public Message addMessage(UUID id, String name, String message) {
        Message newMessage = new Message(id, name, message);
        messages.add(newMessage);
        return newMessage;
    }

}
