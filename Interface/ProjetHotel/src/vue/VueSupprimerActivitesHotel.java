package vue;
import controleur.ContSupprimerActivitesHotel;
import model.Hotel;

import javax.swing.*;
import java.awt.*;

public class VueSupprimerActivitesHotel extends JFrame {
    public JTextField idProduit = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueSupprimerActivitesHotel(Hotel h1) {
        setTitle("Supprimer une Activité");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id activité :"));
        Component idActivite;
        panelBoutons.add(idProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuitter);

        add(panelBoutons);
        setVisible(true);
        btnValider.addActionListener(new ContSupprimerActivitesHotel(this, h1));
        btnQuitter.addActionListener(e -> {
            dispose();
        });
        
    }

}
