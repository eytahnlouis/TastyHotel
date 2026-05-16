package controleur;
import model.*;
import vue.*;

import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
public class ContAjoutActivites implements ActionListener {
    private VueAjoutActivites vue;
    private Hotel hotel;

    public ContAjoutActivites(VueAjoutActivites vue, Hotel hotel) {
        this.vue = vue;
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String nom = vue.nomProduit.getText();
        float prix = Float.parseFloat(vue.prixProduit.getText());
        new Activites(nom, prix, hotel);
        vue.dispose();
    }
}
