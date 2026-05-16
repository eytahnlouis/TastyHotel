package model;
import model.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Classe repr�sentant un client de l'h�tel.
 * Un client poss�de un num�ro unique, un nom, un pr�nom,
 * et un historique de ses r�servations (compte de passages).
 */
public class Client {

    // Constructeur : cr�e un client avec son nom, pr�nom et h�tel
    // Le num�ro de client est auto-incr�ment�
    // L'historique de passages est initialis� vide


    // Ajoute une nouvelle r�servation vide � l'historique du client


    // Num�ro unique du client (statique : partag� entre toutes les instances)
    private static int numClient;

    protected String nomClient;

    protected String prenomClient;

    public int comptePassage;

    private final Hotel hotel;

    private Vector<Reservation> listReservation;

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

    public void removeReservation(Reservation reservation) {
        listReservation.remove(reservation);
    }

    public void ajouterAHotel() {
        hotel.getListClient().add(this);
    }

    public boolean isPresentInHotelToday( LocalDate date) {
        return getListReservation().stream().anyMatch(r -> r.getSejour().getDateFinReel().isEqual(date));
    }

    // Retourne le num�ro du client
    public int getNumClient() {
        return numClient;
    }

    public boolean isFaithful() {
        return listReservation.size() >= 10;
    }
    public Vector<Reservation> getListReservation() {
        return new Vector<>(listReservation);
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public float getTotalSpent() {
        float total = 0;
        for (Reservation reservation : listReservation) {
            total += reservation.getPrixTotalTheorique();
        }
        return total;
    }
    // Affiche les informations compl�tes du client dans la console
    public void infosClient() {
        System.out.println("Num�ro de client : " + numClient);
        System.out.println("Nom : " + this.nomClient);
        System.out.println("Pr�nom : " + this.prenomClient);
        System.out.println("Nombre de passages : " + listReservation.size());
    }
}



