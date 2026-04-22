
import java.util.*;

//import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Classe représentant une chambre d'hôtel.
 * Une chambre est définie par son type, son numéro, son étage,
 * son prix par nuit et sa disponibilité.
 */
public class Chambre {
    // Type de la chambre (ex : simple, double, suite...)
    private int numChambre;

    private String typeChambre;

    private final int numEtage;

    private float prixChambre;

    private final Vector<Reservation> listReservation;


    private Hotel hotel;
    // Constructeur : initialise une chambre avec ses caractéristiques
    public Chambre(String typeChambre, int numChambre, int numEtage, float prixChambre, Hotel hotel) {
        this.listReservation = new Vector<>();
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

    public Sejour getLastSejour() {
        Sejour lastSejour = null;

        for (Reservation res : listReservation) {
            Sejour current = res.sejour;
            if (current == null || current.dateFinReel == null) {
                continue;
            }

            if (lastSejour == null
                    || lastSejour.dateFinReel == null
                    || current.dateFinReel.after(lastSejour.dateFinReel)) {
                lastSejour = current;
            }
        }

        return lastSejour;
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
        Sejour res = getLastSejour();
        if (res == null) return false;
        Date today = new Date();
        return res.dateFinReel.equals(today);
    }

    public void afficherChambre() {
        System.out.println("Numéro de chambre : " + numChambre);
        System.out.println("Type de chambre : " + typeChambre);
        System.out.println("Numéro d'étage : " + numEtage);
        System.out.println("Prix de la chambre par nuit : " + prixChambre);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
