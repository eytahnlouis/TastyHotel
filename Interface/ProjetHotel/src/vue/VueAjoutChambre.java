package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueAjoutChambre extends JFrame {
    //Chambre(String typeChambre, int numChambre, int numEtage, float prixChambre, Hotel hotel)
    JTextField numChambre = new JTextField(10);
    JTextField numEtage = new JTextField(10);
    JTextField prixChambre = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

public VueAjoutChambre(Hotel h1) {
        setTitle("Ajouter une chambre");
        setSize(500,150);
        String[] types = {"Simple", "Double", "Suite"};
        JComboBox<String> comboType = new JComboBox<>(types);
        // Récupérer
        String typeChoisi = (String) comboType.getSelectedItem();
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
        btnQuiter.addActionListener(e -> {
            dispose();
        });
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueAjoutChambre(h1);
    }
}

