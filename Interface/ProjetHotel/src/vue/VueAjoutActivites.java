package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
public class VueAjoutActivites extends JFrame {
    public JTextField nomProduit = new JTextField(10);
    public JTextField prixProduit = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueAjoutActivites(Hotel h1) {
        setTitle("Ajouter une activité");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());

        panelBoutons.add(new JLabel("nom de l'activité :"));
        panelBoutons.add(nomProduit);
        panelBoutons.add(new JLabel("Prix :"));
        panelBoutons.add(prixProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuitter);

        add(panelBoutons);
        setVisible(true);
        btnQuitter.addActionListener(e -> {
            dispose();
        });
        btnValider.addActionListener(new ContAjoutActivites(this,h1));
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueAjoutActivites(h1);
    }
}


