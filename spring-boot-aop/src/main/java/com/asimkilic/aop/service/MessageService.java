package com.asimkilic.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String giveMessage(String param) {
        System.out.println("Method mesaj verdi param: " + param);
        return param;
    }
}
