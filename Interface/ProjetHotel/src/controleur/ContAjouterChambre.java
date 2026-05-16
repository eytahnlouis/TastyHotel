package controleur;
 
import model.Chambre;
import model.Hotel;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class ContAjouterChambre implements ActionListener {
 
    private Hotel hotel;
    private VueChoisirPossibiliteChambre vue;
 
    public ContAjouterChambre(Hotel hotel, VueChoisirPossibiliteChambre vue) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // Saisie des infos de la chambre via des boîtes de dialogue
        String type = JOptionPane.showInputDialog(vue, "Type de chambre (ex: Simple, Double, Suite) :");
        if (type == null || type.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Type invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        String numStr = JOptionPane.showInputDialog(vue, "Numéro de chambre :");
        String etageStr = JOptionPane.showInputDialog(vue, "Numéro d'étage :");
        String prixStr = JOptionPane.showInputDialog(vue, "Prix par nuit :");
 
        try {
            int num    = Integer.parseInt(numStr.trim());
            int etage  = Integer.parseInt(etageStr.trim());
            float prix = Float.parseFloat(prixStr.trim());
 
            // Chambre s'ajoute automatiquement à l'hôtel via son constructeur (hotel.ajoutChambre)
            new Chambre(type.trim(), num, etage, prix, hotel);
 
            JOptionPane.showMessageDialog(vue, "Chambre n°" + num + " ajoutée avec succès !");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vue, "Valeur invalide, veuillez entrer des nombres corrects.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 
