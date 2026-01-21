package com.projects.dao;
import java.util.List;

import com.projects.entities.Vehicle;

public interface VehicleDAO{
    void insert(Vehicle vehicle);
    Vehicle findById(Integer id);
    void update(Vehicle vehicle);
    void deleteById(Integer id);
    List<Vehicle> listAll( );
}
