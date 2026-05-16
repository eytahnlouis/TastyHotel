package vue;
import controleur.ContSupprimerProduit;
import model.Hotel;

import javax.swing.*;
import java.awt.*;

public class VueSupprimerProduit extends JFrame {
    public JTextField idProduit = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueSupprimerProduit(Hotel h1) {
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
        btnValider.addActionListener(new ContSupprimerProduit(this, h1));
        //contr�leur � ajouter : toi permettre la suppression d'une activit� de l'hotel

    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueSupprimerProduit(h1);
    }
}
