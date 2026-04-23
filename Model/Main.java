import java.time.LocalDate;
import java.util.*;

import static java.util.Calendar.*;

public class Main {


    public static void main(String[] args) {


        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        Chambre c1 = new Chambre("Crousty", 1, 1, (float) 44.99, h1);
        Activites a1 = new Activites("Visite de la ville", (float) 19.99, h1);
        Produits p1 = new Produits(1, "Petit-déjeuner", (float) 9.99, 1, h1);
        Client cl1 = new Client("Mohamed", "Omar", h1);
        Reservation r1 = new Reservation(cl1, LocalDate.of(2026, APRIL, 15), LocalDate.of(2026, APRIL, 18), c1);
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

    }
}