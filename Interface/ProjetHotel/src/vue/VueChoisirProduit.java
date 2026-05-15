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

        add(panelBoutons);
        setVisible(true);


    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("TastyHotel 4*", "12 rue de la paix");
        Client c = new Client("Paul", "Doe", h1);
        Chambre ch = new Chambre("Simple", 2, 3,(float)55.45, h1);
        Reservation r = new Reservation(c, LocalDate.now(), LocalDate.now().plusDays(3), ch);
        Sejour s = new Sejour(r);
        new VueChoisirProduit(s);
    }
}