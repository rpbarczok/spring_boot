package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class Message {
    UUID id;
    String message;
    String name;

}
