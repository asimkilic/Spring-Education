package com.asimkilic.rc.api;

import com.asimkilic.rc.model.KisiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {
    private final static String webUrl="http://localhost:8080/api/kisiler";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<KisiDto>> getKisiList(){
        Object result = restTemplate.getForEntity(webUrl,ResponseEntity.class);
        System.out.println(result);
        return null;
    }


}
