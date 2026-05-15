package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class VueListeMenageJour extends JFrame {
    public VueListeMenageJour(Hotel h) {
        setTitle("Liste des chambrées à nettoyer aujourd'hui pour " + h.getNomHotel());
        setSize(500, 400);
        String[] colonnes = {"N°", "Type", "Étage", "Prix/nuit"};
        Vector<Chambre> chambres = h.chambreANettoyer();
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
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueListeMenageJour(h1);
    }
}
