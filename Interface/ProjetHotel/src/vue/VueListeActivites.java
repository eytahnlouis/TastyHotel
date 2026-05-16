package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class VueListeActivites extends JFrame {

    public VueListeActivites(Hotel h) {
        setTitle("Activités de " + h.getNomHotel());
        setSize(500, 400);

        String[] colonnes = {"id", "nom", "prix"};
        Vector<Activites> activites = h.getListeActivites();
        Object[][] data = new Object[activites.size()][colonnes.length];

        for (int i = 0; i < activites.size(); i++) {
            Activites c = activites.get(i);
            data[i][0] = c.getNumActivite();
            data[i][1] = c.getNomActivite();
            data[i][2] = c.getPrixActivite() + " €";
        }

        JTable table = new JTable(data, colonnes);
        add(new JScrollPane(table));
        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueListeActivites(h1);
    }
}
