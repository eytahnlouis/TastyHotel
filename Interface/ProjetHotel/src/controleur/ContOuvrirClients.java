package controleur;
 
import vue.VueRechercheClient;
import model.Hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContOuvrirClients implements ActionListener {
 
    private Hotel hotel;
 
    public ContOuvrirClients(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueRechercheClient(hotel);
    }
}