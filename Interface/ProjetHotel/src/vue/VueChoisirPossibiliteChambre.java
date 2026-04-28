package vue;
import model.*;
import javax.swing.*;
import java.awt.*;

public class VueChoisirPossibiliteChambre extends JFrame {

    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    JButton buttonMenage = new JButton("Ménage");

    public VueChoisirPossibiliteChambre(Hotel h1) {
        JFrame frame = new JFrame();
        frame.setTitle("Choisir une possibilité de chambre");
        frame.setSize(500,500);
        frame.setLayout(null);
        setTitle("Choisir une possibilité de chambre");
        setSize(500,500);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);
        panelBoutons.add(buttonMenage);
        setVisible(true);

        // Ajouter les boutons au frame
        frame.add(buttonAjouter);
        frame.add(buttonSupprimer);
        frame.add(buttonConsulter);
        frame.add(buttonMenage);
        frame.setVisible(true);
    }
}
