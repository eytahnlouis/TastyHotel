package controleur;
import  java.awt.event.*;
import vue.VueHotel;

public class ContOuvrirHotel implements ActionListener{
	public ContOuvrirHotel() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		VueHotel vh = new VueHotel(null);
		vh.setVisible(true);
		vh.pack();	
		
	}
	

}
