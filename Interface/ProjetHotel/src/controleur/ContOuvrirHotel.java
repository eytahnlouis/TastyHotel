package controleur;
 
import vue.VueHotel;
import model.Hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContOuvrirHotel implements ActionListener {
 
    private Hotel hotel;
 
    public ContOuvrirHotel(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueHotel(hotel);
    }
}