package vue;
import controleur.*;
import model.*;
import javax.swing.*;
import java.awt.*;

public class VueSupprimerActivitesSejour extends JFrame {
    JTextField idClient = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuitter = new JButton("Quitter");

    public VueSupprimerActivitesSejour(Sejour h1) {
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
}
