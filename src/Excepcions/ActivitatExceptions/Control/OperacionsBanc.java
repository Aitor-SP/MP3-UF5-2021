package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;

public class OperacionsBanc {

    static List<compteEstalvi> compteEstalviList = new ArrayList<>();

    public static boolean verifyDNI(String dni) throws ClientAccountException {

        boolean correcto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(dni);

        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);

            if (reference.equalsIgnoreCase(letra)) {
                correcto = true;
            } else {
                correcto = false;
                throw new ClientAccountException(WRONG_DNI+ dni);
            }
        }
        return correcto;
    }

        public static boolean verifyAccount(String NumCompte) throws BankAccountException {

        if(!compteEstalviList.contains(NumCompte)){
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        }else{
            return false;
        }
    }

    public void transferencia(String NumCompte1, String NumCompte2, double saldo) throws BankAccountException {

        if(!verifyAccount(NumCompte1) || !verifyAccount(NumCompte2)){
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        }
        else{
            try{
                NumCompte1.treure(saldo);
            }catch (Exception e){
                throw new BankAccountException(TRANSFER_ERROR);
            }

            try{
                NumCompte2.ingressar(saldo);
            }catch (Exception e){
                throw new BankAccountException(TRANSFER_ERROR);
            }

        }
    }
}
