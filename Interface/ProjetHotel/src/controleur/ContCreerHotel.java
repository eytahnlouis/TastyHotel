package controleur;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import vue.*;

public class ContCreerHotel implements ActionListener{
	JTextField valNom;
	JTextfield valAdresse;
	JFrame VuePrincipale;
	public CreerHotelControleur(JTextField vNom, JTextField vAdresse, JFrame vp) {
        valNom        = vNom;
        valAdresse    = vAdresse;
        VuePrincipale = vp;
    
	public void actionPerformed(ActionEvent e) {
        String nom     = valNom.getText().trim();
        String adresse = valAdresse.getText().trim();
 
        if (nom.isEmpty() || adresse.isEmpty()) {
            JOptionPane.showMessageDialog(VuePrincipale,
                "Veuillez remplir le nom et l'adresse.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        // Créer le modèle
        Hotel hotel = new Hotel(nom, adresse);
 
        // Fermer la fenêtre de saisie
        VuePrincipale.dispose();
 
        // Ouvrir la fenêtre de navigation
        new VueNavigation(hotel);
	}

}
