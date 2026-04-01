
import java.io.*;
import java.util.*;

/**
 * Classe représentant un hôtel.
 * Un hôtel possède un nom, une adresse, et gère des chambres,
 * des clients, des produits et des activités.
 */
public class Hotel {

    // Constructeur : initialise un hôtel avec son nom et son adresse
    public Hotel(String nomHotel, String adresse) {
        numHotel++;
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.listeActivites = new Activites[0];   // liste vide d'activités
        this.listChambre = new Chambre[0];       // liste vide de chambres
        this.listeClient = new Client[0];         // liste vide de clients
        this.listeProduits = new Produits[0];      // liste vide de produits
        this.numHotel = numHotel;
    }

    // Identifiant unique de l'hôtel (auto-incrémenté)
    private static int numHotel;

    // Nom de l'hôtel
    public String nomHotel;

    // Adresse de l'hôtel
    public String adresse;

    // Liste des chambres de l'hôtel
    public Vector<Produits> listeProduits;

    public Vector<Activites> listeActivites;


    public Vector<Client> listeClient;


    public Vector<Chambre> listChambre;

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

    public Vector<Produits> getListeProduits() {

        return null;
    }

    public Vector<Activites> getListeActivites() {

        return null;
    }

    public Vector<Chambre> getListChambre() {

        return null;
    }
}

