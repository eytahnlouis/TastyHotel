
import java.io.*;
import java.util.*;

/**
 * Classe représentant un hôtel.
 * Un hôtel possède un nom, une adresse, et gère des chambres,
 * des clients, des réservations, des produits et des activités.
 */
public class Hotel {

    // Constructeur : initialise un hôtel avec son nom et son adresse
    public Hotel(String nomHotel, String adresse) {
        numHotel++;
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.lActivites = new Activites[0];   // liste vide d'activités
        this.lChambres = new Chambre[0];       // liste vide de chambres
        this.lClients = new Client[0];         // liste vide de clients
        this.lReservations = new Reservation[0]; // liste vide de réservations
        this.lProduits = new Produits[0];      // liste vide de produits
        this.numHotel = numHotel;
    }

    // Identifiant unique de l'hôtel (auto-incrémenté)
    private int numHotel;

    // Nom de l'hôtel
    public String nomHotel;

    // Adresse de l'hôtel
    public String adresse;

    // Liste des chambres de l'hôtel
    private Chambre[] lChambres;

    // Liste des clients enregistrés
    private Client[] lClients;

    // Liste des réservations effectuées
    private Reservation[] lReservations;

    // Liste des produits proposés par l'hôtel
    private Produits[] lProduits;

    // Liste des activités proposées par l'hôtel
    private Activites[] lActivites;

    // Retourne le numéro de l'hôtel
    public int getNumHotel() {
        return numHotel;
    }

    // Retourne le nom de l'hôtel
    public String getNomHotel() {
        return nomHotel;
    }

    // Retourne l'adresse de l'hôtel
    public String getAdresse() {
        return adresse;
    }

    // Retourne la liste complète des chambres
    public Chambre[] getLChambres() {
        return lChambres;
    }

    // Retourne uniquement les chambres disponibles
    public Chambre[] getlChambresDispo() {
        Chambre[] chambresDispo = new Chambre[lChambres.length];
        int index = 0;
        for (Chambre chambre : lChambres) {
            if (chambre.isDisponibilite()) {
                chambresDispo[index] = chambre;
                index++;
            }
        }
        return chambresDispo;
    }
}

