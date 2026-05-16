package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
import controleur.* ;
public class VueAjoutClient extends JFrame {
    public JTextField nomClient = new JTextField(10);
    public JTextField prenomClient = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueAjoutClient(Hotel h1) {
        setTitle("Ajouter un client");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("Nom :"));
        panelBoutons.add(nomClient);
        panelBoutons.add(new JLabel("Prénom :"));
        panelBoutons.add(prenomClient);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuiter);

        add(panelBoutons);
        setVisible(true);
        btnQuiter.addActionListener(e -> {
            dispose();
        });
        btnValider.addActionListener(new ContValiderAjoutClient(h1, this));
        //contrôleur à ajouter : toi permettre la création d'un client ajouter l'hotel
        //signature client (nom, prenom, hotel)
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueAjoutClient(h1);
    }
}
