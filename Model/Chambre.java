
import java.util.*;

/**
 * Classe représentant une chambre d'hôtel.
 * Une chambre est définie par son type, son numéro, son étage,
 * son prix par nuit et sa disponibilité.
 */
public class Chambre {
    // Type de la chambre (ex : simple, double, suite...)
    private int numChambre;

    private String typeChambre;

    private int numEtage;

    public float prixChambre;

    private Vector<Reservation> listReservation;


    public Hotel hotel;
    // Constructeur : initialise une chambre avec ses caractéristiques
    public Chambre(String typeChambre, int numChambre, int numEtage, float prixChambre, Hotel hotel) {
        this.listReservation = new Vector<Reservation>();
        this.typeChambre = typeChambre;
        this.numChambre = numChambre;
        this.numEtage = numEtage;
        this.prixChambre = prixChambre;
        this.hotel = hotel;
        hotel.ajoutChambre(this);
    }

   public void ajoutRes(Reservation r)
   {
       listReservation.add(r);
   }
    // Retourne le type de la chambre
    public String getTypeChambre() {
        return this.typeChambre;
    }

    // Retourne le numéro de la chambre
    public int getNumChambre() {
        return this.numChambre;
    }

    // Retourne le numéro de l'étage
    public int getNumEtage() {
        return this.numEtage;
    }

    public Vector<Reservation> getListReservation() {
        return this.listReservation;
    }

    // Retourne le prix de la chambre par nuit
    public float getPrixChambre() {
        return this.prixChambre;
    }

    // Modifie le type de la chambre
    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    // Modifie le numéro de la chambre
    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }

    // Modifie le prix de la chambre
    public void setPrixChambre(float prixChambre) {
        this.prixChambre = prixChambre;
    }

    public boolean isLastDay() {
        Reservation res = listReservation.getLast();
        Date today = new Date();
        return res.dateFin.equals(today);
    }

    public void afficherChambre() {
        System.out.println("Numéro de chambre : " + numChambre);
        System.out.println("Type de chambre : " + typeChambre);
        System.out.println("Numéro d'étage : " + numEtage);
        System.out.println("Prix de la chambre par nuit : " + prixChambre);
    }

}
