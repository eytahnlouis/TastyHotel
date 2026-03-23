
import java.io.*;
import java.util.*;

/**
 * Classe représentant une réservation effectuée par un client.
 * Une réservation est associée à un client, une chambre,
 * une date de début et une date de fin.
 */
public class Reservation {

    // Constructeur : crée une réservation pour un client avec une chambre et des dates
    public Reservation(Client client, date debutR, date finR, Chambre chambre) {
        numReservation++;
        this.numReservation = numReservation;
        this.dateDebut = debutR;
        this.dateFin = finR;
        this.client = client;
        this.chambre = chambre;
    }

    // Identifiant unique de la réservation (auto-incrémenté)
    private int numReservation;

    // Date de début du séjour
    private date dateDebut;

    // Date de fin du séjour
    protected date dateFin;

    // Client associé à la réservation
    public Client client;

    // Chambre réservée (à redéfinir : peut-on changer de chambre ? protected ?)
    private Chambre chambre;

    // Retourne le numéro de la réservation
    public int getNumReservation() {
        return this.numReservation;
    }

    // Retourne le nombre de jours de la réservation
    public int getNbJours() {
        return dateFin - dateDebut;
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
}
