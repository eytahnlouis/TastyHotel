
import java.io.*;
import java.util.*;

/**
 * Classe représentant un séjour effectif dans l'hôtel.
 * Un séjour étend une réservation et inclut la date de fin réelle,
 * ainsi que les produits consommés et les activités pratiquées.
 */
public class Sejour {

    // Constructeur par défaut

    /**
     *
     */
    public Date dateFinReel;

    /**
     *
     */
    public Vector<Activites> listActivites;

    public Vector<Produits> lProduits;

    /**
     *
     */
    public Reservation reservation;

    public Sejour(Reservation r, Date dateFinReel) {
        // Numéro de réservation associé au séjour
        int numReservation = Reservation.getNumReservation();
        this.reservation = r;
        this.dateFinReel = reservation.dateFin;
        this.listActivites = new Vector<Activites>();
        this.lProduits = new Vector<Produits>();
    }

    public void addActivite(Activites a) {
        listActivites.add(a);
    }
    // Retourne la liste des activités d'un séjour donné
    public Activites[] getActivites() {
        return listActivites.toArray(new Activites[0]);
    }



    // Retourne la liste des produits consommés durant le séjour
    public Produits[] getlProduits() {
        return lProduits.toArray(new Produits[0]);
    }

    // Ajoute un produit à la liste des produits consommés durant le séjour
    public void addProduits(Produits p) {
        lProduits.add(p);
    
    }

    // Calcule et retourne le prix total réel du séjour
    // (prix de la chambre * nombre de jours réels) + total des produits consommés + activites faites
    //placeholder vraie fonction à recalculer
    public float getPrixTotalReel() {
        //return reservation.chambre.getPrixChambre() * reservation.getNbJours() + p.getPrixProduit(); ;
        return 0;
    }

    public Vector<Activites> getListActivites() {
        return new Vector<>(listActivites);
    }

    public void infosSejour() {
        reservation.infosChambre();
        System.out.println("Date de fin réelle : " + dateFinReel);
        System.out.println("Activités : ");
        for (Activites a : listActivites) {
            System.out.println("- " + a.getNomActivite());
        }
    }
}
