
import java.util.*;

import static java.util.Arrays.*;

/**
 * Classe représentant un hôtel.
 * Un hôtel possède un nom, une adresse, et gère des chambres,
 * des clients, des produits et des activités.
 */
public class Hotel {

    // Constructeur : initialise un hôtel avec son nom, adresse et liste de produits
    public Hotel(String nomHotel, String adresse) {
        numHotel++;
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.listeActivites = new Vector<Activites>();   // liste vide d'activités
        this.listChambre = new Vector<Chambre>();       // liste vide de chambres
        this.listeClient = new Vector<>();         // liste vide de clients
        this.listeProduits = new Vector<Produits>();      // liste vide de produits
   }

    // Identifiant unique de l'hôtel (auto-incrémenté)
    private static int numHotel;

    // Nom de l'hôtel
    public String nomHotel;

    // Adresse de l'hôtel
    public String adresse;

    // Liste des chambres de l'hôtel
    public Vector<Produits> listeProduits;

    public Vector<Activites> listeActivites;


    public Vector<Client> listeClient;


    public Vector<Chambre> listChambre;

    // Retourne le numéro de l'hôtel
    public int getNumHotel() {
        return numHotel;
    }

    public void ajoutChambre(Chambre chambre) {
        if (listChambre.contains(chambre)) {
            return;
        }
        listChambre.add(chambre);
    }
    // Retourne la liste complète des chambres
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
        return listeProduits;
    }

    public Vector<Activites> getListeActivites() {
        return listeActivites;
    }

    public Vector<Chambre> getListChambre() {
        return listChambre;
    }

    public boolean isRoomAvailable(Date debutDemande, Date finDemande, Chambre chambre) {
         boolean disponible = true;
            for (Reservation res : chambre.getListReservation()) {
                boolean chevauchement = debutDemande.before(res.dateFin)
                        && finDemande.after(res.dateDebut);
                if (chevauchement) {
                    disponible = false;
                    break;
                }
            }
        return disponible;
    }


    public Vector<Chambre> getChambresDisponibles(Date debutDemande, Date finDemande) {
        Vector<Chambre> chambresDisponibles = new Vector<>();

        for (Chambre chambre : listChambre) {
            boolean disponible = true;

            for (Reservation res : chambre.getListReservation()) {
                boolean chevauchement = debutDemande.before(res.dateFin)
                        && finDemande.after(res.dateDebut);
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

    public Vector<Chambre> ChambreANettoyer() {
        Vector<Chambre> chambresNettoyees = new Vector<>();
        for (Chambre chambre : listChambre) {
            if (chambre.isLastDay() && !chambre.getListReservation().isEmpty()) {
                chambresNettoyees.add(chambre);
            }
        }
        return chambresNettoyees;
    }

    public boolean supprimerReservation(Reservation reservation) {
        Date aj = new Date();
        if (reservation.sejour != null
                && aj.after(reservation.dateDebut)
                && aj.before(reservation.sejour.dateFinReel)) {
            //System.out.println("Impossible : le client est actuellement en séjour.");
            return false;
        }
        // Retirer côté client
        reservation.client.listReservation.remove(reservation);

        // Retirer côté chambre
        reservation.chambre.getListReservation().remove(reservation);

        // Dissocier le séjour s'il existe
        if (reservation.sejour != null) {
            reservation.sejour.reservation = null;
            reservation.sejour = null;
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

    //Statistiques
    public Client[] biggestSpender() {
        Client[] clients = new Client[listeClient.size()];
        int i = 0;
        for (Client client : listeClient) {
            if (client.getTotalSpent() > 0) {
                clients[i] = client;
                i++;
            }
            sort(clients, Comparator.comparing(Client::getTotalSpent).reversed());
        }
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
        System.out.println("numHotel : " + numHotel);
        System.out.println("Nom de l'hotel : " + nomHotel);
        System.out.println("Adresse de l'hotel : " + adresse);
        System.out.println("Liste des produits : " + listeProduits.size());
        System.out.println("Liste des activités : " + listeActivites.size());
        System.out.println("Liste des chambres : " + listChambre.size());
        System.out.println("------------------------------------");
    }


}

