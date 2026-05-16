package vue;
import controleur.ContAjoutProduitSejour;
import controleur.ContSupprimerActivitesSejour;
import model.Hotel;
import model.Sejour;

import javax.swing.*;
import java.awt.*;

public class VueSupprimerActivites extends JFrame {
    public JTextField idProduit = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueSupprimerActivites(Sejour h1) {
        setTitle("Supprimer une activité");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id Activité :"));
        panelBoutons.add(idProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuitter);

        add(panelBoutons);
        setVisible(true);
        btnValider.addActionListener(new ContSupprimerActivitesSejour(this, h1));
        btnQuitter.addActionListener(e -> {
            dispose();
        });

    }
}
