package controleur;
 
import model.Chambre;
import model.Hotel;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class ContSupprimerChambre implements ActionListener {
 
    private Hotel hotel;
    private VueChoisirPossibiliteChambre vue;
    
 
    public ContSupprimerChambre(Hotel hotel, VueChoisirPossibiliteChambre vue) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String numStr = JOptionPane.showInputDialog(vue, "Numéro de la chambre à supprimer :");
        if (numStr == null || numStr.trim().isEmpty()) return;
 
        try {
            int num = Integer.parseInt(numStr.trim());
 
            // Recherche de la chambre dans l'hôtel
            Chambre chambreASupprimer = null;
            for (Chambre c : hotel.getListChambre()) {
                if (c.getNumChambre() == num) {
                    chambreASupprimer = c;
                    break;
                }
            }
 
            if (chambreASupprimer == null) {
                JOptionPane.showMessageDialog(vue, "Chambre n°" + num + " introuvable.", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
 
            // Vérification : pas de réservation active
            if (!chambreASupprimer.getListReservation().isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Impossible : la chambre a des réservations.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
 
            hotel.getListChambre().remove(chambreASupprimer);
            JOptionPane.showMessageDialog(vue, "Chambre n°" + num + " supprimée avec succès !");
 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vue, "Numéro invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
