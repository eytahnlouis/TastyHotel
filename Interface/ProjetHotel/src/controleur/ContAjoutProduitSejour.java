package controleur;

import model.*;
import vue.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContAjoutProduitSejour implements ActionListener {
    private VueAjoutProduitSejour vue;
    private Sejour sejour;

    public ContAjoutProduitSejour(VueAjoutProduitSejour vue, Sejour s) {
        this.vue = vue;
        this.sejour = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(vue.nomProduit.getText());
        Produits a = sejour.getHotel().getProduitsById(id);
        if (a != null) {
            sejour.addProduits(a);
        }
    }
}

