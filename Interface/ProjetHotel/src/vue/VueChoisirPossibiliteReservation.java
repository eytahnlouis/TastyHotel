package vue;

import javax.swing.*;

import model.*;

import java.awt.*;

class VueChoisirPossibiliteReservation extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirPossibiliteReservation(Hotel h1) {
        setTitle("Choisir une possibilité de réservation");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);
            buttonAjouter.addActionListener(e -> {
                new VueAjoutReservation(h1);
            });
        buttonConsulter.addActionListener(e -> {
            new VueListeReservations(h1);
        });
        add(panelBoutons);
        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirPossibiliteReservation(h1);
    }
}