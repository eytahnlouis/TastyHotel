
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Classe représentant une réservation effectuée par un client.
 * Une réservation est associée à un client, une chambre,
 * une date de début et une date de fin.
 */
public class Reservation {

    // Constructeur : crée une réservation pour un client avec une chambre et des dates
    public Reservation(Client client, LocalDate debutR, LocalDate finR, Chambre chambre) throws IllegalArgumentException {
        numReservation++;
        this.dateDebut = debutR;
        this.dateFin = finR;
        this.client = client;
        this.chambre = chambre;
        if (chambre.getHotel().isRoomAvailable(debutR, finR, chambre)) {
            ajouterAHotel();
        } else {
            //System.out.println("La chambre n'est pas disponible pour les dates sélectionnées.");
            throw new IllegalArgumentException("Chambre non disponible");
        }

    }

    // Identifiant unique de la réservation (auto-incrémenté)
    private static int numReservation;


    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Client client;

    private Chambre chambre;

    private Sejour sejour;

    public void ajouterAHotel() {
        client.listReservation.add(this);
        chambre.ajoutRes(this);
    }
    // Retourne le numéro de la réservation
    public static int getNumReservation() {
        return numReservation;
    }

    // Retourne le nombre de jours de la réservation
    public int getNbJours() {
        return (int) ChronoUnit.DAYS.between(dateDebut, dateFin);
    }


    /** Calcule et retourne le prix total théorique de la réservation
    (prix de la chambre * nombre de jours) **/
    public float getPrixTotalTheorique() {
        if (client.isFaithful()) {
            return chambre.getPrixChambre() * getNbJours() * 0.9f; // 10% de réduction pour les clients fidèles
        }
        return chambre.getPrixChambre() * getNbJours();
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public LocalDate setDateDebut( LocalDate dateDebut) {
        return this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
    public LocalDate setDateFin( LocalDate dateFin) {
        return this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }
    public Client setClient( Client client) {
        return this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public Sejour getSejour() {
        return sejour;
    }
    public Sejour setSejour( Sejour sejour) {
        return this.sejour = sejour;
    }
    public void infosChambre() {
        System.out.println("Numéro de chambre : " + chambre.getNumChambre());
        System.out.println("Type de chambre : " + chambre.getTypeChambre());
        System.out.println("Prix de la chambre : " + chambre.getPrixChambre());
        System.out.println("Nombre de jours : " + getNbJours());
        System.out.println("Prix total théorique : " + getPrixTotalTheorique());
        client.infosClient();
    }
}
