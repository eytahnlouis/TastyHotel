package vue;
import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class VueChoisirPossibiliteChambre extends JFrame {

    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    JButton buttonMenage = new JButton("Ménage");

    public VueChoisirPossibiliteChambre(Hotel h1) {
        setTitle("Choisir une possibilité de chambre");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);
        panelBoutons.add(buttonMenage);

        add(panelBoutons);
        setVisible(true);
        buttonAjouter.addActionListener(new ContAjouterChambre(h1, this));
        buttonSupprimer.addActionListener(new ContSupprimerChambre(h1, this));
        //buttonConsulter.addActionListener(new ContConsulterChambre(h1, this));
        buttonMenage.addActionListener(new ContMenageChambre(h1, this));
    
    }

    public static void main(String[] args) {
        Hotel h = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirPossibiliteChambre(h);
    }
}

