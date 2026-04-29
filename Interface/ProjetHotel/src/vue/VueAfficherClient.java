package vue;
import javax.swing.*;
import model.*;
import java.awt.*;
public class VueAfficherClient extends JFrame {
     JLabel idClient=new JLabel("id :");
     JLabel nomClient=new JLabel("nom :");
     JLabel prenomClient=new JLabel("prenom :");
     JLabel isFaithfulClient=new JLabel("client fidèle :");
     JLabel compteReservation=new JLabel("nombre de réservations :");

        public VueAfficherClient(Client c){
            setTitle("Afficher les informations d'un client");
            setSize(500,150);
            JPanel panelBoutons = new JPanel(new FlowLayout());


            panelBoutons.add(new JLabel("id :" + c.getNomClient()));
            panelBoutons.add(new  JLabel("nom :" + c.getPrenomClient()));
            panelBoutons.add(new JLabel("prenom : " + c.getPrenomClient()));
            panelBoutons.add(new JLabel("client fidèle : " + c.isFaithful()));
            panelBoutons.add(new JLabel("nombre de réservations : " + c.comptePassage));
            add(panelBoutons);
            setVisible(true);
        }

    public static void main(String[] args) {
            Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
            Client c1 = new Client("Smith", "John", h1);
            new VueAfficherClient(c1);
    }
}
