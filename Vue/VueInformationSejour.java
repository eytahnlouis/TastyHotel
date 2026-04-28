package Vue;
import Model.*;
import javax.swing.*;
import java.awt.*;

public class VueInformationSejour extends JFrame {

    JButton buttonActivite = new JButton("Activités");
    JButton buttonProduits = new JButton("Produits");
    JButton buttonFacture  = new JButton("Facture");
    JButton buttonDepart   = new JButton("Départ");

    public VueInformationSejour(Sejour s1) {

        setTitle("Informations sur le séjour");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Infos 
        JPanel panelInfos = new JPanel(new GridLayout(5, 1));
        panelInfos.add(new JLabel("Client : " + s1.getReservation().getClient().nomClient));
        panelInfos.add(new JLabel("Chambre : " + s1.getReservation().getChambre().getNumChambre()));
        panelInfos.add(new JLabel("Date début : " + s1.getReservation().getDateDebut()));
        panelInfos.add(new JLabel("Date fin réelle : " + s1.getDateFinReel()));
        panelInfos.add(new JLabel("Prix total réel : " + s1.getPrixTotalReel() + " €"));

        // Boutons
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonActivite);
        panelBoutons.add(buttonProduits);
        panelBoutons.add(buttonFacture);
        panelBoutons.add(buttonDepart);

        add(panelInfos, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

        setVisible(true);
    }
}
