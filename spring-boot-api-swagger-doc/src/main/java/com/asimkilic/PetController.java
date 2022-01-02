package com.asimkilic;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
@Api(value = "Pet API dökümantasyonu")
public class PetController {
    private List<Pet> petList = new ArrayList<>();
    @PostConstruct
    public void init() {

        petList.add(new Pet(1, "Test Pet", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni Pet ekleme metodu", notes = "Metodu dikkatli kullanın.")
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "eklenecekPet") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Pet listesi metodu", notes = "Bütün petleri listeler")
    public ResponseEntity<List<Pet>> tumunuListele() {
        return ResponseEntity.ok(petList);
    }
}
/*
 *  API DOCUMENTATION
 * @API -> marks a class as a Swagger resource.
 * @ApiModel -> Provides additional information about Swagger models.
 * @ApiModelProperty -> Adds and manipulates data of a model property.
 * @ApiOperation -> Describes an operation of typically an HTTP method against a specific path.
 * @ApiParam -> Adds additional meta data for operation parameters.
 * @ApiResponse -> Describes a possible response of an operation.
 * @ApiResponses -> A wrapper to allow a list of multiple ApiResponse objects.
 */