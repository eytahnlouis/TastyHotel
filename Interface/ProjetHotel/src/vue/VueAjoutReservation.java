package vue;

import controleur.ContAjouterReservation;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

/**
 * Fenêtre d'ajout d'une réservation.
 * Permet de sélectionner un client, une chambre et les dates.
 */
public class VueAjoutReservation extends JFrame {

    // Sélection client
    public JComboBox<Client> comboClients = new JComboBox<>();

    // Sélection chambre
    public JComboBox<Chambre> comboChambre = new JComboBox<>();

    // Date de début
    public JTextField jourDebut  = new JTextField(2);
    public JTextField moisDebut  = new JTextField(2);
    public JTextField anneeDebut = new JTextField(4);

    // Date de fin
    public JTextField jourFin    = new JTextField(2);
    public JTextField moisFin    = new JTextField(2);
    public JTextField anneeFin   = new JTextField(4);

    JButton btnValider = new JButton("Valider");
    JButton btnAnnuler = new JButton("Annuler");

    public VueAjoutReservation(Hotel hotel) {
        setTitle("Ajouter une réservation");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Client
        panel.add(new JLabel("Client :"));
        for (Client c : hotel.getListClient()) {
            comboClients.addItem(c);
        }
        // Afficher nom + prénom dans la liste
        comboClients.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Client c) {
                    setText(c.getNomClient() + " " + c.getPrenomClient());
                }
                return this;
            }
        });
        panel.add(comboClients);

        // Chambre
        panel.add(new JLabel("Chambre :"));
        for (Chambre ch : hotel.getLChambres()) {
            comboChambre.addItem(ch);
        }
        comboChambre.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Chambre ch) {
                    setText("N°" + ch.getNumChambre() + " - " + ch.getTypeChambre() + " (" + ch.getPrixChambre() + "€/nuit)");
                }
                return this;
            }
        });
        panel.add(comboChambre);

        // Date début
        panel.add(new JLabel("Début (JJ/MM/AAAA) :"));
        panel.add(jourDebut);
        panel.add(new JLabel("/"));
        panel.add(moisDebut);
        panel.add(new JLabel("/"));
        panel.add(anneeDebut);

        // Date fin
        panel.add(new JLabel("Fin (JJ/MM/AAAA) :"));
        panel.add(jourFin);
        panel.add(new JLabel("/"));
        panel.add(moisFin);
        panel.add(new JLabel("/"));
        panel.add(anneeFin);

        // Boutons
        panel.add(btnValider);
        panel.add(btnAnnuler);

        add(panel);
        setVisible(true);

        // Contrôleur
        btnValider.addActionListener(new ContAjouterReservation(hotel, this));
        btnAnnuler.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new Chambre("Simple", 1, 1, 44.99f, h1);
        new Client("Dupont", "Jean", h1);
        new VueAjoutReservation(h1);
    }
}
