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
        setTitle("Choisir une possibilite de reservation");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonChambre);
        panelBoutons.add(buttonActivites);
        panelBoutons.add(buttonProduits); 
        panelBoutons.add(buttonStats);

        add(panelBoutons);
        setVisible(true);
        Hotel hotel = null ;
        buttonChambre.addActionListener(new ContOuvrirAjoutChambre(hotel));
        buttonProduits.addActionListener(new ContOuvrirProduits(hotel));
        buttonActivites.addActionListener(new ContOuvrirActivites(hotel));
         
    }


    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueHotel(h1);
    }
}



