package controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vue.VueChambre;

public class ContOuvrirAjoutChambre {
	public ContOuvrirAjoutChambre() {}
	
    public void actionPerformed(ActionEvent e) {
         
        VueChambre vsc = new VueChambre(null);
        vsc.setVisible(true); 
        vsc.pack();
    }

}
