package controleur;
 
import vue.VueChercherClientSejour;
import model.Hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContOuvrirSejours implements ActionListener {
 
    private Hotel hotel;
 
    public ContOuvrirSejours(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueChercherClientSejour(hotel);
    }
}
 