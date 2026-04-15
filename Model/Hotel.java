
import java.util.*;

/**
 * Classe représentant un hôtel.
 * Un hôtel possède un nom, une adresse, et gère des chambres,
 * des clients, des produits et des activités.
 */
public class Hotel {

    // Constructeur : initialise un hôtel avec son nom, adresse et liste de produits
    public Hotel(String nomHotel, String adresse) {
        numHotel++;
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.listeActivites = new Vector<Activites>();   // liste vide d'activités
        this.listChambre = new Vector<Chambre>();       // liste vide de chambres
        this.listeClient = new Vector<Client>();         // liste vide de clients
        this.listeProduits = new Vector<Produits>();      // liste vide de produits
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
    public void ajoutChambre(Chambre chambre) {
        listChambre.add(chambre);
    }
    // Retourne la liste complète des chambres
    public Vector <Chambre> getLChambres() {
        return listChambre;
    }


    public Vector<Produits> getListeProduits() {
        return listeProduits;
    }

    public Vector<Activites> getListeActivites() {
        return listeActivites;
    }

    public Vector<Chambre> getListChambre() {
        return listChambre;
    }

    public void afficherHotel(){
        System.out.println("------------------------------------");
        System.out.println("numHotel : " + numHotel);
        System.out.println("Nom de l'hotel : " + nomHotel);
        System.out.println("Adresse de l'hotel : " + adresse);
        System.out.println("Liste des produits : " + listeProduits.size());
        System.out.println("Liste des activités : " + listeActivites.size());
        System.out.println("Liste des chambres : " + listChambre.size());
        System.out.println("------------------------------------");
    }


}

