package controleur;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class ContSupprimerProduit implements ActionListener {
    private Hotel hotel;
    private VueSupprimerProduit vue;
    public ContSupprimerProduit(VueSupprimerProduit vue, Hotel hotel) {
        this.hotel = hotel;
        this.vue = new VueSupprimerProduit(hotel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int codeBarre = Integer.parseInt(vue.idProduit.getText());
        Produits produitToRemove = hotel.getProduitsById(codeBarre);
        if (produitToRemove != null) {
            hotel.removeProduits(produitToRemove);
            JOptionPane.showMessageDialog(vue, "Produit supprimé avec succès.");
        } else {
            JOptionPane.showMessageDialog(vue, "Produit non trouvé.");
        }
    }
}