package com.projects.application;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.projects.dao.VehicleDAO;
import com.projects.entities.Vehicle;

public class AuxiliarVehicle {
    public static Scanner input = new Scanner(System.in);

    public static void insert(VehicleDAO vehicleDAO){
        try{
            System.out.print("Digite as informacoes do novo veículo \n");
            System.out.println("Placa (AAA1234): ");
            String truckSign = input.nextLine( );
            System.out.println("Peso máximo: ");
            Double maxWeight = input.nextDouble( );
            System.out.println("Número de eixos: ");
            Integer numberAxles = input.nextInt( );
            
            Vehicle vehicle = new Vehicle(truckSign, maxWeight, numberAxles);
            vehicleDAO.insert(vehicle);
        } catch(InputMismatchException e){
            System.out.println("O valor digitado nao corresponde ao requerido!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }
    
    public static void findById(VehicleDAO vehicleDAO){
        System.out.println("Insira o ID do veículo procurado: ");
        try{
            Integer id = input.nextInt( );
            Vehicle vehicle = vehicleDAO.findById(id);
            if(vehicle != null){
                System.out.println(vehicle);
            } else{
                System.out.println("Nao há veículos com o ID informado.");
            }
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }

    public static Vehicle findByIdAux(VehicleDAO vehicleDAO){
        try{
            System.out.println("Insira o ID do veículo: ");
            Integer id = input.nextInt( );
            Vehicle vehicle = vehicleDAO.findById(id);
            if(vehicle != null){
                return vehicle;
            } else{
                System.out.println("Nao há veículos com o ID informado.");
                return null;
            }
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
            return null;
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
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
            try{
                Integer option = input.nextInt( );
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
            } catch(InputMismatchException e){
                System.out.println("O valor digitado deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }
    }

    public static void deleteById(VehicleDAO vehicleDAO){
        System.out.println("Digite o ID do veículo a excluir: ");
        try{
            Integer id = Integer.parseInt(input.next( ));
            vehicleDAO.deleteById(id);
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
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
