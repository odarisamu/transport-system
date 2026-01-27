package com.projects.application;
import java.sql.Date;
import java.util.InputMismatchException;
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
        try{
            Integer id = input.nextInt( );
            Driver driver = driverDAO.findById(id);
            if(driver != null){
                System.out.println(driver);
            } else{
                System.out.println("Nao há motoristas com o ID informado.");
            }
            } catch(InputMismatchException e){
                System.out.println("O valor digitado deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }
    }

    public static Driver findByIdAux(DriverDAO driverDAO){
        System.out.println("Insira o ID do motorista: ");
        try{
            Integer id = input.nextInt( );
            Driver driver = driverDAO.findById(id);
            if(driver != null){
                return driver;
            } else{
                System.out.println("Nao há motoristas com o ID informado.");
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

    public static void update(DriverDAO driverDAO){
        Driver driver = findByIdAux(driverDAO);
        if(driver != null){
            System.out.println("Selecione uma das opcoes para atualizar no motorista: \n" + 
            "1. CPF \n" +
            "2. Nome \n" + 
            "3. Data de Nascimento \n" +
            "4. Carteira de Motorista \n" +
            "5. Telefone\n");

            try{
                Integer option = input.nextInt( );
                switch(option){
                    case 1:
                        System.out.println("Digite o CPF do motorista (12345678901): ");
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
                        System.out.println("Digite o Telefone do motorista (DD9NNNNNNNN): ");
                        String phone = input.nextLine( );
                        driver.setPhone(phone);
                        driverDAO.update(driver);
                        break;
                    default:
                        System.out.println("Opcao inválida, retornando...");
                }
            } catch(InputMismatchException e){
                System.out.println("O valor digitado deve ser um inteiro!");
            } catch(Exception e){
                System.out.println("Erro desconhecido!");
            }
        }
    }
    public static void insert(DriverDAO driverDAO){
        System.out.print("Digite as informacoes do novo motorista: \n");
        try{
            System.out.println("CPF (12345678901): ");
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
            System.out.println("Telefone (DD9NNNNNNNN): ");
            String phone = input.nextLine( );
            Driver driver = new Driver(cpf, name, birthDate, licenseDriver, phone);
            driverDAO.insert(driver);
        } catch(InputMismatchException e){
            System.out.println("O valor digitado nao e do tipo especificado!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }

    public static void deleteById(DriverDAO driverDAO){
        System.out.println("Digite o ID do motorista a excluir: ");
        try{
            Integer id = input.nextInt( );
            driverDAO.deleteById(id);
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }
}
