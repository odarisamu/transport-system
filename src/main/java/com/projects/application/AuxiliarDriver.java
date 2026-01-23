package com.projects.application;
import java.util.List;
import java.util.Scanner;

import com.projects.dao.DriverDAO;
import com.projects.entities.Driver;

public class AuxiliarDriver {
    public static Scanner input = new Scanner(System.in);

    public static void listAll(DriverDAO driverDAO){
        List<Driver> drivers = driverDAO.listAll();
        if(drivers.isEmpty()){
            System.out.println("Nao há motoristas no banco de dados!");
        } else{
            for(Driver driver : drivers){
                System.out.println(driver);
            }
        }
    }
    public static void findById(DriverDAO driverDAO){
        System.out.println("Insira o ID do motorista procurado: ");
        Integer id = Integer.parseInt(input.next( ));
        
    }
    public static void update(DriverDAO driverDAO){
        
    }
    public static void insert(DriverDAO driverDAO){
        
    }
    public static void deleteById(DriverDAO driverDAO){
        
    }
}
