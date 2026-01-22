package com.projects.application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá seja bem-vindo(a) ao sistema de fretes!");
        Scanner input = new Scanner(System.in);
        int number = 0;
        do { 
            System.out.println("##### Sistema de Fretes #####");
            System.out.println("1. Fretes\n2. Veículos\n3. Motoristas\n4. Desligar");
            System.out.print("Qual opção deseja? ");
            number = Integer.parseInt(input.next( ));

            switch(number){
                case 1:
                    freightAuxiliar( );
                    break;
                case 2:
                    vehicleAuxiliar();
                    break;
                case 3:
                    driverAuxiliar();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Entrada inválida! Tente novamente...");
            }
        } while (number != 4);
        System.out.println("Encerrando o sistema...");
    }

    public static void freightAuxiliar( ){

    }
    public static void vehicleAuxiliar( ){
        
    }
     public static void driverAuxiliar( ){
        
    }
}
