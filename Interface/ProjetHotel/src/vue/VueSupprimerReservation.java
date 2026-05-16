package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueSupprimerReservation extends JFrame {
    JTextField idClient = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueSupprimerReservation(Hotel h1) {
        setTitle("Supprimer un client");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id :"));
        panelBoutons.add(idClient);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuiter);

        add(panelBoutons);
        setVisible(true);
        btnQuiter.addActionListener(e -> {
            dispose();
        });
        //contrôleur à ajouter : toi permettre la suppression d'une resa de l'hotel
        //signature client (nom, prenom, hotel)
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueSupprimerReservation(h1);
    }
}


