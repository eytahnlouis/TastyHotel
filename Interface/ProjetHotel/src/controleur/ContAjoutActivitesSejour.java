package controleur;

import model.*;
import vue.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;

public class ContAjoutActivitesSejour implements ActionListener {
    private VueAjoutActivitesSejour vue;
    private Sejour sejour;

    public ContAjoutActivitesSejour(VueAjoutActivitesSejour vue, Sejour s) {
        this.vue = vue;
        this.sejour = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(vue.nomProduit.getText());
        Activites a = sejour.getHotel().getActivitesById(id);
        if (a != null) {
            sejour.ajouterActivite(a);
        }
    }
}
