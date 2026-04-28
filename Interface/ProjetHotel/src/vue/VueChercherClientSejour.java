package vue;
import model.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
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
        setVisible(true);

        // Ajouter les composants au frame
        frame.add(textField);
        frame.add(buttonChercher);
        frame.setVisible(true);
    }
}
