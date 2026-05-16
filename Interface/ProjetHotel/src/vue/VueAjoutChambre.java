package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutChambre extends JFrame {
    JTextField numChambre = new JTextField(10);
    JTextField numEtage = new JTextField(10);
    JTextField prixChambre = new JTextField(10);
    JComboBox<String> comboType = new JComboBox<>(new String[]{"Simple", "Double", "Suite"});
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueAjoutChambre(Hotel h1) {
        setTitle("Ajouter une chambre");
        setSize(500, 150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("Type :"));
        panelBoutons.add(comboType);
        panelBoutons.add(new JLabel("Numéro de chambre :"));
        panelBoutons.add(numChambre);
        panelBoutons.add(new JLabel("Numéro d'étage :"));
        panelBoutons.add(numEtage);
        panelBoutons.add(new JLabel("Prix de la chambre :"));
        panelBoutons.add(prixChambre);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuiter);
        add(panelBoutons);
        setVisible(true);

        btnValider.addActionListener(new ContAjoutChambre(this, h1));
        btnQuiter.addActionListener(e -> dispose());
    }

    public JComboBox<String> getComboType() { return comboType; }
    public JTextField getNumChambre() { return numChambre; }
    public JTextField getNumEtage() { return numEtage; }
    public JTextField getPrixChambre() { return prixChambre; }
}