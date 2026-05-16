package controleur;

import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ContSupprimerProduit implements ActionListener {

    private Hotel hotel;

    public ContSupprimerProduit(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder("Produits :\n");
        int i = 0;
        for (Produits p : hotel.getListeProduits())
            sb.append(i++).append(" - ").append(p.getNomProduit()).append(" (").append(p.getPrixProduit()).append(" €)\n");

        String indexStr = JOptionPane.showInputDialog(sb + "\nNuméro à supprimer :");
        hotel.getListeProduits().remove(Integer.parseInt(indexStr.trim()));
        JOptionPane.showMessageDialog(null, "Produit supprimé !");
    }
}
