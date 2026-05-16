package controleur;
import  model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class ContAjoutActivitesHotel implements ActionListener {
 
    private Hotel hotel;
 
    public ContAjoutActivitesHotel(Hotel hotel) {
        this.hotel = hotel;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String nom  = JOptionPane.showInputDialog("Nom de l'activité :");
        String prix = JOptionPane.showInputDialog("Prix :");
        try {
            new Activites(nom.trim(), Float.parseFloat(prix.trim()), hotel);
            JOptionPane.showMessageDialog(null, "Activité ajoutée !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Valeur invalide.");
        }
    }
}