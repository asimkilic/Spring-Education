package com.asimkilic.aop.api;

import com.asimkilic.aop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageApi {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> testMethod(@RequestBody String message) {
        return ResponseEntity.ok(messageService.giveMessage(message));
    }
}
