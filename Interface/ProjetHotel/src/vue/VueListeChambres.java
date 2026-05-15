package vue;
import model.*;
import javax.swing.*;
import java.util.*;

public class VueListeChambres extends JFrame {
    public VueListeChambres(Hotel h) {
        setTitle("Chambres de " + h.getNomHotel());
        setSize(500, 400);

        String[] colonnes = {"N°", "Type", "Étage", "Prix/nuit"};
        Vector<Chambre> chambres = h.getListChambre();
        Object[][] data = new Object[chambres.size()][4];

        for (int i = 0; i < chambres.size(); i++) {
            Chambre c = chambres.get(i);
            data[i][0] = c.getNumChambre();
            data[i][1] = c.getTypeChambre();
            data[i][2] = c.getNumEtage();
            data[i][3] = c.getPrixChambre() + " €";
        }

        JTable table = new JTable(data, colonnes);
        add(new JScrollPane(table));
        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueListeChambres(h);
    }
}
