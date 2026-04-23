
import java.time.LocalDate;
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
        this.listeActivites = new Vector<>();   // liste vide d'activités
        this.listChambre = new Vector<>();       // liste vide de chambres
        this.listeClient = new Vector<>();         // liste vide de clients
        this.listeProduits = new Vector<>();      // liste vide de produits
   }

    // Identifiant unique de l'hôtel (auto-incrémenté)
    private static int numHotel;

    // Nom de l'hôtel
    private final String nomHotel;

    // Adresse de l'hôtel
    private final String adresse;

    // Liste des chambres de l'hôtel
    private final Vector<Produits> listeProduits;

    private final Vector<Activites> listeActivites;


    private final Vector<Client> listeClient;


    private final Vector<Chambre> listChambre;

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

    public Vector<Client> getListClient() {
        return listeClient;
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

    public Vector<Chambre> ChambreANettoyer() {
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
            //System.out.println("Impossible : le client est actuellement en séjour.");
            return false;
        }
        // Retirer côté client
        reservation.getClient().listReservation.remove(reservation);

        // Retirer côté chambre
        reservation.getChambre().getListReservation().remove(reservation);

        // Dissocier le séjour s'il existe
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

    //Statistiques
    public Client[] biggestSpender() {
        Client[] clients = new Client[listeClient.size()];
        int i = 0;
        for (Client client : listeClient) {
            if (client.getTotalSpent() > 0) {
                clients[i] = client;
                i++; //augmente
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
        System.out.println("numHotel : " + getNumHotel());
        System.out.println("Nom de l'hôtel : " + getNomHotel());
        System.out.println("Adresse de l'hôtel : " + getAdresse());
        System.out.println("Liste des produits : " + listeProduits.size());
        System.out.println("Liste des activités : " + listeActivites.size());
        System.out.println("Liste des chambres : " + listChambre.size());
        System.out.println("------------------------------------");
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNomHotel() {
        return nomHotel;
    }


}

