package controleur;

import model.*;
import vue.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class ContAjouterReservation implements ActionListener {
    private Hotel hotel;
    private VueAjoutReservation vue;

    public ContAjouterReservation(Hotel hotel, VueAjoutReservation vue) {
        this.hotel = hotel;
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client client = (Client) vue.comboClients.getSelectedItem();
        Chambre chambre = (Chambre) vue.comboChambre.getSelectedItem();

        int jour = Integer.parseInt(vue.jourDebut.getText());
        int mois = Integer.parseInt(vue.moisDebut.getText());
        int annee = Integer.parseInt(vue.anneeDebut.getText());
        LocalDate debut = LocalDate.of(annee, mois, jour);

        int jourF = Integer.parseInt(vue.jourFin.getText());
        int moisF = Integer.parseInt(vue.moisFin.getText());
        int anneeF = Integer.parseInt(vue.anneeFin.getText());
        LocalDate fin = LocalDate.of(anneeF, moisF, jourF);

        if (!hotel.isRoomAvailable(debut, fin, chambre)) {
            JOptionPane.showMessageDialog(vue, "Chambre non disponible.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new Reservation(client, debut, fin, chambre);
        JOptionPane.showMessageDialog(vue, "Réservation créée !");
        vue.dispose();
    }
}