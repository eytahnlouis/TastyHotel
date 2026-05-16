package controleur;

import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ContAjouterProduit implements ActionListener {

    private Hotel hotel;

    public ContAjouterProduit(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom  = JOptionPane.showInputDialog("Nom du produit :");
        String prix = JOptionPane.showInputDialog("Prix :");
        String qte  = JOptionPane.showInputDialog("Quantité :");
        try {
            int num = hotel.getListeProduits().size() + 1;
            new Produits(num, nom.trim(), Float.parseFloat(prix.trim()), Integer.parseInt(qte.trim()), hotel);
            JOptionPane.showMessageDialog(null, "Produit ajouté !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Valeur invalide.");
        }
    }
}
