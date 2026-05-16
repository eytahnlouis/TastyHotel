package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
import controleur.*;

public class VueChercherClientSejour extends JFrame {
    public JTextField textField = new JTextField(10);
    JButton buttonChercher = new JButton("Chercher");

    public VueChercherClientSejour(Hotel h1) {
        setTitle("Chercher la réservation d'un client pour un séjour");
        setSize(500, 150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("ID client :"));
        panelBoutons.add(textField);
        panelBoutons.add(buttonChercher);
        add(panelBoutons);
        setVisible(true);

        buttonChercher.addActionListener (new ContOuvrirSejours(this, h1));
    }
}

