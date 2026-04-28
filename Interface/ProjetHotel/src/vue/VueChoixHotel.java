package vue;
import javax.swing.*;
import model.*;

import java.awt.*;

public class VueChoixHotel extends JFrame {
    JButton btnChambre = new JButton("Chambre");
    JButton buttonActivites = new JButton("Activités");
    JButton btnProduits = new JButton("Produits");
    JButton btnStats = new JButton("Statistiques");

    public VueChoixHotel(Hotel h) {
        setTitle("Choisir une possibilité de réservation");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(btnChambre);
        panelBoutons.add(buttonActivites);
        panelBoutons.add(btnProduits);
        panelBoutons.add(btnStats);

        add(panelBoutons);
        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoixHotel(h1);
    }
}
