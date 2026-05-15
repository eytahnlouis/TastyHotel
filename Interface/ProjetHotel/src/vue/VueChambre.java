package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class VueChambre extends JFrame {
	private static final ActionListener ActionListener = null;

    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    JButton buttonMenage = new JButton("M�nage");


    public VueChambre(Hotel h1) {
    	
        setTitle("Choisir une possibilit� de chambre");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);
        panelBoutons.add(buttonMenage);

        add(panelBoutons);
        setVisible(true);
        //ContValiderAjoutChambre ct = new ContValiderAjoutChambre(valNumChambre, h1);
        //buttonAjouter.addActionListener(ct);
    }
    
 
    public static void main(String[] args) {
        Hotel h = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChambre(h);
    }
    
 
}

