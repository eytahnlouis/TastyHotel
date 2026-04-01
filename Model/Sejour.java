

import java.io.*;
import java.util.*;

/**
 * Classe représentant un séjour effectif dans l'hôtel.
 * Un séjour étend une réservation et inclut la date de fin réelle,
 * ainsi que les produits consommés et les activités pratiquées.
 */
public class Sejour {

    // Constructeur par défaut

    // Numéro de réservation associé au séjour
    private static int numReservation;

    /**
     *
     */
    public Date dateFinReel;

    /**
     *
     */
    public Vector<Activites> listActivites;

    /**
     *
     */
    public Reservation reservation;

    public Sejour(Reservation r, Date dateFinReel) {
        this.reservation = r;
        this.dateFinReel = reservation.getDateFin();
        this.listActivites = new Vector<>(listActivites);
    }

    public void addActivite(Activites a) {
        listActivites.add(a);
    }
    // Retourne la liste des activités d'un séjour donné
    public Activites[] getActivites() {
        return listActivites.toArray(new Activites[0]);
    }

    // Ajoute une activité à la liste des activités du séjour
    // Crée un nouveau tableau d'une case supplémentaire et y insère l'activité
    public Activites[] addActivite(Activites a) {
        Activites[] newActivites = new Activites[listActivites.size() + 1];
        listActivites.toArray(newActivites);
        newActivites[listActivites.size()] = a;
        listActivites = new Vector<>(Arrays.asList(newActivites));
        return newActivites;
    }

    // Retourne la liste des produits consommés durant le séjour
    public Produits[] getlProduits() {
        return lProduits;
    }

    // Ajoute un produit à la liste des produits consommés durant le séjour
    public void addProduits(Produits p) {
        Produits[] newProduits = new Produits[lProduits.length + 1];
        System.arraycopy(lProduits, 0, newProduits, 0, lProduits.length);
        newProduits[lProduits.length] = p;
        lProduits = newProduits;
    }

    // Calcule et retourne le prix total réel du séjour
    // (prix de la chambre * nombre de jours réels) + total des produits consommés
    public float getPrixTotalReel(Produits[] p) {
        return Reservation.chambre.getPrixChambre() * chambre.getNbJours() + Produits.getPrixProduit(p);
    }

    public Vector<Activites> getListActivites() {
        return new Vector<>(listActivites);
    }
}
