package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class VueListeClients extends JFrame {

    public VueListeClients(Hotel h) {
        setTitle("Clients de " + h.getNomHotel());
        setSize(500, 400);

        String[] colonnes = {"id", "nom", "prenom", "fidélité"};
        Vector<Client> chambres = h.getListClient();
        Object[][] data = new Object[chambres.size()][4];

        for (int i = 0; i < chambres.size(); i++) {
            Client c = chambres.get(i);
            data[i][0] = c.getNomClient();
            data[i][1] = c.getNomClient();
            data[i][2] = c.getPrenomClient();
            data[i][3] = c.isFaithful() ? "Oui" : "Non";
        }

        JTable table = new JTable(data, colonnes);
        add(new JScrollPane(table));
        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueListeClients(h1);
    }
}
