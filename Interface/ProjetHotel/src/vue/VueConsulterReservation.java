package vue;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Fenêtre de consultation des réservations d'un client.
 * Sélection du client → affichage de ses réservations en lecture seule.
 */
public class VueConsulterReservation extends JFrame {

    JComboBox<Client> comboClients = new JComboBox<>();
    JList<Reservation> listeReservations = new JList<>();
    DefaultListModel<Reservation> modeleList = new DefaultListModel<>();

    // Détail de la réservation sélectionnée
    JLabel lblChambre   = new JLabel("Chambre : -");
    JLabel lblDates     = new JLabel("Dates : -");
    JLabel lblPrix      = new JLabel("Prix théorique : -");
    JLabel lblFidelite  = new JLabel("Client fidèle : -");

    JButton btnFermer = new JButton("Fermer");

    public VueConsulterReservation(Hotel hotel) {
        setTitle("Consulter les réservations");
        setSize(550, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ── Panel haut : sélection client ──
        JPanel panelClient = new JPanel(new FlowLayout());
        panelClient.add(new JLabel("Client :"));
        for (Client c : hotel.getListClient()) {
            comboClients.addItem(c);
        }
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
        panelClient.add(comboClients);

        // ── Centre gauche : liste des réservations ──
        listeReservations.setModel(modeleList);
        listeReservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeReservations.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Reservation r) {
                    setText("Chambre N°" + r.getChambre().getNumChambre()
                            + " | " + r.getDateDebut() + " → " + r.getDateFin());
                }
                return this;
            }
        });

        // ── Centre droit : détail ──
        JPanel panelDetail = new JPanel(new GridLayout(5, 1, 5, 5));
        panelDetail.setBorder(BorderFactory.createTitledBorder("Détail"));
        panelDetail.add(lblChambre);
        panelDetail.add(lblDates);
        panelDetail.add(lblPrix);
        panelDetail.add(lblFidelite);

        JPanel panelCentre = new JPanel(new GridLayout(1, 2, 10, 0));
        panelCentre.add(new JScrollPane(listeReservations));
        panelCentre.add(panelDetail);

        // ── Bas : bouton fermer ──
        JPanel panelBas = new JPanel(new FlowLayout());
        panelBas.add(btnFermer);

        add(panelClient, BorderLayout.NORTH);
        add(panelCentre, BorderLayout.CENTER);
        add(panelBas, BorderLayout.SOUTH);

        // ── Listeners ──

        // Changement de client → recharger la liste
        comboClients.addActionListener(e -> {
            modeleList.clear();
            resetDetail();
            Client selected = (Client) comboClients.getSelectedItem();
            if (selected != null) {
                for (Reservation r : selected.getListReservation()) {
                    modeleList.addElement(r);
                }
            }
        });

        // Sélection d'une réservation → afficher le détail
        listeReservations.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Reservation r = listeReservations.getSelectedValue();
                if (r != null) afficherDetail(r);
            }
        });

        // Charger le premier client au démarrage
        if (comboClients.getItemCount() > 0) {
            Client premier = comboClients.getItemAt(0);
            for (Reservation r : premier.getListReservation()) {
                modeleList.addElement(r);
            }
            lblFidelite.setText("Client fidèle : " + premier.isFaithful());
        }

        btnFermer.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void afficherDetail(Reservation r) {
        lblChambre.setText("Chambre : N°" + r.getChambre().getNumChambre()
                + " - " + r.getChambre().getTypeChambre()
                + " (" + r.getChambre().getPrixChambre() + " €/nuit)");
        lblDates.setText("Dates : " + r.getDateDebut() + " → " + r.getDateFin()
                + " (" + r.getNbJours() + " nuits)");
        lblPrix.setText("Prix théorique : " + r.getPrixTotalTheorique() + " €");
        lblFidelite.setText("Client fidèle : " + r.getClient().isFaithful());
    }

    private void resetDetail() {
        lblChambre.setText("Chambre : -");
        lblDates.setText("Dates : -");
        lblPrix.setText("Prix théorique : -");
        lblFidelite.setText("Client fidèle : -");
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        Chambre ch = new Chambre("Simple", 1, 1, 44.99f, h1);
        Client c1 = new Client("Dupont", "Jean", h1);
        new Reservation(c1, LocalDate.now().plusDays(2), LocalDate.now().plusDays(5), ch);
        new VueConsulterReservation(h1);
    }
}
