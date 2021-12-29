package com.asimkilic.controller;

import com.asimkilic.entity.Person;
import com.asimkilic.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private  PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setId("P0001");
        person.setName("Asım");
        person.setLastName("Kılıç");
        person.setAddress("Test-address");
        person.setBirthDate(Calendar.getInstance().getTime());
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> personList = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(personList);

    }
}
