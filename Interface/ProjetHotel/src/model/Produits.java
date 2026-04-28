package model;
import java.io.*;
import java.util.*;

/**
 * Classe représentant un produit proposé par l'hôtel.
 * Un produit est défini par un numéro, un nom et un prix.
 */
public class Produits {


    // Identifiant unique du produit
    private final int numProduit;

    public String nomProduit;


    public float prixProduit;


    private int quantite;

    private Vector<Hotel> listHotel;

    // Constructeur : initialise un produit avec son numéro, son nom et son prix
    public Produits(int numProduit, String nomProduit, float prixProduit, int quantite, Hotel hotel) {
        this.numProduit = numProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.quantite = quantite;
        this.listHotel = new Vector<Hotel>();
        this.listHotel.add(hotel);
        ajouterAHotel();
    }
    public void addHotelToProduit(Hotel h)
    {
        listHotel.add(h);
        ajouterAHotel();
    }

    public void ajouterAHotel()
    {
        for (Hotel h : listHotel)
        {
            if (!h.getListeProduits().contains(this)) {
                h.getListeProduits().add(this);
            }
        }
    }
    // Retourne le numéro du produit

    public int getNumProduit() {
        return this.numProduit;
    }

    // Retourne le nom du produit
    public String getNomProduit() {
        return this.nomProduit;
    }

    // Retourne le prix d'un produit unique
    public float getPrixProduit() {
        return this.prixProduit;
    }

    // Calcule et retourne le prix total d'un tableau de produits
    public float getPrixProduit(Vector<Produits> p) {
        float total = 0;
        for (Produits produit : p) {
            total += produit.getPrixProduit();
        }
        return total;
    }

    public void addProduitToSejour(Sejour s)
    {
        s.addProduits(this);
    }

    public boolean isAvailableInHotel(Hotel h) {
        return listHotel.contains(h);
    }

    public void addQuantite(int q)
    {
        if(q<0)
            throw new IllegalArgumentException("Quantité ne peut pas être négative");
        this.quantite+=q;
    }

    public boolean isAvailable() {
        return quantite > 0;
    }

    public void infosProduits() {
        System.out.println("Numéro du produit : " + numProduit);
        System.out.println("Nom du produit : " + nomProduit);
        System.out.println("Prix du produit : " + prixProduit);
        System.out.println("Quantité : " + quantite);
    }
}
