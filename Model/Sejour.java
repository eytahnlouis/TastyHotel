

import java.io.*;
import java.util.*;

/**
 * Classe représentant un séjour effectif dans l'hôtel.
 * Un séjour étend une réservation et inclut la date de fin réelle,
 * ainsi que les produits consommés et les activités pratiquées.
 */
public class Sejour extends Reservation {

    // Constructeur par défaut
    public Sejour() {
    }

    // Numéro de réservation associé au séjour
    private int numReservation;

    // Date de fin réelle du séjour (peut différer de la date prévue)
    public date dateFinReel;

    // Liste des produits consommés durant le séjour
    public Produits[] lProduits;

    // Liste des activités pratiquées durant le séjour
    public Activites[] lActivites;

    // Retourne la liste des activités d'un séjour donné
    public Activites[] getActivites(Sejour s) {
        return s.lActivites;
    }

    // Ajoute une activité à la liste des activités du séjour
    // Crée un nouveau tableau d'une case supplémentaire et y insère l'activité
    public Activites[] addActivite(Activites a) {
        Activites[] newActivites = new Activites[lActivites.length + 1];
        System.arraycopy(lActivites, 0, newActivites, 0, lActivites.length);
        newActivites[lActivites.length] = a;
        lActivites = newActivites;
        return lActivites;
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
}
