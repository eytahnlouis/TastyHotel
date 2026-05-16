package controleur;

import model.Hotel;
import vue.VueSupprimerActivitesHotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class ContSupprimerActivitesHotel implements ActionListener {
 
    private final Hotel hotel;
 
    public ContSupprimerActivitesHotel(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueSupprimerActivitesHotel();
    }
}
