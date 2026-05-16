package controleur;
import model.*;
import vue.*;
import java.awt.event.*;
import java.time.LocalDate;

public class ContModifierDateFinSejour implements ActionListener {
    private Sejour sejour;
    private VueModifierDateFin vue;
    public ContModifierDateFinSejour(VueModifierDateFin vue, Sejour s) {
        this.vue = vue;
        this.sejour = s;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int jour = Integer.parseInt(vue.jour.getText());
        int mois = Integer.parseInt(vue.mois.getText());
        int annee = Integer.parseInt(vue.annee.getText());
        LocalDate dateFin = LocalDate.of(annee, mois, jour);
        sejour.setDateFinReel(dateFin);
        vue.dispose();
    }
}
