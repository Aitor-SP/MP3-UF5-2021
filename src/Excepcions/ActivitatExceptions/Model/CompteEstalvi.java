package Excepcions.ActivitatExceptions.Model;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;

import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.List;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;
import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.TRANSFER_ERROR;

public class CompteEstalvi {
    private String numCompte;
    private double saldo;
    private List<Client> llista_usuaris;

    public CompteEstalvi(String numCompte) {
        llista_usuaris = new ArrayList<>();
        this.numCompte = numCompte;
        saldo = 0;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLlista_usuaris(List<Client> llista_usuaris) {
        this.llista_usuaris = llista_usuaris;
    }

    /**
        Afegeix un usuari d'aquest compte
        @param client
        @return quantitat d'usuaris que té el compte

     **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    /**
     Elimina un usuari d'aquest compte,
     Com que no pot quedar un compte sense usuari, si és l'ùltim és llança una excepció
     @param dni
     @return quantitat d'usuaris que té el compte
     @throws BankAccountException
     **/
    public int removeUser(String dni) throws BankAccountException {
        if(llista_usuaris.size() <= 1){
            throw new BankAccountException(ACCOUNT_ZERO_USER);
        }else{
            llista_usuaris.removeIf(u -> dni.equals(u.getDNI()));
        }
        return llista_usuaris.size();
    }

    /**
     * Afegeix m diners al saldo
     * @param m
     */
    public void ingressar(double m) {
        saldo += m;
    }

    /**
     * Treu m diners del compte si n'hi han suficient sinó es llança l'excepció
     * @param m
     * @throws BankAccountException
     */
    public void treure(double m) throws BankAccountException {
        if (saldo < m){
            throw new BankAccountException(ACCOUNT_OVERDRAFT);
        } else {
            saldo -= m;
        }
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() throws ClientAccountException {
        if(llista_usuaris.size() <= 1){
            throw new ClientAccountException(ACCOUNT_ZERO_USER);
        }else {
            return llista_usuaris;
        }
    }

    @Override
    public String toString() {
        return "CompteEstalvi{" +
                "numCompte='" + numCompte + '\'' +
                ", saldo=" + saldo +
                ", llista_usuaris=" + llista_usuaris +
                '}';
    }
}
