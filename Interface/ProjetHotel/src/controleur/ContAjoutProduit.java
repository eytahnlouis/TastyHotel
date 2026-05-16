package controleur;
import model.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class ContAjoutProduit implements ActionListener {
    private VueAjoutProduit vue;
    private Hotel hotel;

    public ContAjoutProduit(VueAjoutProduit vue, Hotel hotel) {
        this.vue = vue;
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int codeBarre = Integer.parseInt(vue.idProduit.getText());
        String nom = vue.nomProduit.getText();
        float prix = Float.parseFloat(vue.prixProduit.getText());
        int quantite = Integer.parseInt(vue.quantiteProduit.getText());
        new Produits(codeBarre,nom, prix, quantite, hotel);
        vue.dispose();
    }

}
