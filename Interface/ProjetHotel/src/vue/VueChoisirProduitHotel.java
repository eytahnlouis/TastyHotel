package vue;

import javax.swing.*;

import model.*;

import java.awt.*;
import java.time.LocalDate;

public class VueChoisirProduitHotel extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirProduitHotel(Hotel p) {
        setTitle("Choisir une possibilité de réservation");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        buttonConsulter.addActionListener(e -> {
            new VueListeProduits(p);
        });
        buttonAjouter.addActionListener(e -> {
            new VueAjoutProduit(p);
        });

        buttonSupprimer.addActionListener(e -> {
            new VueSupprimerProduit(p);
        });
        add(panelBoutons);
        setVisible(true);


    }

}