package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueAjoutActivites extends JFrame {
    JTextField nomProduit = new JTextField(10);
    JTextField prixProduit = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueAjoutActivites(Hotel h1) {
        setTitle("Ajouter une activité");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());

        panelBoutons.add(new JLabel("nom de l'activité :"));
        panelBoutons.add(nomProduit);
        panelBoutons.add(new JLabel("Prix :"));
        panelBoutons.add(prixProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuiter);

        add(panelBoutons);
        setVisible(true);
        btnQuiter.addActionListener(e -> {
            dispose();
        });
        //contrôleur à ajouter : toi permettre la création d'un produit ajouter l'hotel
        //signature Produits(int numProduit, String nomProduit, float prixProduit, int quantite, Hotel hotel)
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueAjoutActivites(h1);
    }
}

