package controleur;
import model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vue.VueChambre;

public class ContOuvrirAjoutChambre implements ActionListener {
	private Hotel hotel;
	public ContOuvrirAjoutChambre(Hotel hotel) {
		this.hotel = hotel;
	}
	
    public void actionPerformed(ActionEvent e) {
        VueChambre vsc = new VueChambre(hotel);
        vsc.setVisible(true); 
        vsc.pack();
    }

}
