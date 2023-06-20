package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.JasonKafkaProducer;
import net.javaguides.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);

    private final JasonKafkaProducer jasonKafkaProducer;

    public JsonMessageController(JasonKafkaProducer jasonKafkaProducer) {
        this.jasonKafkaProducer = jasonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        this.jasonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic.");
    }

}
