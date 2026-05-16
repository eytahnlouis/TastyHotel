package controleur;
 
import model.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContOuvrirProduits implements ActionListener {
 
    private Hotel hotel;

    public ContOuvrirProduits(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        new VueChoisirProduit(hotel);
    }
}
