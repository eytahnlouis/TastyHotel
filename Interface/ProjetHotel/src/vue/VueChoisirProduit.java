package vue;

import javax.swing.*;
import controleur.*;
import model.*;

import java.awt.*;

public class VueChoisirProduit extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirProduit(Hotel h) {
        setTitle("Choisir une possibilité pour produit");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        add(panelBoutons);
        setVisible(true);
        buttonAjouter.addActionListener(new ContAjouterProduit(h));
        buttonSupprimer.addActionListener(new ContSupprimerProduit(h));
        //buttonConsulter.addActionListener(new ContConsulterProduit(h));
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        Produits p = new Produits(1, "Coca", (float) 4.5, 100,h1);
        Hotel h = null;
        new VueChoisirProduit(h);
    }
}
