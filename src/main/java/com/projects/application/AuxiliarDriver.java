package com.projects.application;
import java.sql.Date;
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
        Driver driver = driverDAO.findById(id);
        if(driver != null){
            System.out.println(driver);
        } else{
            System.out.println("Nao há motoristas com o ID informado.");
        }
    }

    public static Driver findByIdAux(DriverDAO driverDAO){
        System.out.println("Insira o ID do motorista: ");
        Integer id = Integer.parseInt(input.next( ));
        Driver driver = driverDAO.findById(id);
        if(driver != null){
            return driver;
        } else{
            System.out.println("Nao há motoristas com o ID informado.");
            return null;
        }
    }

    public static void update(DriverDAO driverDAO){
        Driver driver = findByIdAux(driverDAO);
        if(driver != null){
            System.out.println("Selecione uma das opcoes para atualizar no motorista: \n" + 
            "1. CPF \n" +
            "2. Nome \n" + 
            "3. Data de Nascimento \n" +
            "4. Carteira de Motorista \n" +
            "5. Telefone\n");
            Integer option = Integer.parseInt(input.next( ));
            switch(option){
                case 1:
                    System.out.println("Digite o CPF do motorista: ");
                    String cpf = input.nextLine( );
                    driver.setCpf(cpf);
                    driverDAO.update(driver);
                    break;
                case 2:
                    System.out.println("Digite o Nome do motorista: ");
                    String nome = input.nextLine( );
                    driver.setName(nome);
                    driverDAO.update(driver);
                    break;
                case 3:
                    System.out.println("Dia de nascimento (DD): ");
                    String day = input.next( );
                    System.out.println("Mes de nascimento (MM): ");
                    String month = input.next( );
                    System.out.println("Ano de nascimento(AAAA): ");
                    String year = input.next( );
                    String birth = year + "-" + month + "-" + day;
                    Date birthDate = Date.valueOf(birth);
                    driver.setBirthDate(birthDate); 
                    driverDAO.update(driver);
                    break;
                case 4:
                    System.out.println("Digite a Carteira do Motorista: ");
                    String licenseDriver = input.nextLine( );
                    driver.setLicenseDriver(licenseDriver);
                    driverDAO.update(driver);
                    break;
                case 5:
                    System.out.println("Digite o Telefone do motorista: ");
                    String phone = input.nextLine( );
                    driver.setPhone(phone);
                    driverDAO.update(driver);
                    break;
                default:
                    System.out.println("Opcao inválida, retornando...");
            }
        }
    }
    public static void insert(DriverDAO driverDAO){
        System.out.print("Digite as informacoes do novo motorista: \n");
        System.out.println("CPF: ");
        String cpf = input.nextLine( );
        System.out.println("Nome: ");
        String name = input.nextLine( );
        System.out.println("Dia de nascimento (DD): ");
        String day = input.next( );
        System.out.println("Mes de nascimento (MM): ");
        String month = input.next( );
        System.out.println("Ano de nascimento(AAAA): ");
        String year = input.next( );
        String birth = year + "-" + month + "-" + day;
        Date birthDate = Date.valueOf(birth);
        System.out.println("Carteira de Motorista: ");
        String licenseDriver = input.nextLine( );
        System.out.println("Telefone: ");
        String phone = input.nextLine( );
        
        Driver driver = new Driver(cpf, name, birthDate, licenseDriver, phone);
        driverDAO.insert(driver);
    }

    public static void deleteById(DriverDAO driverDAO){
        System.out.println("Digite o ID do motorista a excluir: ");
        Integer id = Integer.parseInt(input.next( ));
        driverDAO.deleteById(id);
    }
}
