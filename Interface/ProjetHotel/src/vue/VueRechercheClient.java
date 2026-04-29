package vue;
import model.*;
import javax.swing.*;
import java.awt.*;

public class VueRechercheClient extends VueAjoutClient {
    JTextField idClient = new JTextField(10);
    public VueRechercheClient(Hotel h1) {
        super(h1);
        setTitle("Rechercher un client");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("id :"));
        panelBoutons.add(idClient);
        add(panelBoutons);
        setVisible(true);
    }

    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueRechercheClient(h1);
    }
}
