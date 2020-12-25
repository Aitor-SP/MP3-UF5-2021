package Excepcions.ActivitatExceptions.Model;

import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import java.util.List;

public class Client {
    private String Nom;
    private String Cognoms;
    private String DNI;

    List<Client> clientList;

    public Client(String nom, String cognoms, String DNI) throws ClientAccountException {
        this.Nom = nom;
        this.Cognoms = cognoms;
        if(OperacionsBanc.verifyDNI(DNI)) this.DNI = DNI;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public void setCognoms(String cognoms) {
        Cognoms = cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Nom='" + Nom + '\'' +
                ", Cognoms='" + Cognoms + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
