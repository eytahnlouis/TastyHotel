
import java.util.*;

/**
 * Classe représentant un client de l'hôtel.
 * Un client possède un numéro unique, un nom, un prénom,
 * et un historique de ses réservations (compte de passages).
 */
public class Client {

    // Constructeur : crée un client avec son nom, prénom et hôtel
    // Le numéro de client est auto-incrémenté
    // L'historique de passages est initialisé vide


    // Ajoute une nouvelle réservation vide à l'historique du client


    // Numéro unique du client (statique : partagé entre toutes les instances)
    private static int numClient;

    protected String nomClient;

    protected String prenomClient;

    public int comptePassage;

    private final Hotel hotel;

    public Vector<Reservation> listReservation;

    public Client(String nomClient, String prenomClient, Hotel hotel) {
        numClient++;
        this.comptePassage = 0;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.hotel = hotel;
        this.listReservation = new Vector<Reservation>();
        ajouterAHotel();
    }

    public void addReservation(Reservation reservation) {
        listReservation.add(reservation);
    }

    public void ajouterAHotel() {
        hotel.listeClient.add(this);
    }

    // Retourne le numéro du client
    public int getNumClient() {
        return numClient;
    }
    // Retourne le nombre de passages (réservations) du client

    public boolean isFaithful() {
        return listReservation.size() >= 10;
    }
    public Vector<Reservation> getListReservation() {
        return new Vector<>(listReservation);
    }

    public float getTotalSpent() {
        float total = 0;
        for (Reservation reservation : listReservation) {
            total += reservation.getPrixTotalTheorique();
        }
        return total;
    }
    // Affiche les informations complètes du client dans la console
    public void infosClient() {
        System.out.println("Numéro de client : " + numClient);
        System.out.println("Nom : " + this.nomClient);
        System.out.println("Prénom : " + this.prenomClient);
        System.out.println("Nombre de passages : " + listReservation.size());
    }
}



