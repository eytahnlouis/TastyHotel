package vue;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import model.*;


public class VueListeReservation extends JFrame {
    public VueListeReservation(Hotel hotel) {
        setTitle("Liste des réservations en cours ce jour" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        setSize(500, 400);

        String[] colonnes = { "idClient", "debut", "fin", "nuChambre" };
        Vector<Client> c = hotel.getClientOfDay(LocalDate.now());

        Object[][] data = new Object[c.size()][4];

        for (int i = 0; i < c.size(); i++) {
            Client client = c.get(i);
            data[i][0] = client.getNumClient();
            data[i][1] = client.getListReservation().getLast().getDateDebut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            data[i][2] = client.getListReservation().getLast().getDateFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            data[i][3] = client.getListReservation().getLast().getChambre().getNumChambre();
        }
        JTable table = new JTable(data, colonnes);
        add(new JScrollPane(table));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}