package vue;

import javax.swing.*;

import model.*;

import java.awt.*;
import java.time.LocalDate;

class VueChoisirProduit extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirProduit(Sejour p) {
        setTitle("Choisir une possibilité de réservation");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        buttonConsulter.addActionListener(e -> {
            new VueListeProduitsSejour(p);
        });
        buttonAjouter.addActionListener(e -> {
            new VueAjoutProduitSejour(p);

        });
        add(panelBoutons);
        setVisible(true);


    }

}