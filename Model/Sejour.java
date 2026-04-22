
import java.util.*;

/**
 * Classe représentant un séjour effectif dans l'hôtel.
 * Un séjour étend une réservation et inclut la date de fin réelle,
 * ainsi que les produits consommés et les activités pratiquées.
 */
public class Sejour {

    public Date dateFinReel;


    public Vector<Activites> listActivites;

    public Vector<Produits> lProduits;

    public Reservation reservation;

    public Sejour(Reservation r) {
        // Numéro de réservation associé au séjour
        //int numReservation = Reservation.getNumReservation();
        this.reservation = r;
        this.dateFinReel = reservation.dateFin;
        this.listActivites = new Vector<Activites>();
        this.lProduits = new Vector<Produits>();
        r.sejour=this ;
    }
    public Sejour(Reservation r, Date dateFinReel) {
        this(r);
        this.dateFinReel = dateFinReel;
        this.listActivites = new Vector<Activites>();
        this.lProduits = new Vector<Produits>();
        r.sejour=this;
    }

    public void addActivite(Activites a) {
        listActivites.add(a);
    }
    // Retourne la liste des activités d'un séjour donné
    private Activites[] getActivites() {
        return listActivites.toArray(new Activites[0]);
    }

    public float getPrixTotalActivite() {
        float total = 0;
        for (Activites a : listActivites) {
            total += a.getPrixActivite();
        }
        return total;
    }

    public void setDateFinReel(Date dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    public  int getNbJours() {
        return (int) ((dateFinReel.getTime() - reservation.dateDebut.getTime()) / (1000 * 60 * 60 * 24));
    }

     /*Retourne la liste des produits consommés durant le séjour */
    private Produits[] getlProduits() {
        return lProduits.toArray(new Produits[0]);
    }


    // Ajoute un produit à la liste des produits consommés durant le séjour
    public void addProduits(Produits p) {
        lProduits.add(p);
    }
    public float getPrixTotalProduit() {
        float total = 0;
        for (Produits p : lProduits) {
            total += p.getPrixProduit();
        }
        return total;
    }

    // Calcule et retourne le prix total réel du séjour
    // (prix de la chambre * nombre de jours réels) + total des produits consommés + activites faites
    //placeholder vraie fonction à recalculer
    public float getPrixTotalReel() {
        return reservation.chambre.getPrixChambre() * getNbJours() + getPrixTotalProduit() + getPrixTotalActivite();
    }


    public void infosSejour() {
        reservation.infosChambre();
        System.out.println("Date de fin réelle : " + dateFinReel);
        System.out.println("Nombre de jours : " + getNbJours());
        System.out.println("Activités : ");
        for (Activites a : listActivites) {
            System.out.println("- " + a.getNomActivite());
        }
        System.out.println("Produits : ");
        for (Produits p : lProduits) {
            System.out.println("- " + p.getNomProduit() + " : " + p.getPrixProduit());
        }
        System.out.println("Prix total réel : " + getPrixTotalReel());
    }


}
