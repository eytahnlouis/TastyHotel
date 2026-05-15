package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueAjoutActivitesSejour extends JFrame {
    JTextField nomProduit = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueAjoutActivitesSejour(Sejour h1) {
        setTitle("Ajouter une activité");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());

        panelBoutons.add(new JLabel("id Activites :"));
        panelBoutons.add(nomProduit);
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

}

