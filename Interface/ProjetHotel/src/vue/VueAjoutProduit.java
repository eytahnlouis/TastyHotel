package vue;
import controleur.ContAjoutProduit;
import model.*;
import javax.swing.*;
import java.awt.*;
public class VueAjoutProduit extends JFrame {
    public JTextField idProduit = new JTextField(10);
    public JTextField nomProduit = new JTextField(10);
    public JTextField prixProduit = new JTextField(10);
    public JTextField quantiteProduit = new JTextField(10);
    JButton btnValider = new JButton("Valider");
    JButton btnQuiter = new JButton("Quitter");

    public VueAjoutProduit(Hotel h1) {
        setTitle("Ajouter un client");
        setSize(500,150);
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(new JLabel("Code Barre :"));
        panelBoutons.add(idProduit);
        panelBoutons.add(new JLabel("nom du produit :"));
        panelBoutons.add(nomProduit);
        panelBoutons.add(new JLabel("Prix :"));
        panelBoutons.add(prixProduit);
        panelBoutons.add(new JLabel("Quantité :"));
        panelBoutons.add(quantiteProduit);
        panelBoutons.add(btnValider);
        panelBoutons.add(btnQuiter);

        add(panelBoutons);
        setVisible(true);
        btnQuiter.addActionListener(e -> {
            dispose();
        });

        btnValider.addActionListener(new ContAjoutProduit(this,h1) );
            //contrôleur à ajouter : toi permettre la création d'un produit ajouter l'hotel
            //signature Produits(int numProduit, String nomProduit, float prixProduit, int quantite, Hotel hotel)
    }
    static void main(String[] args) {
        Hotel h1 = new Hotel("Tasty Hotel 4*", "12 rue de la paix");
        new VueAjoutProduit(h1);
    }
}

