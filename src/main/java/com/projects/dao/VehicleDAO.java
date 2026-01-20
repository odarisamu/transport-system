package com.projects.dao;
import java.util.List;

import com.projects.entities.Vehicle;

public interface VehicleDAO{
    void insert(Vehicle vehicle);
    Vehicle findById(Vehicle vehicle);
    void update(Vehicle vehicle);
    void deleteById(Integer id);
    List<Vehicle> listAll( );
}
