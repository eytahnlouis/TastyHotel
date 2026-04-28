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
        setSize(500,500);
        setVisible(true);

        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirPossibiliteReservation(h1);
    }
}