package Excepcions.ActivitatExceptions;

import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.Client;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClientAccountException {

        Scanner input = new Scanner(System.in);

        CompteEstalvi compteEstalvi = new CompteEstalvi();

        int opcion;

        do {
            System.out.println("1. Afegeix un usuari");
            System.out.println("2. Elimina un usuari");
            System.out.println("3. Treu diners del compte");
            System.out.println("4. Afegeix diners al compte");
            System.out.println("5. Fer una transferencia");
            System.out.println("6. Sortir");
            System.out.print("Introduïu l'opció: ");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Introduïu el DNI: ");
                    compteEstalvi.addUser();
                    compteEstalvi.getLlista_usuaris();
                    break;

                case 2:
                    compteEstalvi.getLlista_usuaris();
                    System.out.print("Introduïu el DNI: ");
                    compteEstalvi.removeUser();
                    break;

                case 3:
                    compteEstalvi.getNumCompte();
                    compteEstalvi.getSaldo();
                    compteEstalvi.treure();
                    break;

                case 4:
                    compteEstalvi.getNumCompte();
                    compteEstalvi.getSaldo();
                    compteEstalvi.ingressar();
                    break;

                case 5:
                    compteEstalvi.getNumCompte();
                    //OperacionsBanc.transferencia

                    break;

                case 6:
                    System.out.println("Gràcies, fins a la propera.");
                    break;

                default:
                    System.out.println("Triï una opció vàlida");
            }
        } while (opcion!=6);
    }
}
