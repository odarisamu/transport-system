package com.projects.application;
import java.util.Scanner;

import com.projects.dao.DaoFactory;
import com.projects.dao.DriverDAO;
import com.projects.dao.FreightDAO;
import com.projects.dao.VehicleDAO;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Olá seja bem-vindo(a) ao sistema de fretes!");
        int number = 0;
        do { 
            System.out.println("\n##### Sistema de Fretes #####");
            System.out.println("1. Fretes\n2. Veículos\n3. Motoristas\n4. Desligar");
            System.out.print("Qual opçao deseja? ");
            try{
                number = Integer.parseInt(input.nextLine( ));
            } catch(NumberFormatException e){
                System.out.println("O valor deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }
            switch(number){
                case 1:
                    auxiliarFreight( );
                    break;
                case 2:
                    auxiliarVehicle();
                    break;
                case 3:
                    auxiliarDriver();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Entrada inválida! Tente novamente...");
                }
        } while (number != 4);
        System.out.println("Encerrando o sistema...");
    }

    public static void auxiliarFreight( ){ 
        int option = 0;
        FreightDAO freightDAO = DaoFactory.createFreightDao();
        do{
            System.out.println("\n##### Fretes #####");
            System.out.println("1. Mudar o status de pagamento de um frete;\n" +
                "2. Listar os fretes pendentes; \n" +
                "3. Listar os fretes pagos; \n" +
                "4. Listar todos os fretes; \n" +
                "5. Adicionar novo frete; \n" +
                "6. Atualizar frete; \n" +
                "7. Apagar frete; \n" +
                "8. Pesquisar frete. \n" +
                "9. Retornar.");
            System.out.println("Qual opçao deseja? ");
            try{
                option = Integer.parseInt(input.nextLine( ));
            }   catch(NumberFormatException e){
                System.out.println("O valor deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }

            switch(option){
                case 1:
                    AuxiliarFreight.changePayment(freightDAO);
                    break;
                case 2:
                    AuxiliarFreight.findNotPaid(freightDAO);
                    break;
                case 3:
                    AuxiliarFreight.findPaid(freightDAO);
                    break;
                case 4:
                    AuxiliarFreight.listAll(freightDAO);
                    break;
                case 5:
                    AuxiliarFreight.insert(freightDAO);
                    break;
                case 6:
                    AuxiliarFreight.update(freightDAO);
                    break;
                case 7:
                    AuxiliarFreight.deleteById(freightDAO);
                    break;
                case 8:
                    AuxiliarFreight.findById(freightDAO);
                case 9:
                    break;
                default:
                    System.out.println("Valor inválido. Tente novamente!");
            }
        } while(option != 9);
        System.out.println("Retornando ao menu...\n");
    }

    public static void auxiliarVehicle( ){
        int option = 0;
        VehicleDAO vehicleDAO = DaoFactory.createVehicleDao();
        do{
            System.out.println("\n##### Veículos #####");
            System.out.println("1. Inserir novo veículo;\n" +
                "2. Encontrar um veículo;\n" +
                "3. Atualizar veículo; \n" +
                "4. Apagar veículo; \n" +
                "5. Listar todos os veículos; \n" +
                "6. Retornar.");
            System.out.println("Qual opçao deseja? ");
            try{
                option = Integer.parseInt(input.nextLine( ));
            } catch(NumberFormatException e){
                System.out.println("O valor deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }
            switch(option){
                case 1:
                    AuxiliarVehicle.insert(vehicleDAO);
                    break;
                case 2:
                    AuxiliarVehicle.findById(vehicleDAO);
                    break;
                case 3:
                    AuxiliarVehicle.update(vehicleDAO);
                    break;
                case 4:
                    AuxiliarVehicle.deleteById(vehicleDAO);
                    break;
                case 5:
                    AuxiliarVehicle.listAll(vehicleDAO);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Valor inválido. Tente novamente!");
            }
        } while(option != 6);
        System.out.println("Retornando ao menu...\n");
    }

     public static void auxiliarDriver( ){
        int option = 0;
        DriverDAO driverDAO = DaoFactory.createDriverDao();
        do{
            System.out.println("\n##### Motoristas #####");
            System.out.println("1. Listar todos os motoristas; \n" +
                "2. Encontrar motorista; \n" +
                "3. Atualizar motorista;\n" +
                "4. Adicionar novo motorista;\n" + 
                "5. Apagar motorista; \n" +
                "6. Retornar.");
            System.out.println("Qual opçao deseja? ");
            try{
                option = Integer.parseInt(input.nextLine( ));
            } catch(NumberFormatException e){
                System.out.println("O valor deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }
            switch(option){
                case 1:
                    AuxiliarDriver.listAll(driverDAO);
                    break;
                case 2:
                    AuxiliarDriver.findById(driverDAO);
                    break;
                case 3:
                    AuxiliarDriver.update(driverDAO);
                    break;
                case 4:
                    AuxiliarDriver.insert(driverDAO);                   
                    break;
                case 5:
                    AuxiliarDriver.deleteById(driverDAO);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Valor inválido. Tente novamente!");
            }
        } while(option != 6);
        System.out.println("Retornando ao menu...\n");
    }
}
