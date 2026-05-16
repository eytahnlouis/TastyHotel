package controleur;

import vue.*;
import model.Hotel;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContSupprimerReservation implements ActionListener {
 
    private final Hotel hotel;
 
    public ContSupprimerReservation(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueSupprimerReservation(hotel);
    }
}
