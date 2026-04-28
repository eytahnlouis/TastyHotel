package model;
import java.time.LocalDate;
import static java.util.Calendar.*;

public class Main {


    public static void main(String[] args) {


        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        Chambre c1 = new Chambre("Crousty", 1, 1, (float) 44.99, h1);
        Chambre c2 = new Chambre("Tacos", 2, 1, (float) 64.99, h1);
        Chambre c3 = new Chambre("Nuri", 3, 2, (float) 84.99, h1);
        Chambre c4 = new Chambre("Love room", 4, 1, (float) 104.99, h1);
        Activites a1 = new Activites("Visite de la ville", (float) 19.99, h1);
        Produits p1 = new Produits(1, "Petit-déjeuner", (float) 9.99, 1, h1);
        Client cl1 = new Client("Mohamed", "Omar", h1);
        Client cl2 = new Client("Laurent", "Hamza", h1);
        Reservation r1 = new Reservation(cl1, LocalDate.of(2026, APRIL, 15), LocalDate.of(2026, APRIL, 18), c1);
        Reservation r2 = new Reservation(cl2, LocalDate.of(2026, APRIL, 16), LocalDate.of(2026, APRIL, 19), c2);
        Sejour s1 = new Sejour(r1);
        s1.addActivite(a1);
        s1.addProduits(p1);




        c1.afficherChambre();
        System.out.println("------------") ;
        h1.afficherHotel();
        System.out.println("------------") ;
        a1.afficherInfos();
        System.out.println("------------") ;
        cl1.infosClient();
        System.out.println("------------") ;

        r1.infosChambre();
        System.out.println("------------") ;

        s1.infosSejour();
        System.out.println("------------") ;

        p1.infosProduits();
        System.out.println("------------") ;

        System.out.println("Chambre dispo :" + h1.getChambresDisponibles(LocalDate.of(2026, APRIL, 15), LocalDate.of(2026, APRIL, 18)));
        System.out.println("------------") ;
        System.out.println( "Supprimer réservations : " + h1.supprimerReservation(r2));
        System.out.println("------------") ;
        System.out.println("Chambre dispo :" + h1.getChambresDisponibles(LocalDate.of(2026, APRIL, 15), LocalDate.of(2026, APRIL, 18)));
        System.out.println("------------") ;
        System.out.println("Liste Clients présents ce jour :" + h1.getClientOfDay(LocalDate.of(2026, APRIL, 16)));

    }
}