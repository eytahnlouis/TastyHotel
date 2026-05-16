package controleur;
import model.*;
import vue.*;
import java.awt.event.*;

public class ContAjoutChambre implements ActionListener {
    private VueAjoutChambre vue;
    private Hotel hotel;

    public ContAjoutChambre(VueAjoutChambre vue, Hotel hotel) {
        this.vue = vue;
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type = (String) vue.getComboType().getSelectedItem();
        int num = Integer.parseInt(vue.getNumChambre().getText());
        int etage = Integer.parseInt(vue.getNumEtage().getText());
        float prix = Float.parseFloat(vue.getPrixChambre().getText());

        new Chambre(type, num, etage, prix, hotel);
        vue.dispose();
    }
}