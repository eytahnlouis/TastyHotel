
import java.io.*;
import java.util.*;

/**
 * Classe représentant une chambre d'hôtel.
 * Une chambre est définie par son type, son numéro, son étage,
 * son prix par nuit et sa disponibilité.
 */
public class Chambre {

    // Constructeur : initialise une chambre avec ses caractéristiques
    // La disponibilité est définie à true par défaut (chambre libre)
    public Chambre(String typeChambre, int numChambre, int numEtage, float prixChambre) {
        this.typeChambre = typeChambre;
        this.numChambre = numChambre;
        this.numEtage = numEtage;
        this.prixChambre = prixChambre;
        this.disponibilite = true;
    }

    // Type de la chambre (ex : simple, double, suite...)
    private String typeChambre;

    // Numéro de la chambre
    private int numChambre;

    // Numéro de l'étage où se trouve la chambre
    private int numEtage;

    // Prix de la chambre par nuit
    private float prixChambre;

    // Disponibilité de la chambre (true = disponible, false = occupée)
    protected boolean disponibilite;

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

    // Retourne true si la chambre est disponible
    public boolean isDisponibilite() {
        return disponibilite;
    }

    // Bascule la disponibilité de la chambre (libre <-> occupée)
    public void setDisponibilite() {
        this.disponibilite = !disponibilite;
    }
}
