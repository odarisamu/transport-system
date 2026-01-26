package com.projects.application;

import java.util.List;
import java.util.Scanner;

import com.projects.dao.VehicleDAO;
import com.projects.entities.Vehicle;

public class AuxiliarVehicle {
    public static Scanner input = new Scanner(System.in);

    public static void insert(VehicleDAO vehicleDAO){
        System.out.print("Digite as informacoes do novo veículo \n");
        System.out.println("Placa: ");
        String truckSign = input.nextLine( );
        System.out.println("Peso máximo: ");
        Double maxWeight = input.nextDouble( );
        System.out.println("Número de eixos: ");
        Integer numberAxles = input.nextInt( );
        
        Vehicle vehicle = new Vehicle(truckSign, maxWeight, numberAxles);
        vehicleDAO.insert(vehicle);
    }
    
    public static void findById(VehicleDAO vehicleDAO){
        System.out.println("Insira o ID do veículo procurado: ");
        Integer id = Integer.parseInt(input.next( ));
        Vehicle vehicle = vehicleDAO.findById(id);
        if(vehicle != null){
            System.out.println(vehicle);
        } else{
            System.out.println("Nao há veículos com o ID informado.");
        }
    }

    public static Vehicle findByIdAux(VehicleDAO vehicleDAO){
        System.out.println("Insira o ID do veículo: ");
        Integer id = Integer.parseInt(input.next( ));
        Vehicle vehicle = vehicleDAO.findById(id);
        if(vehicle != null){
            return vehicle;
        } else{
            System.out.println("Nao há veículos com o ID informado.");
            return null;
        }
    }

    public static void update(VehicleDAO vehicleDAO){
        Vehicle vehicle = findByIdAux(vehicleDAO);
        if(vehicle != null){
            System.out.println("Selecione uma das opcoes para atualizar: \n" + 
            "1. Placa do Veículo \n" +
            "2. Peso máximo \n" + 
            "3. Número de eixos \n");
        }
            Integer option = Integer.parseInt(input.next( ));
            switch(option){
                case 1:
                    System.out.println("Digite a Placa do Veículo: ");
                    String truckSign = input.nextLine( );
                    vehicle.setTruckSign(truckSign);
                    vehicleDAO.update(vehicle);
                    break;
                case 2:
                    System.out.println("Digite o Peso máximo: ");
                    Double maxWeight = input.nextDouble( );
                    vehicle.setMaxWeight(maxWeight);
                    vehicleDAO.update(vehicle);
                    break;
                case 3:
                    System.out.println("Digite o número de eixos: ");
                    Integer numberAxles = input.nextInt();
                    vehicle.setNumberAxles(numberAxles);
                    vehicleDAO.update(vehicle);
                    break;
                default:
                    System.out.println("Opcao invalida, retornando...");
            }
    }

    public static void deleteById(VehicleDAO vehicleDAO){
        System.out.println("Digite o ID do veículo a excluir: ");
        Integer id = Integer.parseInt(input.next( ));
        vehicleDAO.deleteById(id);
    }


    public static void listAll(VehicleDAO vehicleDAO){
        List<Vehicle> vehicles = vehicleDAO.listAll();
        if(vehicles.isEmpty()){
            System.out.println("Nao há veículos no banco de dados!");
        } else{
            for(Vehicle vehicle : vehicles){
                System.out.println(vehicle);
            }
        }
    }
}
