
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
        this.numClient = numClient;
        this.comptePassage = new Reservation[0];
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    // Retourne le client passé en paramètre (méthode utilitaire)
    public Client getClient(Client c) {
        return c;
    }

    // Ajoute une nouvelle réservation vide à l'historique du client
    public void incrementComptePassage(Client c) {
        Reservation[] newComptePassage = new Reservation[comptePassage.length + 1];
        System.arraycopy(comptePassage, 0, newComptePassage, 0, comptePassage.length);
        newComptePassage[comptePassage.length] = new Reservation();
        comptePassage = newComptePassage;
    }

    // Numéro unique du client (statique : partagé entre toutes les instances)
    private static int numClient;

    // Nom de famille du client
    private String nomClient;

    // Prénom du client
    private String prenomClient;

    // Historique des réservations du client
    private Reservation[] comptePassage;

    // Retourne le numéro du client
    public int getNumClient() {
        return this.numClient;
    }

    // Affiche les informations complètes du client dans la console
    public void infosClient() {
        System.out.println("Numéro de client : " + this.numClient);
        System.out.println("Nom : " + this.nomClient);
        System.out.println("Prénom : " + this.prenomClient);
        System.out.println("Nombre de passages : " + getNbPassage());
    }

    // Retourne le nombre de passages (réservations) du client
    public int getNbPassage() {
        return comptePassage.length;
    }
}
