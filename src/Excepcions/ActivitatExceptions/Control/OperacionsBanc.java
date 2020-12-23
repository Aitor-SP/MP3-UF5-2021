package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;

public class OperacionsBanc {

    List<CompteEstalvi> compteEstalviList = new ArrayList<>();

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
                throw new ClientAccountException(WRONG_DNI + dni);
            }
        }
        return correcto;
    }

    public boolean verifyAccount(CompteEstalvi numCompte) throws BankAccountException {

        boolean correcto = false;
        for (CompteEstalvi ce : compteEstalviList) {
            if (ce.getNumCompte().equals(numCompte)) {
                correcto = true;
            } else {
                correcto =  false;
                throw new BankAccountException(ACCOUNT_NOT_FOUND);
            }
        }
        return correcto;
    }

    public void transferencia (CompteEstalvi cc1, CompteEstalvi cc2, double saldo) throws BankAccountException {
        if (!verifyAccount(cc1) || !verifyAccount(cc2)){
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        } else {
            try {
                cc1.treure(saldo);
            } catch (Exception e) {
                throw new BankAccountException(ACCOUNT_OVERDRAFT);
            }
            try {
                cc2.ingressar(saldo);
            } catch (Exception e) {
                throw new BankAccountException(TRANSFER_ERROR);
            }
        }
    }
}