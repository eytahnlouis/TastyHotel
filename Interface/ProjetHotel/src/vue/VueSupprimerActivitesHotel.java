package vue;
import model.Hotel;

import javax.swing.*;
import java.awt.*;

public class VueSupprimerActivitesHotel extends JFrame {
    JTextField idProduit = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public void VueSupprimerActiviteHotel(Hotel h1) {
        setTitle("Supprimer une Activite");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id activite :"));
        Component idActivite;
        panelBoutons.add(idActivite);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuitter);

        add(panelBoutons);
        setVisible(true);
        btnQuitter.addActionListener(e -> {
            dispose();
        });
        
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueSupprimerActivitesHotel();
    }
}
