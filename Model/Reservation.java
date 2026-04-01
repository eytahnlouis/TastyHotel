
import java.io.*;
import java.util.*;

/**
 * Classe représentant une réservation effectuée par un client.
 * Une réservation est associée à un client, une chambre,
 * une date de début et une date de fin.
 */
public class Reservation {

    // Constructeur : crée une réservation pour un client avec une chambre et des dates
    public Reservation(Client client, Date debutR, Date finR, Chambre chambre) {
        numReservation++;
        this.dateDebut = debutR;
        this.dateFin = finR;
        this.client = client;
        this.chambre = chambre;
        ajouterAHotel();
    }

    // Identifiant unique de la réservation (auto-incrémenté)
    private static int numReservation;

    /**
     *
     */
    public Date dateDebut;

    /**
     *
     */
    public Date dateFin;

    /**
     *
     */
    public Client client;

    /**
     *
     */
    public Chambre chambre;

    /**
     *
     */
    public Sejour sejour;

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
        return (int) ((dateFin.getTime() - dateDebut.getTime()) / (1000 * 60 * 60 * 24));
    }

    // Retourne le client associé à une réservation donnée
    // Note : à vérifier, méthode redondante avec l'attribut public
    public Client getClientRes(Reservation r) {
        return r.client;
    }

    // Calcule et retourne le prix total théorique de la réservation
    // (prix de la chambre * nombre de jours)
    public float getPrixTotalTheorique() {
        return chambre.getPrixChambre() * getNbJours();
    }

    public void infosChambre() {
        System.out.println("Numéro de chambre : " + chambre.getNumChambre());
        System.out.println("Type de chambre : " + chambre.getTypeChambre());
        System.out.println("Prix de la chambre : " + chambre.getPrixChambre());
        System.out.println("Nombre de jours : " + getNbJours());
    }
}
