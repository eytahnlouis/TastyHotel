package controleur;
 
import model.Sejour;
import vue.VueChercherClientSejour;
import model.Hotel;
import vue.VueInformationSejour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContOuvrirSejours implements ActionListener {
    private final VueChercherClientSejour vue;
    private Hotel hotel;
 
    public ContOuvrirSejours(VueChercherClientSejour vue, Hotel hotel) {
        this.vue = vue;
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {

        int numSejour = Integer.parseInt(vue.textField.getText());
        Sejour s = hotel.getReservationById(numSejour).getSejour();

        new VueInformationSejour(s);

    }
}
 