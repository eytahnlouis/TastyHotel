
import java.io.*;
import java.util.*;

/**
 * Classe représentant un client de l'hôtel.
 * Un client possède un numéro unique, un nom, un prénom,
 * et un historique de ses réservations (compte de passages).
 */
public class Client {

    // Constructeur : crée un client avec son nom et prénom
    // Le numéro de client est auto-incrémenté
    // L'historique de passages est initialisé vide
    public Client(String nomClient, String prenomClient) {
        numClient++;
        this.comptePassage = new Reservation[0];
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    // Retourne le client passé en paramètre (méthode utilitaire)
    public Client getClient(Client c) {
        return c;
    }

    // Ajoute une nouvelle réservation vide à l'historique du client
    public void incrementComptePassage(Client c, Sejour s) {
        Sejour[] newComptePassage = new Reservation[comptePassage.length + 1];
        System.arraycopy(comptePassage, 0, newComptePassage, 0, comptePassage.length);
        newComptePassage[comptePassage.length] = s;
        comptePassage = newComptePassage;
    }

    // Numéro unique du client (statique : partagé entre toutes les instances)
    private static int numClient;

    /**
     *
     */
    protected String nomClient;

    /**
     *
     */
    protected String prenomClient;

    /**
     *
     */
    public int comptePassage;

    /**
     *
     */
    public Hotel hotel;

    /**
     *
     */
    public Vector<Reservation> listClient;

    // Retourne le numéro du client
    public int getNumClient() {
        return numClient;
    }

    // Affiche les informations complètes du client dans la console
    public void infosClient() {
        System.out.println("Numéro de client : " + numClient);
        System.out.println("Nom : " + this.nomClient);
        System.out.println("Prénom : " + this.prenomClient);
        System.out.println("Nombre de passages : " + getNbPassage());
    }

    // Retourne le nombre de passages (réservations) du client
    public int getNbPassage() {
        return listClient.size();
    }

    public Vector<Reservation> getListClient() {
        return new Vector<>(listClient);
    }
}
