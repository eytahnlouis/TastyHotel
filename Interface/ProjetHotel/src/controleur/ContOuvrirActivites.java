package controleur;
 
import model.Hotel;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContOuvrirActivites implements ActionListener {
 
    private Hotel hotel;
 
    public ContOuvrirActivites(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueChoisirActiviteshotel(hotel);
    }
}
