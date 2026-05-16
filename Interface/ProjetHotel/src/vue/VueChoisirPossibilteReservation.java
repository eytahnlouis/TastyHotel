package vue;

import javax.swing.*;
import controleur.*;

import model.*;

import java.awt.*;

 public class VueChoisirPossibiliteReservation extends JFrame {
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

        add(panelBoutons);
        setVisible(true);
        buttonAjouter.addActionListener(new ContAjouterReservation(h1));
        buttonSupprimer.addActionListener(new ContSupprimerReservation(h1));
        //buttonConsulter.addActionListener(new ContConsulterReservation(h1));
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirPossibiliteReservation(h1);
    }
}