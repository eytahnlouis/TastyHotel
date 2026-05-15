package vue;
import model.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class VueListeActivitesSejour extends JFrame {

    public VueListeActivitesSejour(Sejour h) {
        setTitle("Activités de " + h.getReservation().getClient().getNomClient() );
        setSize(500, 400);

        String[] colonnes = {"id", "nom", "prix"};
        Activites[] activites = h.getActivites();
        Object[][] data = new Object[activites.length][colonnes.length];

        for (int i = 0; i < activites.length; i++) {
            Activites c = activites[i];
            data[i][0] = c.getNumActivite();
            data[i][1] = c.getNomActivite();
            data[i][2] = c.getPrixActivite() + " €";
        }

        JTable table = new JTable(data, colonnes);
        add(new JScrollPane(table));
        setVisible(true);
    }


}
