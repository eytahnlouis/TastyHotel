package vue;
import model.*;
import javax.swing.*;
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

        buttonAjouter.setBounds(50, 100, 150, 50);
        buttonSupprimer.setBounds(200, 100, 150, 50);
        buttonConsulter.setBounds(350, 100, 150, 50);
        buttonMenage.setBounds(50, 200, 150, 50);
        setVisible(true);

        // Ajouter les boutons au frame
        frame.add(buttonAjouter);
        frame.add(buttonSupprimer);
        frame.add(buttonConsulter);
        frame.add(buttonMenage);
        frame.setVisible(true);
    }
}
