package controleur;
import model.*;
import vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContSupprimerActivitesSejour implements ActionListener {
    private VueSupprimerActivites vue;
    private Sejour sejour;
    public ContSupprimerActivitesSejour(VueSupprimerActivites vue, Sejour s) {
        this.vue = vue;
        this.sejour = s;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(vue.idProduit.getText());
        Activites a = sejour.getHotel().getActivitesById(id);
        if (a != null) {
            sejour.supprimerActivite(a);
        }
    }
}
