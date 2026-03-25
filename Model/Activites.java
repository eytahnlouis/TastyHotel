
import java.io.*;
import java.util.*;

/**
 * Classe représentant une activité proposée par l'hôtel.
 * Une activité a un nom, un prix et une disponibilité.
 */
public class Activites {

    // Constructeur : initialise une activité avec son nom et son prix
    public Activites(String nomActivites, float prixActivites) {
        numActivites++;
        this.nomActivites = nomActivites;
        this.prixActivites = prixActivites;
        this.disponibilite = true;
    }

    // Identifiant unique de l'activité
    private static int numActivites = 0;

    // Nom de l'activité
    protected String nomActivites;

    // Prix de l'activité
    private float prixActivites;

    // Disponibilité de l'activité (true = disponible)
    private boolean disponibilite;

    // Retourne le numéro de l'activité
    public static int getNumActivites() {
        return numActivites;
    }

    // Retourne le nom de l'activité
    public String getNomActivites() {
        return this.nomActivites;
    }

    // Modifie le nom de l'activité
    public void setNomActivites(String nomActivites) {
        this.nomActivites = nomActivites;
    }

    // Retourne le prix de l'activité
    public float getPrixActivites() {
        return this.prixActivites;
    }

    // Modifie le prix de l'activité
    public void setPrixActivites(float prixActivites) {
        this.prixActivites = prixActivites;
    }

    // Retourne true si l'activité est disponible
    public boolean isDisponibilite() {
        return this.disponibilite;
    }

    // Bascule la disponibilité de l'activité (disponible <-> indisponible)
    public void setDisponibilite() {
        this.disponibilite = !disponibilite;
    }
}
