package vue;
import controleur.ContSupprimerClientHotel;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueSupprimerClient extends JFrame {
    public JTextField idClient = new JTextField();
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueSupprimerClient(Hotel h1) {
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
        btnValider.addActionListener(new ContSupprimerClientHotel(this, h1));

    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueSupprimerClient(h1);
    }
}


