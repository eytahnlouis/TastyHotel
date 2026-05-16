package model;
import model.*;
import java.time.LocalDate;
import java.util.*;

import static java.util.Arrays.*;

/**
 * Classe repr�sentant un h�tel.
 * Un h�tel poss�de un nom, une adresse, et g�re des chambres,
 * des clients, des produits et des activit�s.
 */
public class Hotel {

    // Constructeur : initialise un h�tel avec son nom, adresse et liste de produits
    public Hotel(String nomHotel, String adresse) {
        numHotel++;
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.listeActivites = new Vector<>();   // liste vide d'activit�s
        this.listChambre = new Vector<>();       // liste vide de chambres
        this.listeClient = new Vector<>();         // liste vide de clients
        this.listeProduits = new Vector<>();      // liste vide de produits
    }

    // Identifiant unique de l'h�tel (auto-incr�ment�)
    private static int numHotel;

    // Nom de l'h�tel
    private final String nomHotel;

    // Adresse de l'h�tel
    private final String adresse;

    // Liste des chambres de l'h�tel
    private final Vector<Produits> listeProduits;

    private final Vector<Activites> listeActivites;


    private final Vector<Client> listeClient;


    private final Vector<Chambre> listChambre;

    // Retourne le num�ro de l'h�tel
    public int getNumHotel() {
        return numHotel;
    }

    public void ajoutChambre(Chambre chambre) {
        if (listChambre.contains(chambre)) {
            return;
        }
        listChambre.add(chambre);
    }
    // Retourne la liste compl�te des chambres
    public Vector <Chambre> getLChambres() {
        return listChambre;
    }

    public Vector<Chambre> getChambreByType(String tChambre) {
        Vector<Chambre> res = new Vector<>();
        for (Chambre chambre : listChambre) {
            if (chambre.getTypeChambre().equals(tChambre)) {
                res.add(chambre);
            }
        }
        return res;
    }
    public Vector<Chambre> getChambreByEtage(int numEtage) {
        Vector<Chambre> res = new Vector<>();
        for (Chambre chambre : listChambre) {
            if (chambre.getNumEtage() == numEtage) {
                res.add(chambre);
            }
        }
        return res;
    }

    public Vector<Produits> getListeProduits() {
        return new Vector<>(this.listeProduits);
    }

    public Vector<Activites> getListeActivites() {
        return new Vector<>(this.listeActivites);
    }

    public Vector<Chambre> getListChambre() {
        return new Vector<>(this.listChambre);
    }

    public Vector<Client> getListClient() {
        return new Vector<>(this.listeClient);
    }

    public Vector<Client> getClientOfDay(LocalDate date) {
        Vector<Client> res = new Vector<>();
        for (Client c : listeClient) {
            if (c.isPresentInHotelToday(date)) {
                res.add(c);
            }
        }
        return res;
    }

    public boolean isRoomAvailable(LocalDate debutDemande, LocalDate finDemande, Chambre chambre) {
        boolean disponible = true;
        for (Reservation res : chambre.getListReservation()) {
            boolean chevauchement = debutDemande.isBefore(res.getDateFin())
                    && finDemande.isAfter(res.getDateDebut());
            if (chevauchement) {
                disponible = false;
                break;
            }
        }
        return disponible;
    }


    public Vector<Chambre> getChambresDisponibles(LocalDate debutDemande, LocalDate finDemande) {
        Vector<Chambre> chambresDisponibles = new Vector<>();

        for (Chambre chambre : listChambre) {
            boolean disponible = true;

            for (Reservation res : chambre.getListReservation()) {
                boolean chevauchement = debutDemande.isBefore(res.getDateFin())
                        && finDemande.isAfter(res.getDateDebut());
                if (chevauchement) {
                    disponible = false;
                    break;
                }
            }

            if (disponible) {
                chambresDisponibles.add(chambre);
            }
        }

        return chambresDisponibles;
    }

    public Vector<Chambre> chambreANettoyer() {
        Vector<Chambre> chambresNettoyees = new Vector<>();
        for (Chambre chambre : listChambre) {
            if (chambre.isLastDay()) chambresNettoyees.add(chambre);
        }
        return chambresNettoyees;
    }

    public boolean supprimerReservation(Reservation reservation) {
        LocalDate aj = LocalDate.now();
        if (reservation.getSejour() != null
                && aj.isAfter(reservation.getDateDebut())
                && aj.isBefore(reservation.getSejour().getDateFinReel())) {
            //System.out.println("Impossible : le client est actuellement en s�jour.");
            return false;
        }
        // Retirer c�t� client
        reservation.getClient().removeReservation(reservation);

        // Retirer c�t� chambre
        reservation.getChambre().getListReservation().remove(reservation);

        // Dissocier le s�jour s'il existe
        if (reservation.getSejour() != null) {
            reservation.getSejour().setReservation(null);
            reservation.setSejour(null);
        }

        return true;
    }

    public Vector<Activites> getListActivitesByPrice(float prix) {
        Vector<Activites> activitesByPrice = new Vector<>();
        for (Activites activite : listeActivites) {
            if (activite.getPrixActivite() <= prix) {
                activitesByPrice.add(activite);
            }
        }
        return activitesByPrice;
    }
    public Vector<Activites> getListActivitesByNom(String nomActivite) {
        Vector<Activites> activitesByNom = new Vector<>();
        for (Activites activite : listeActivites) {
            if (activite.getNomActivite().equals(nomActivite)) {
                activitesByNom.add(activite);
            }
        }
        return activitesByNom;
    }

    public Vector<Produits> getProduitsByNom(String nomProduit) {
        Vector<Produits> produitsByNom = new Vector<>();
        for (Produits produit : listeProduits) {
            if (produit.getNomProduit().equals(nomProduit)) {
                produitsByNom.add(produit);
            }
        }
        return produitsByNom;
    }
    public Vector <Produits> getProduitsByPrice(float prix) {
        Vector<Produits> produitsByPrice = new Vector<>();
        for (Produits produit : listeProduits) {
            if (produit.getPrixProduit() <= prix) {
                produitsByPrice.add(produit);
            }
        }
        return produitsByPrice;
    }

    public void ajouterProduit(Produits p) {
        if (!listeProduits.contains(p)) {
            listeProduits.add(p);
        }
    }
    public void ajouterActivite(Activites a) {
        if (!listeActivites.contains(a)) {
            listeActivites.add(a);
        }
    }
    public void ajouterClient(Client c) {
        listeClient.add(c);
    }
    public void removeClient(Client c) {
        listeClient.remove(c);
    }

    //Statistiques
    public Client[] biggestSpender() {
        int count = 0;
        for (Client client : listeClient) {
            if (client.getTotalSpent() > 0) count++;
        }

        Client[] clients = new Client[count]; // taille exacte, z�ro null
        int i = 0;
        for (Client client : listeClient) {
            if (client.getTotalSpent() > 0) {
                clients[i] = client;
                i++;
            }
        }

        sort(clients, Comparator.comparing(Client::getTotalSpent).reversed());
        return clients;
    }

    public Chambre mostBookedRoom() {
        Chambre chambre = null;
        int maxReservations = 0;
        for (Chambre c : listChambre) {
            int reservations = c.getListReservation().size();
            if (reservations > maxReservations) {
                maxReservations = reservations;
                chambre = c;
            }
        }
        return chambre;
    }


    public void afficherHotel(){
        System.out.println("------------------------------------");
        System.out.println("numHotel : " + getNumHotel());
        System.out.println("Nom de l'h�tel : " + getNomHotel());
        System.out.println("Adresse de l'h�tel : " + getAdresse());
        System.out.println("Liste des produits : " + listeProduits.size());
        System.out.println("Liste des activit�s : " + listeActivites.size());
        System.out.println("Liste des chambres : " + listChambre.size());
        System.out.println("------------------------------------");
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public Activites getActivitesById(int id) {
        for (Activites a : listeActivites) {
            if (a.getNumActivite() == id) {
                return a;
            }
        }
        return null;
    }

    public Produits getProduitsById(int id) {
        for (Produits prod : listeProduits) {
            if (prod.getNumProduit() == id) {
               return prod;
            }
        }
        return null;
    }

    public Reservation getReservationById(int numSejour) {
        for (Chambre c : listChambre) {
            for (Reservation res : c.getListReservation()) {
                if (res.getNumReservation() == numSejour) {
                    return res;
                }
            }
        }
        return null;
    }

    public void removeProduits(Produits produitToRemove) {
        listeProduits.remove(produitToRemove);
    }

    public void supprimerActivite(Activites a) {
        listeActivites.remove(a);

    }

     public void supprimerChambre(Chambre c) {
        listChambre.remove(c);
    }

     public void supprimerClient(Client c) {
        listeClient.remove(c);
    }
}


