package vue;
import javax.swing.*;
import model.*;
import controleur.*;
import java.awt.*;

public class VueHotel extends JFrame {
    JButton buttonChambre = new JButton("Chambre");
    JButton buttonActivites = new JButton("Activites");
    JButton buttonProduits = new JButton("Produits");
    JButton buttonStats = new JButton("Statistiques");

    public VueHotel(Hotel h) {
        setTitle("Choisir une possibilité pour l'hotel");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonChambre);
        panelBoutons.add(buttonActivites);
        panelBoutons.add(buttonProduits); 
        panelBoutons.add(buttonStats);

        add(panelBoutons);
        setVisible(true);
        buttonChambre.addActionListener(e -> new VueChoisirPossibiliteChambre(h));
        buttonProduits.addActionListener(e -> new VueChoisirProduitHotel(h));
        buttonActivites.addActionListener(e -> new VueChoisirActivitesHotel(h));
        buttonStats.addActionListener(e -> new VueHotelStatistiques(h));
         
    }


    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueHotel(h1);
    }
}



