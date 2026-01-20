package com.projects.dao;
import java.util.List;

import com.projects.entities.Driver;

public interface DriverDAO {
    List<Driver> listAll( );
    Driver findById(Integer id);
    void update(Driver driver);
    void insert(Driver driver);
    void deleteById(Integer id);
}
