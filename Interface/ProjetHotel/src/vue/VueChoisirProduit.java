package vue;

import javax.swing.*;
import controleur.*;
import model.*;

import java.awt.*;

public class VueChoisirProduit extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirProduit(Sejour h) {
        setTitle("Choisir une possibilité pour produit durant le séjour");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        add(panelBoutons);
        setVisible(true);
        buttonAjouter.addActionListener(e -> new VueAjoutProduitSejour(h));
        buttonSupprimer.addActionListener(e -> new VueSupprimerProduitSejour(h));
        buttonConsulter.addActionListener(e -> new VueListeProduitsSejour(h));
    }

}
