import java.util.*;

import static java.util.Calendar.*;

public class Main {
    String nomHotel= "Tasty Hotel 4*";
    String adresse= "12 rue de la paix";
    Hotel h = new Hotel(nomHotel, adresse);
    String typeC = "Crousty";
    int numChambre = 1;
    int numEtage = 1;
    float prixChambre = (float)44.99;
    Calendar cal = getInstance();
    Date dFin = new Date(cal.getTimeInMillis() + 3 * 24 * 60 * 60 * 1000); // date de fin dans 3 jours
    Chambre c = new Chambre(typeC, numChambre, numEtage, prixChambre, h);
    Activites a = new Activites("Visite de la ville", (float) 19.99, h);
    Produits p = new Produits(1, "Petit-déjeuner", (float) 9.99, 1, h);
    Client cl = new Client("Mohamed", "Omar", h);
    Reservation r = new Reservation(cl, new Date(), dFin, c);
    Sejour s = new Sejour(r, dFin);

    public static void main(String[] args) {
        Main main = new Main();
        main.c.ajouterAHotel();
        main.c.afficherChambre();
        main.h.afficherHotel();
        main.a.afficherInfos();
        main.cl.infosClient();
        main.r.infosChambre();
        main.s.infosSejour();
        main.p.infosProduits();

    }
}