package controleur;
import model.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContSupprimerProduitSejour implements ActionListener {
    private VueSupprimerProduitSejour vue;
    private Sejour sejour;
    public ContSupprimerProduitSejour(VueSupprimerProduitSejour vue, Sejour s) {
        this.vue = vue;
        this.sejour = s;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(vue.idProduit.getText());
        Produits a = sejour.getHotel().getProduitsById(id);
        if (a != null) {
            sejour.supprimerProduit(a);
        }
    }
}
