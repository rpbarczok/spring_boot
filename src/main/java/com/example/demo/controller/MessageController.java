package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.model.MessageRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    MessageRepo messageRepo = new MessageRepo();
    @GetMapping
    public List<Message> getAllMessages(){
        return messageRepo.getAllMessages();
    }

    @PostMapping
    public Message addMessage(@RequestBody String name, String message){
        UUID id = UUID.randomUUID();
        return messageRepo.addMessage(id, name, message);
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable UUID id){
        List<Message> messages = messageRepo.getAllMessages();
        for (Message m : messages){
            if (m.getId().equals(id)){
                return m;
            }
        }
        UUID idError = UUID.randomUUID();
        return new Message(idError, "404: Message not found", "Error");

    }

    @DeleteMapping("/{id}")
    public Message deleteMessage(@PathVariable UUID id){
        List<Message> messages = messageRepo.getAllMessages();
        for (Message m : messages){
            if (m.getId().equals(id)){
                messages.remove(m);
                Message success = new Message(UUID.randomUUID(), "Message deleted successfully", "Success");
                return success;
           }
        }
        Message failure = new Message(id, "404: Message not found", "Error");
        return failure;

    }
}
