package vue;
import java.awt.*;
import javax.swing.*;
import model.*;



public class VueChoisirPossibilitesClient {

    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");

    public VueChoisirPossibilitesClient(Hotel h1) {
        JFrame frame = new JFrame("Choisir une possibilité de client");
        frame.setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonAjouter);
        panelBoutons.add(buttonSupprimer);
        panelBoutons.add(buttonConsulter);

        frame.add(panelBoutons);
        frame.setVisible(true);

        buttonAjouter.addActionListener(e -> {
            new VueListeClients(h1);
        });
    }

    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirPossibilitesClient(h1);
    }
}

