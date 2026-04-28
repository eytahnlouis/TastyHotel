package Vue;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Vector;
public class VueMenageChambre extends JFrame {

    public VueMenageChambre(Hotel h1) {
        Vector<Chambre> chambresANettoyer = h1.ChambreANettoyer();
        setTitle("Menage Chambre du" + LocalDateTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
        setSize(500,500);
        setVisible(true);

        String[] colonnesChambre = {"Num Chambre", "Type Chambre", "Num Etage"};
    }

    public static void main(String[] args) {
        new VueMenageChambre();
    }
}
