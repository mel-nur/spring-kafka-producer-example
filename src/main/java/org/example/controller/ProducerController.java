package org.example.controller;

import org.example.dto.Product;
import org.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping
    public String healthCheck(@RequestBody String message){
        producerService.send(message);
        return "Message sent to Kafka";
    }

    @PostMapping
    public Product sendProductMessage(@RequestBody Product message){
        producerService.send(message);
        return message;
    }
}
