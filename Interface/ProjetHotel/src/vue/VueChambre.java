package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class VueChambre extends JFrame {
	private static final ActionListener ActionListener = null;

    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    JButton buttonMenage = new JButton("Menage");


    public VueChambre(Hotel h1) {
    	
        setTitle("Choisir une possibilité de chambre");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);
        panelBoutons.add(buttonMenage);
        buttonAjouter.addActionListener(e -> {;
            new VueAjoutChambre(h1);
        });
        buttonConsulter.addActionListener(e -> {
            new VueListeChambres(h1);
        });
        buttonMenage.addActionListener(e -> {
            new VueListeMenageJour(h1);
        });
        buttonSupprimer.addActionListener(e -> {
            new VueSupprimerChambre(h1);
        });
        add(panelBoutons);
        setVisible(true);
        java.awt.event.ActionListener ct = null;
        
        
    }
    
    
    
 
    public static void main(String[] args) {
        Hotel h = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChambre(h);
    }
    
 
}

