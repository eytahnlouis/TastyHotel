package controleur;
 
import vue.*;
import model.Hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContOuvrirReservations implements ActionListener {
 
    private Hotel hotel;
 
    public ContOuvrirReservations(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueChoisirPossibiliteReservation(hotel);
    }
}