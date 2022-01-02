package com.asimkilic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageApi {

    @GetMapping
    public String getMessage() {
        return "Docker Image içinden Merhaba";
    }
}
