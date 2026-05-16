package controleur;

import model.Activites;
import model.*;
import vue.VueSupprimerActivitesHotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class ContSupprimerActivitesHotel implements ActionListener {

    private VueSupprimerActivitesHotel vue;
    private final Hotel hotel;
 
    public ContSupprimerActivitesHotel(VueSupprimerActivitesHotel vue , Hotel hotel) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        int intActivite = Integer.parseInt(vue.idProduit.getText());
        Activites a = hotel.getActivitesById(intActivite);
        if (a == null) {
            JOptionPane.showMessageDialog(vue, "Activité non trouvée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        hotel.supprimerActivite(a);
    }
}
