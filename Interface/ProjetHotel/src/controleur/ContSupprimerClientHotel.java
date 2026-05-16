package controleur;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class ContSupprimerClientHotel implements ActionListener {
    private Hotel hotel;
    private VueSupprimerClient vue;

    public ContSupprimerClientHotel(VueSupprimerClient vue,Hotel hotel) {
        this.hotel = hotel;
        this.vue = new VueSupprimerClient(hotel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(vue.idClient.getText());
        Client clientToRemove = null;

        for (Client c : hotel.getListClient()) {
            if (c.getNumClient() == id) {
                clientToRemove = c;
                break;
            }
        }

        if (clientToRemove != null) {
            hotel.removeClient(clientToRemove);
            JOptionPane.showMessageDialog(vue, "Client supprimé avec succès.");
        } else {
            JOptionPane.showMessageDialog(vue, "Client non trouvé.");
        }

        vue.dispose();
    }
}
