package vue;

import javax.swing.*;

import model.*;

class VueChoisirPossibiliteReservation extends JFrame {
    JButton buttonAjouter = new JButton("Ajouter");
    JButton buttonSupprimer = new JButton("Supprimer");
    JButton buttonConsulter = new JButton("Consulter");
    public VueChoisirPossibiliteReservation(Hotel h1) {
        setTitle("Choisir une possibilité de réservation");
        setSize(500,500);
        setVisible(true);

        buttonAjouter.setBounds(50, 100, 150, 50);
        buttonSupprimer.setBounds(200, 100, 150, 50);
        //buttonConsulter.setBounds(300, 150, 50, 50);

        add(buttonAjouter);
        add(buttonSupprimer);
        //add(buttonConsulter);

        setVisible(true);
    }

    public static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueChoisirPossibiliteReservation(h1);
    }
}