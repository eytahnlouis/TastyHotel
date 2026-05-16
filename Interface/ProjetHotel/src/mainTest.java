
import model.*;
import vue.VuePrincipale;

import java.time.LocalDate;


public class mainTest{
    public static void main(String[] args) {
// === HOTEL ===
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix, Paris");

        // === CHAMBRES ===
        Chambre ch1 = new Chambre("Simple",  101, 1, 59.99f,  h1);
        Chambre ch2 = new Chambre("Double",  102, 1, 89.99f,  h1);
        Chambre ch3 = new Chambre("Suite",   201, 2, 149.99f, h1);
        Chambre ch4 = new Chambre("Simple",  103, 1, 59.99f,  h1);
        Chambre ch5 = new Chambre("Double",  202, 2, 89.99f,  h1);

        // === CLIENTS ===
        Client c1 = new Client("Dupont",   "Jean",    h1);
        Client c2 = new Client("Martin",   "Sophie",  h1);
        Client c3 = new Client("Lemaire",  "Pierre",  h1);
        Client c4 = new Client("Bernard",  "Alice",   h1);

        // === PRODUITS ===
        Produits p1 = new Produits(1, "Eau minérale",   2.50f,  50, h1);
        Produits p2 = new Produits(2, "Bouteille vin",  18.00f, 20, h1);
        Produits p3 = new Produits(3, "Plateau fromage",12.00f, 15, h1);
        Produits p4 = new Produits(4, "Room service",   25.00f, 30, h1);

        // === ACTIVITES ===
        Activites a1 = new Activites("Spa",           45.00f, h1);
        Activites a2 = new Activites("Balade à cheval",35.00f, h1);
        Activites a3 = new Activites("Tennis",         20.00f, h1);
        Activites a4 = new Activites("Piscine",        15.00f, h1);

        // === RESERVATIONS ===
        Reservation r1 = new Reservation(c1, LocalDate.now().minusDays(3), LocalDate.now().plusDays(2),  ch1);
        Reservation r2 = new Reservation(c2, LocalDate.now().minusDays(1), LocalDate.now().plusDays(4),  ch3);
        Reservation r3 = new Reservation(c3, LocalDate.now().plusDays(5),  LocalDate.now().plusDays(8),  ch2);
        Reservation r4 = new Reservation(c4, LocalDate.now().minusDays(10),LocalDate.now().minusDays(7), ch4);
        Reservation r5 = new Reservation(c1, LocalDate.now().plusDays(10), LocalDate.now().plusDays(14), ch2);

        // === SEJOURS (réservations en cours ou passées) ===
        Sejour s1 = new Sejour(r1); // Jean en cours
        s1.addProduits(p1);
        s1.addProduits(p2);
        s1.addActivite(a1);
        s1.addActivite(a3);

        Sejour s2 = new Sejour(r2); // Sophie en cours
        s2.addProduits(p3);
        s2.addProduits(p4);
        s2.addActivite(a2);

        Sejour s3 = new Sejour(r4, LocalDate.now().minusDays(7)); // Alice — séjour passé terminé
        s3.addProduits(p1);
        s3.addActivite(a4);

        // === LANCEMENT ===
        new VuePrincipale(h1);
        System.out.println("numero de la resa r1" + " " + r1.getNumReservation());
    }
}