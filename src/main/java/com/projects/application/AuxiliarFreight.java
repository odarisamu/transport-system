package com.projects.application;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.projects.dao.FreightDAO;
import com.projects.entities.Freight;

public class AuxiliarFreight {
    public static Scanner input = new Scanner(System.in);

    public static void changePayment(FreightDAO freightDAO){
        System.out.println("Digite o ID da carga para alterar o pagamento: ");
        try{
            Integer id = input.nextInt( );
            freightDAO.changePayment(id);
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }

    public static void findNotPaid(FreightDAO freightDAO){
        List<Freight> freightsNotPaid = freightDAO.findNotPaid();
        if(freightsNotPaid.isEmpty()){
            System.out.println("Nao há fretes pendentes no banco de dados!");
        } else{
            for(Freight freight : freightsNotPaid){
                System.out.println(freight);
            }
        }
    }

    public static void findPaid(FreightDAO freightDAO){
        List<Freight> freightsPaid = freightDAO.findPaid();
        if(freightsPaid.isEmpty()){
            System.out.println("Nao há fretes pagos no banco de dados!");
        } else{
            for(Freight freight : freightsPaid){
                System.out.println(freight);
            }
        }
    }

    public static void listAll(FreightDAO freightDAO){
        List<Freight> freights = freightDAO.listAll();
        if(freights.isEmpty()){
            System.out.println("Nao há fretes no banco de dados!");
        } else{
            for(Freight freight : freights){
                System.out.println(freight);
            }
        }
    }

    public static void insert(FreightDAO freightDAO){
        System.out.print("Digite as informacoes do novo frete: \n");
        try{
            System.out.println("ID do motorista: ");
            Integer idDriver = input.nextInt( );
            System.out.println("ID do veiculo: ");
            Integer idVehicle = input.nextInt( );
            System.out.println("Valor do frete: ");
            Double value = input.nextDouble( );
            System.out.println("Lugar de origem: ");
            String placeOrigin = input.nextLine( );
            System.out.println("Lugar de destino: ");
            String placeDestiny = input.nextLine( );
            System.out.println("Peso da carga ");
            Double weight = input.nextDouble( );
            System.out.println("Tipo da carga: ");
            String type = input.nextLine( );
            Freight freight = new Freight(idDriver, idVehicle, value, placeOrigin, placeDestiny, false, weight, type);
            freightDAO.insert(freight);
        } catch(InputMismatchException e){
            System.out.println("O tipo digitado nao corresponde ao requerido!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }
    
    public static void update(FreightDAO freightDAO){
        Freight freight = findByIdAux(freightDAO);
        if(freight != null){
            System.out.println("Selecione uma das opcoes para atualizar no frete \n" + 
            "1. ID do motorista \n" +
            "2. ID do veículo \n" + 
            "3. Valor \n" +
            "4. Lugar de Origem \n" +
            "5. Lugar de Destino\n" +
            "6. Peso\n" + 
            "7. Tipo\n");
            try{
                Integer option = input.nextInt( );
                switch(option){
                    case 1:
                        System.out.println("Digite o ID do motorista: ");
                        Integer idDriver = input.nextInt( );
                        freight.setIdDriver(idDriver);
                        freightDAO.update(freight);
                        break;
                    case 2:
                        System.out.println("Digite o ID do veículo: ");
                        Integer idVehicle = input.nextInt( );
                        freight.setIdVehicle(idVehicle);
                        freightDAO.update(freight);
                        break;
                    case 3:
                        System.out.println("Digite o valor do frete: ");
                        Double value = input.nextDouble( );
                        freight.setValue(value);
                        freightDAO.update(freight);
                        break;
                    case 4:
                        System.out.println("Digite o lugar de origem do frete: ");
                        String placeOrigin  = input.nextLine( );
                        freight.setPlaceOrigin(placeOrigin);
                        freightDAO.update(freight);
                        break;
                    case 5:
                        System.out.println("Digite o lugar de destino do frete: ");
                        String placeDestiny  = input.nextLine( );
                        freight.setPlaceDestiny(placeDestiny);
                        freightDAO.update(freight);
                        break;
                    case 6:
                        System.out.println("Digite o peso do frete: ");
                        Double weight  = input.nextDouble( );
                        freight.setWeight(weight);
                        freightDAO.update(freight);
                        break;
                    case 7:
                        System.out.println("Digite o Tipo do frete: ");
                        String type  = input.nextLine( );
                        freight.setType(type);
                        freightDAO.update(freight);
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

    public static void deleteById(FreightDAO freightDAO){
        System.out.println("Digite o ID do frete a excluir: ");
        try{
            Integer id = input.nextInt( );
            freightDAO.deleteById(id);
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }

    public static void findById(FreightDAO freightDAO){
        System.out.println("Insira o ID do frete procurado: ");
        try{
            Integer id = Integer.parseInt(input.next( ));
            Freight freight = freightDAO.findById(id);
            if(freight != null){
                System.out.println(freight);
            } else{
                System.out.println("Nao há fretes com o ID informado.");
            }
        } catch(InputMismatchException e){
            System.out.println("O valor digitado deve ser um inteiro!");
        } catch(Exception e){
            System.out.println("Erro desconhecido!");
        }
    }

        public static Freight findByIdAux(FreightDAO freightDAO){
        System.out.println("Insira o ID do frete procurado: ");
        try{
            Integer id = Integer.parseInt(input.next( ));
            Freight freight = freightDAO.findById(id);
            if(freight != null){
                return freight;
            } else{
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
}
