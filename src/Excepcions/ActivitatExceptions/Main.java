package Excepcions.ActivitatExceptions;

import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.Client;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClientAccountException, BankAccountException {

        Scanner input = new Scanner(System.in);
        CompteEstalvi ce1 = new CompteEstalvi("123456789");
        CompteEstalvi ce2 = new CompteEstalvi("987654321");
        CompteEstalvi ce3 = new CompteEstalvi("666666666");
        List<CompteEstalvi> compteEstalviList = new ArrayList<>(Arrays.asList(ce1,ce2));
        compteEstalviList.addAll(compteEstalviList);
        ce1.ingressar(5000);
        ce2.ingressar(2000);
        Client client = null;
        int opcion;

        do{
            System.out.println("1. Error -> WRONG_DNI = DNI incorrecte");
            System.out.println("2. Error -> ACCOUNT_NOT_FOUND = Compte inexistent");
            System.out.println("3. Error -> ACCOUNT_OVERDRAFT = Compte al descobert");
            System.out.println("4. Error -> ACCOUNT_ZERO_USER = Compte sense usuari");
            System.out.println("5. Error -> TRANSFER_ERROR = Error en la transferència");
            System.out.println("6. Sortir -> BON NADAL!!");
            System.out.print("Introduïu l'opció: ");
            opcion = input.nextInt();

            switch (opcion){
                case 1:
                    client = new Client("Aitor", "Sancho Pérez", "123456789A");
                    break;

                case 2:
                    OperacionsBanc.verifyAccount(ce3);
                    break;

                case 3:
                    ce2.treure(5000);
                    break;

                case 4:
                    ce1.getLlista_usuaris();
                    break;

                case 5:
                    OperacionsBanc.transferencia(ce1,ce2,50000000);
                    break;

                case 6:
                    System.out.println("Gràcies i BON NADAL!!");
                    break;

                default:
                    System.out.println("Triï una opció vàlida");
            }
        } while (opcion != 6);
    }
}