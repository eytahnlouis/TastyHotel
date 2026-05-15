package vue;
import model.*;
import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

public class VueAjoutReservation extends JDialog {

    public VueAjoutReservation(JFrame parent, Hotel hotel, Client client) {
        super(parent, "Nouvelle réservation", true);
        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Sélection chambre
        JLabel lblChambre = new JLabel("Chambre :");
        JComboBox<Chambre> comboChambre = new JComboBox<>(hotel.getListChambre());

        // Dates
        JLabel lblDebut = new JLabel("Date début (YYYY-MM-DD) :");
        JTextField txtDebut = new JTextField();
        JLabel lblFin = new JLabel("Date fin (YYYY-MM-DD) :");
        JTextField txtFin = new JTextField();

        JButton btnValider = new JButton("Valider");
        JButton btnAnnuler = new JButton("Annuler");

        btnValider.addActionListener(e -> {
            Chambre chambre = (Chambre) comboChambre.getSelectedItem();
            LocalDate debut = LocalDate.parse(txtDebut.getText());
            LocalDate fin = LocalDate.parse(txtFin.getText());

            // Vérif dispo avant de créer
            if (hotel.isRoomAvailable(debut, fin, chambre)) {
                new Reservation(client, debut, fin, chambre);
                JOptionPane.showMessageDialog(this, "Réservation créée !");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Chambre non disponible.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAnnuler.addActionListener(e -> dispose());

        add(lblChambre); add(comboChambre);
        add(lblDebut);   add(txtDebut);
        add(lblFin);     add(txtFin);
        add(btnValider); add(btnAnnuler);

        setVisible(true);
    }
}