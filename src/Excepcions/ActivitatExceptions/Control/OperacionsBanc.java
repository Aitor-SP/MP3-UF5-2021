package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.List;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;

public class OperacionsBanc {

    static List<CompteEstalvi> compteEstalviList = new ArrayList<>();

    public static boolean verifyDNI(String DNI) throws ClientAccountException {

        if(DNI.length() != 9){
            throw new ClientAccountException(WRONG_DNI);
        }
        else {return true;}
    }

    public static boolean verifyAccount(CompteEstalvi numCompte) throws BankAccountException {

        if(!compteEstalviList.contains(numCompte)){
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        }else{
            return false;
        }
    }

    public static void transferencia (CompteEstalvi ce1, CompteEstalvi ce2, double saldo) throws BankAccountException {
        if (ce1.getSaldo() >= saldo) {
            ce1.treure(saldo);
            ce2.ingressar(saldo);
        } else {
            throw new BankAccountException(TRANSFER_ERROR);
        }
    }
}