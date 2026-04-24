package model;
import java.io.*;
import java.util.*;

/**
 * Classe représentant une activité proposée par l'hôtel.
 * Une activité a un nom, un prix et une disponibilité.
 */
public class Activites {

    // Constructeur : initialise une activité avec son nom et son prix
    public Activites(String nomActivite, float prixActivite, Hotel hotel) {
        numActivite++;
        this.nomActivite = nomActivite;
        this.prixActivite = prixActivite;
        this.hotel = hotel;
        ajouterAHotel();
    }

    // Identifiant unique de l'activité
    private static int numActivite = 0;

    private String nomActivite;


    private float prixActivite;


    private final Hotel hotel;

    // Retourne le numéro de l'activité
    public static int getNumActivite() {
        return numActivite;
    }

    public void ajouterAHotel() {
        hotel.listeActivites.add(this);
    }
    // Retourne le nom de l'activité
    public String getNomActivite() {
        return this.nomActivite;
    }

    // Modifie le nom de l'activité
    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    // Retourne le prix de l'activité
    public float getPrixActivite() {
        return this.prixActivite;
    }

    // Modifie le prix de l'activité
    public void setPrixActivite(float prixActivite) {
        this.prixActivite = prixActivite;
    }

    public void afficherInfos() {
        System.out.println("Nom de l'activité : " + nomActivite);
        System.out.println("Prix de l'activité : " + prixActivite);
    
    }
}

