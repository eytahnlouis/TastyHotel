package vue;

import javax.swing.*;

import model.*;

import java.awt.*;
import java.time.LocalDate;

class VueChoisirActivites extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirActivites(Sejour s) {
        setTitle("Choisir une possibilité de réservation");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        buttonConsulter.addActionListener(e -> {
            new VueListeActivitesSejour(s);
        });
        buttonAjouter.addActionListener(e -> {
            new VueAjoutActivitesSejour(s);
        });
        buttonSupprimer.addActionListener(e -> {
            new VueSupprimerActivites(s);
        });
        add(panelBoutons);
        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        Activites a = new Activites("Cheval", (float) 4.5, h1);
        Client c = new Client("John", "Doe", h1);
        Chambre ch = new Chambre("Simple", 2, 3,(float)55.45, h1);
        Reservation r = new Reservation(c, LocalDate.now(), LocalDate.now().plusDays(3), ch);
        Sejour s = new Sejour(r);
        new VueChoisirActivites(s);
    }
}