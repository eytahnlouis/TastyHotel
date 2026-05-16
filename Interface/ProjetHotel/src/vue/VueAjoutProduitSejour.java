package vue;
import controleur.ContAjoutProduitSejour;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueAjoutProduitSejour extends JFrame {
    public JTextField nomProduit = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueAjoutProduitSejour(Sejour h1) {
        setTitle("Ajouter une activité");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());

        panelBoutons.add(new JLabel("id Activité :"));
        panelBoutons.add(nomProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuiter);

        add(panelBoutons);
        setVisible(true);
        btnValider.addActionListener(new ContAjoutProduitSejour(this, h1));
        btnQuiter.addActionListener(e -> {
            dispose();
        });

        btnValider.addActionListener( new ContAjoutProduitSejour(this, h1));
        //contrôleur à ajouter : toi permettre la création d'un produit ajouter l'hotel
        //signature Produits(int numProduit, String nomProduit, float prixProduit, int quantite, Hotel hotel)
    }

}

