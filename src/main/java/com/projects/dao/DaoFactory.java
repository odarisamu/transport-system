package com.projects.dao;
import com.projects.impl.DriverDaoJDBC;
import com.projects.impl.FreightDaoJDBC;
import com.projects.impl.VehicleDaoJDBC;

public class DaoFactory {
    public static DriverDaoJDBC createDriverDao( ){
        return new DriverDaoJDBC( );
    }
    public static FreightDaoJDBC createFreightDao( ){
        return new FreightDaoJDBC();
    }
    public static VehicleDaoJDBC createVehicleDao( ){
        return new VehicleDaoJDBC( );
    }
}
