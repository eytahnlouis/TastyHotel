package controleur;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import java.awt.event.*;
import javax.swing.*;

public class ContValiderAjoutChambre implements ActionListener {
    JTextField numChambre;
    Hotel hotel; 

    public ContValiderAjoutChambre(JTextField n, Hotel h) {
        this.numChambre = n;
        this.hotel = h;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numero = numChambre.getText();
        
        // Création de l'objet Chambre
        Chambre nouvelleChambre = new Chambre(numero); //ajouter controleur manquant
        
        // Liaison : on ajoute la chambre à l'hôtel [cite: 52]
        this.hotel.ajoutChambre(nouvelleChambre);
        
        System.out.println("Chambre " + numero + " ajoutée à l'hôtel " + hotel.nom);
    }
}