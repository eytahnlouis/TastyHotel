package controleur;

import model.Reservation;
import vue.*;
import model.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ContSupprimerReservation implements ActionListener {
    private VueSupprimerReservation vue;
    private final Hotel hotel;
 
    public ContSupprimerReservation(VueSupprimerReservation vue,Hotel hotel) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        int idResa = Integer.parseInt(vue.idClient.getText());
        Reservation resa = hotel.getReservationById(idResa);

        try {
            hotel.supprimerReservation(resa);
            JOptionPane.showMessageDialog(vue, "Réservation supprimée avec succès.");
            vue.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur lors de la suppression de la réservation : " + ex.getMessage());
        }
    }
}
