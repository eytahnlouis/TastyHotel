package vue;
import model.*;
import javax.swing.*;
import java.awt.*;

public class VueHotelStatistiques extends JFrame {
    JTextField mostBookedRoom = new JTextField();
    JTextField biggestSpender = new JTextField();
    JButton btnQuit = new JButton("Quitter");

    public VueHotelStatistiques(Hotel h1){
        setTitle("Informations sur l' hotel " + h1.getNomHotel());
        setSize(500, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Infos
        JPanel panelInfos = new JPanel(new GridLayout(5, 1));

        String clientInfo = "Client : ";
        Client[] spenders = h1.biggestSpender();
        if (spenders.length > 0 && spenders[0] != null) {
            clientInfo += spenders[0].getNomClient();
        } else {
            clientInfo += "Aucun client";
        }

        String chambreInfo = "Chambre : ";
        Chambre mostBooked = h1.mostBookedRoom();
        if (mostBooked != null) {
            chambreInfo += mostBooked.getNumChambre();
        } else {
            chambreInfo += "Aucune chambre";
        }

        panelInfos.add(new JLabel(clientInfo));
        panelInfos.add(new JLabel(chambreInfo));


        // Boutons
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(btnQuit);


        add(panelInfos, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

        setVisible(true);

        btnQuit.addActionListener(e -> dispose());

    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueHotelStatistiques(h1);
    }


}
