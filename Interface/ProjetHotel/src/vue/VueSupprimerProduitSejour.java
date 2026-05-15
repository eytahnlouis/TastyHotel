package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;

public class VueSupprimerProduitSejour extends JFrame {
    JTextField idProduit = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueSupprimerProduitSejour(Sejour h1) {
        setTitle("Supprimer un produit");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id produit :"));
        panelBoutons.add(idProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuitter);

        add(panelBoutons);
        setVisible(true);
        btnQuitter.addActionListener(e -> {
            dispose();
        });
        //contrôleur à ajouter : toi permettre la suppression d'une activité de l'hotel

    }
}

