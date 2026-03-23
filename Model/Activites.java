
import java.io.*;
import java.util.*;

/**
 * Classe représentant une activité proposée par l'hôtel.
 * Une activité a un nom, un prix et une disponibilité.
 */
public class Activités {

    // Constructeur : initialise une activité avec son nom et son prix
    public Activités(String nomActivites, float prixActivites) {
        this.nomActivites = nomActivites;
        this.prixActivites = prixActivites;
    }

    // Identifiant unique de l'activité
    private int numActivites;

    // Nom de l'activité
    public String nomActivites;

    // Prix de l'activité
    private float prixActivites;

    // Disponibilité de l'activité (true = disponible)
    private boolean disponibilite;

    // Retourne le numéro de l'activité
    public int getNumActivites() {
        return this.numActivites;
    }

    // Modifie le numéro de l'activité
    public void setNumActivites(int numActivites) {
        this.numActivites = numActivites;
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
