package vue;
import model.Hotel;

import javax.swing.*;
import java.awt.*;

public class VueSupprimerActivites extends JFrame {
    JTextField idClient = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueSupprimerActivites(Hotel h1) {
        setTitle("Supprimer un client");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id Activites :"));
        panelBoutons.add(idClient);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuitter);

        add(panelBoutons);
        setVisible(true);
        btnQuitter.addActionListener(e -> {
            dispose();
        });
        //contrôleur à ajouter : toi permettre la suppression d'une activité de l'hotel

    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueSupprimerActivites(h1);
    }
}
