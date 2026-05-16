package model;
import model.*;
import java.io.*;
import java.util.*;

/**
 * Classe repr�sentant un produit propos� par l'h�tel.
 * Un produit est d�fini par un num�ro, un nom et un prix.
 */
public class Produits {


    // Identifiant unique du produit
    private final int numProduit;

    private String nomProduit;


    private float prixProduit;


    private int quantite;

    private Vector<Hotel> listHotel;

    // Constructeur : initialise un produit avec son num�ro, son nom et son prix
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
                h.ajouterProduit(this);
            }
        }
    }
    // Retourne le num�ro du produit

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
            throw new IllegalArgumentException("Quantit� ne peut pas �tre n�gative");
        this.quantite+=q;
    }

    public boolean isAvailable() {
        return quantite > 0;
    }

    public void infosProduits() {
        System.out.println("Num�ro du produit : " + numProduit);
        System.out.println("Nom du produit : " + nomProduit);
        System.out.println("Prix du produit : " + prixProduit);
        System.out.println("Quantit� : " + quantite);
    }


    public int getQuantite() {
        return quantite;
    }
}
