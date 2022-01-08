package com.asimkilic.graphql.api;

import com.asimkilic.graphql.entity.Vehicle;
import com.asimkilic.graphql.repo.VehicleRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type) {
        List<Vehicle> byTypeLike = vehicleRepository.getByTypeLike(type);
        System.out.println("asd");
        return byTypeLike;
    }

    public Optional<Vehicle> getById(Long id) {
        return vehicleRepository.findById(id);
    }
}
