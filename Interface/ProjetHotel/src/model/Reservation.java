package model;
import model.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe repr�sentant une r�servation effectu�e par un client.
 * Une r�servation est associ�e � un client, une chambre,
 * une date de d�but et une date de fin.
 */
public class Reservation {

    // Constructeur : cr�e une r�servation pour un client avec une chambre et des dates
    public Reservation(Client client, LocalDate debutR, LocalDate finR, Chambre chambre) throws IllegalArgumentException {
        numReservation++;
        this.dateDebut = debutR;
        this.dateFin = finR;
        this.client = client;
        this.chambre = chambre;
        if (chambre.getHotel().isRoomAvailable(debutR, finR, chambre)) {
            ajouterAHotel();
        } else {
            //System.out.println("La chambre n'est pas disponible pour les dates s�lectionn�es.");
            throw new IllegalArgumentException("Chambre non disponible");
        }

    }

    // Identifiant unique de la r�servation (auto-incr�ment�)
    private static int numReservation;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Client client;

    private Chambre chambre;

    private Sejour sejour;

    public void ajouterAHotel() {
        client.ajouterReservation(this);
        chambre.ajoutRes(this);
    }
    // Retourne le num�ro de la r�servation
    public static int getNumReservation() {
        return numReservation;
    }

    // Retourne le nombre de jours de la r�servation
    public int getNbJours() {
        return (int) ChronoUnit.DAYS.between(dateDebut, dateFin);
    }


    /** Calcule et retourne le prix total th�orique de la r�servation
     (prix de la chambre * nombre de jours) **/
    public float getPrixTotalTheorique() {
        if (client.isFaithful()) {
            return chambre.getPrixChambre() * getNbJours() * 0.9f; // 10% de r�duction pour les clients fid�les
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
    public void setDateFin( LocalDate dateFin) {
        this.dateFin = dateFin;
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
    public void setSejour(Sejour sejour) {
        this.sejour = sejour;
    }
    public void infosChambre() {
        System.out.println("Num�ro de chambre : " + chambre.getNumChambre());
        System.out.println("Type de chambre : " + chambre.getTypeChambre());
        System.out.println("Prix de la chambre : " + chambre.getPrixChambre());
        System.out.println("Nombre de jours : " + getNbJours());
        System.out.println("Prix total th�orique : " + getPrixTotalTheorique());
        client.infosClient();
    }
}