package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.time.temporal.ChronoUnit;
import javax.swing.table.DefaultTableModel;

public class VueFactureSejour extends JFrame {

    public VueFactureSejour(Sejour sejour) {
        Client client = sejour.getReservation().getClient();
        Chambre chambre = sejour.getReservation().getChambre();

        setTitle("Facture - " + client.getNomClient());
        setSize(600, 500);
        setLayout(new BorderLayout(10, 10));

        // --- Header ---
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.add(new JLabel("Client : " + client.getNomClient() + " " + client.getPrenomClient()));
        header.add(new JLabel(" | Chambre : " + chambre.getNumChambre()));
        header.add(new JLabel(" | Arrivée : " + sejour.getReservation().getDateDebut()));
        header.add(new JLabel(" | Départ : " + sejour.getDateFinReel()));

        // --- Table lignes ---
        String[] colonnes = {"Description", "Qté", "Prix unitaire", "Total"};
        DefaultTableModel model = new DefaultTableModel(colonnes, 0);

        // Nuits de chambre
        long nbNuits = ChronoUnit.DAYS.between(
                sejour.getReservation().getDateDebut(),
                sejour.getDateFinReel()
        );
        float prixChambre = chambre.getPrixChambre();
        model.addRow(new Object[]{
                "Chambre " + chambre.getTypeChambre(),
                nbNuits,
                prixChambre + " €",
                (nbNuits * prixChambre) + " €"
        });

        // Produits du séjour
        for (Produits p : sejour.getListProduits()) {
            model.addRow(new Object[]{
                    "Produit - " + p.getNomProduit(),
                    1,
                    p.getPrixProduit() + " €",
                    p.getPrixProduit() + " €"
            });
        }

        // Activités du séjour
        for (Activites a : sejour.getListActivites()) {
            model.addRow(new Object[]{
                    "Activité - " + a.getNomActivite(),
                    1,
                    a.getPrixActivite() + " €",
                    a.getPrixActivite() + " €"
            });
        }

        JTable table = new JTable(model);
        table.setEnabled(false); // lecture seule

        // --- Footer total ---
        float total = sejour.getPrixTotalReel();
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel totalLabel = new JLabel("TOTAL : " + String.format("%.2f", total) + " €");
        totalLabel.setFont(totalLabel.getFont().deriveFont(Font.BOLD, 16f));
        footer.add(totalLabel);

        JButton btnFermer = new JButton("Fermer");
        btnFermer.addActionListener(e -> dispose());
        footer.add(btnFermer);

        add(header, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }
}
