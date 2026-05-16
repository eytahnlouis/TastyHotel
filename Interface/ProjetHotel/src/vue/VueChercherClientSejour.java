package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
import controleur.*;

public class VueChercherClientSejour extends JFrame {
    JTextField textField = new JTextField();
    JButton buttonChercher = new JButton("Chercher");

    public VueChercherClientSejour(Hotel h1) {
        JFrame frame = new JFrame();
        frame.setTitle("Chercher le réservation d'un client pour un séjour");
        frame.setSize(500,500);
        frame.setLayout(null);
        setSize(500,500);
        textField.setBounds(50, 100, 200, 50);
        buttonChercher.setBounds(300, 100, 150, 50);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(buttonChercher);
        panelBoutons.add(textField);
        setVisible(true);

        // Ajouter les composants au frame
        frame.add(panelBoutons);
        frame.setVisible(true);
        buttonChercher.addActionListener (new ContOuvrirSejours(h1));
    }
}

