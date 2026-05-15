package model;
import model.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Classe repr�sentant un s�jour effectif dans l'h�tel.
 * Un s�jour �tend une r�servation et inclut la date de fin r�elle,
 * ainsi que les produits consomm�s et les activit�s pratiqu�es.
 */
public class Sejour {

    private LocalDate dateFinReel;

    private Vector<Activites> listActivites;

    private Vector<Produits> lProduits;

    private Reservation reservation;

    public Sejour(Reservation r) {
        // Num�ro de r�servation associ� au s�jour
        //int numReservation = Reservation.getNumReservation();
        this.reservation = r;
        this.dateFinReel = reservation.getDateFin();
        this.listActivites = new Vector<Activites>();
        this.lProduits = new Vector<Produits>();
        r.setSejour(this);
    }
    public Sejour(Reservation r, LocalDate dateFinReel) {
        this(r);
        this.dateFinReel = dateFinReel;
        this.listActivites = new Vector<Activites>();
        this.lProduits = new Vector<Produits>();
        r.setSejour(this);
    }

    public LocalDate getDateFinReel() {
        return dateFinReel;
    }
    public Reservation getReservation() {
        return reservation;
    }
    public void getSejour() {
        
        reservation.getSejour();
    }

    public Vector <Produits> getListProduits() {
        return lProduits;
    }
    public Vector <Activites> getListActivites() {
        return listActivites;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // Ajoute une activit� � la liste des activit�s pratiqu�es durant le s�jour

    public void addActivite(Activites a) {
        listActivites.add(a);
    }
    // Retourne la liste des activit�s d'un s�jour donn�
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

    public void setDateFinReel(LocalDate dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    public  int getNbJours() {
        return (int) (ChronoUnit.DAYS.between(reservation.getDateDebut(), dateFinReel));
    }

    /*Retourne la liste des produits consomm�s durant le s�jour */
    private Produits[] getlProduits() {
        return lProduits.toArray(new Produits[0]);
    }


    // Ajoute un produit � la liste des produits consomm�s durant le s�jour
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

    // Calcule et retourne le prix total r�el du s�jour
    // (prix de la chambre * nombre de jours r�els) + total des produits consomm�s + activites faites
    //placeholder vraie fonction � recalculer
    public float getPrixTotalReel() {
        return reservation.getChambre().getPrixChambre() * getNbJours() + getPrixTotalProduit() + getPrixTotalActivite();
    }


    public void infosSejour() {
        reservation.infosChambre();
        System.out.println("Date de fin r�elle : " + dateFinReel);
        System.out.println("Nombre de jours : " + getNbJours());
        System.out.println("Activit�s : ");
        for (Activites a : listActivites) {
            System.out.println("- " + a.getNomActivite());
        }
        System.out.println("Produits : ");
        for (Produits p : lProduits) {
            System.out.println("- " + p.getNomProduit() + " : " + p.getPrixProduit());
        }
        System.out.println("Prix total r�el : " + getPrixTotalReel());
    }


}
