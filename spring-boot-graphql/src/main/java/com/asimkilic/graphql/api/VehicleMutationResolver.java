package com.asimkilic.graphql.api;

import com.asimkilic.graphql.dto.VehicleDto;
import com.asimkilic.graphql.entity.Vehicle;
import com.asimkilic.graphql.repo.VehicleRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto) {
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());
        vehicle.setType(vehicleDto.getType());
        vehicle.setModelCode(vehicleDto.getModelCode());
        return vehicle;
    }
}
