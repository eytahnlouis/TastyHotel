package controleur;
import vue.*;
 
import model.Chambre;
import model.Hotel;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class ContMenageChambre implements ActionListener {
 
    private Hotel hotel;
    private VueChoisirPossibiliteChambre vue;
 
    public ContMenageChambre(Hotel hotel, VueChoisirPossibiliteChambre vue) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupère les chambres à nettoyer via hotel.ChambreANettoyer()
        // (chambres dont le séjour se termine aujourd'hui)
        java.util.Vector<Chambre> chambresANettoyer = hotel.chambreANettoyer();
 
        if (chambresANettoyer.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Aucune chambre à nettoyer aujourd'hui.", "Ménage", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("Chambres à nettoyer aujourd'hui :\n\n");
        for (Chambre c : chambresANettoyer) {
            sb.append("  - Chambre n°").append(c.getNumChambre())
              .append(" (").append(c.getTypeChambre()).append(")")
              .append(" - Étage ").append(c.getNumEtage()).append("\n");
        }
 
        JOptionPane.showMessageDialog(vue, sb.toString(), "Liste ménage", JOptionPane.INFORMATION_MESSAGE);
    }
}
