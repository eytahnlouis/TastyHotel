package vue;
import javax.swing.*;
import model.*;
import java.awt.*;
import java.util.Vector;
import controleur.*;

public class VueListeProduits extends JFrame {
    public VueListeProduits(Hotel h) {
        setTitle("Produits de " + h.getNomHotel());
        setSize(500, 400);

        String[] colonnes = {"id", "nom", "prix", "stock"};
        Vector<Produits> produits = h.getListeProduits();
        Object[][] data = new Object[produits.size()][colonnes.length];

        for (int i = 0; i < produits.size(); i++) {
            Produits c = produits.get(i);
            data[i][0] = c.getNumProduit();
            data[i][1] = c.getNomProduit();
            data[i][2] = c.getPrixProduit() + " €";
            data[i][3] = c.getQuantite();
        }

        JTable table = new JTable(data, colonnes);
        add(new JScrollPane(table));
        setVisible(true);
    }
}
