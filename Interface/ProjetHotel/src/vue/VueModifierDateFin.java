package vue;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class VueModifierDateFin extends JFrame {
    JTextField jour  = new JTextField(2);
    JTextField mois  = new JTextField(2);
    JTextField annee = new JTextField(4);
    JButton btnAjouter = new JButton("Modifier");
    JButton btnAnnuler = new JButton("Annuler");

    // Récupérer la date


    public VueModifierDateFin(Sejour s) {
        super("Modifier date");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("Jour:"));
        panelBoutons.add(jour);
        panelBoutons.add(new JLabel("Mois:"));
        panelBoutons.add(mois);
        panelBoutons.add(new JLabel("Année:"));
        panelBoutons.add(annee);
        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnAnnuler);
        setContentPane(panelBoutons);
        setVisible(true);

        btnAnnuler.addActionListener(e -> dispose());
    }

    static void main(String[] args) {
        Hotel hotel = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        Client c1 = new Client("Dupont", "Jean", hotel);
        Chambre ch1 = new Chambre("Simple", 2, 3,(float)55.45, hotel);
        Reservation r = new Reservation(c1, LocalDate.now(), LocalDate.now().plusDays(3), ch1);
        Sejour s1 = new Sejour(r);

        new VueModifierDateFin(s1);
    }
}
