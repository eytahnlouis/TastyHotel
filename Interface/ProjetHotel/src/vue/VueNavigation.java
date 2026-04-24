package vue;

import javax.swing.*;
import java.awt.*;
import model.*;
import controleur.*;

/**
 * VUE NAVIGATION - S'ouvre après la création de l'hôtel
 * Affiche le nom/adresse et les boutons de navigation
 */
public class VueNavigation extends JFrame {

    // --- Objets graphiques ---
    JLabel  affNomHotel;
    JLabel  affAdresse;
    JButton btnChambres;
    JButton btnClients;
    JButton btnReservations;
    JButton btnActivites;
    JButton btnProduits;

    // --- Partie du modèle ---
    Hotel hotel;

    public VueNavigation(Hotel h) {
        hotel = h;

        this.setTitle("Gestion - " + hotel.getNomHotel());
        this.setPreferredSize(new Dimension(350, 320));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Affichage des infos de l'hôtel
        affNomHotel = new JLabel( hotel.getNomHotel(), SwingConstants.CENTER);
        affAdresse  = new JLabel( hotel.getAdresse(),  SwingConstants.CENTER);
        affNomHotel.setFont(new Font("SansSerif", Font.BOLD, 16));
        affAdresse.setFont(new Font("SansSerif", Font.ITALIC, 12));

        // Boutons de navigation
        btnChambres     = new JButton(" Chambres");
        btnClients      = new JButton(" Clients");
        btnReservations = new JButton(" Réservations");
        btnActivites    = new JButton(" Activités");
        btnProduits     = new JButton(" Produits");

        // Panel info hôtel (en haut)
        JPanel panelInfo = new JPanel(new GridLayout(2, 1, 4, 4));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        panelInfo.add(affNomHotel);
        panelInfo.add(affAdresse);

        // Panel boutons (au centre)
        JPanel panelBoutons = new JPanel(new GridLayout(5, 1, 8, 8));
        panelBoutons.setBorder(BorderFactory.createEmptyBorder(5, 30, 20, 30));
        panelBoutons.add(btnChambres);
        panelBoutons.add(btnClients);
        panelBoutons.add(btnReservations);
        panelBoutons.add(btnActivites);
        panelBoutons.add(btnProduits);

        // Mise en page
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelInfo,    BorderLayout.NORTH);
        this.getContentPane().add(panelBoutons, BorderLayout.CENTER);

        // Contrôleurs
        btnChambres.addActionListener(new OuvrirChambresControleur(hotel));
        btnClients.addActionListener(new OuvrirClientsControleur(hotel));
        btnReservations.addActionListener(new OuvrirReservationsControleur(hotel));
        btnActivites.addActionListener(new OuvrirActivitesControleur(hotel));
        btnProduits.addActionListener(new OuvrirProduitsControleur(hotel));

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
