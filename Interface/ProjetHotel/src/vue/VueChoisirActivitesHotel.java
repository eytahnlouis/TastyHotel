package vue;

import javax.swing.*;
import controleur.*;
import model.*;
import java.awt.*;

public class VueChoisirActivitesHotel extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirActivitesHotel(Hotel h) {
        setTitle("Choisir Activités Hotel");
        setSize(500,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        add(panelBoutons);
        setVisible(true);
        buttonAjouter.addActionListener(new ContAjoutActivitesHotel(h));
        buttonSupprimer.addActionListener(e -> new VueSupprimerActivitesHotel(h) );
        buttonConsulter.add(new VueListeActivites(h));
        
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirActivitesHotel(h1);
    }
}
