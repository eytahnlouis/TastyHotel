package controleur;
 
import vue.*;
import model.Client;
import model.Hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
 
public class ContListClient implements ActionListener {
 
    private Hotel hotel;
    private VueRechercheClient vue;
 
    public ContListClient(Hotel hotel, VueRechercheClient vue) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String nom    = vue.nomClient.getText().trim();
        String prenom = vue.prenomClient.getText().trim();
 
        // Vérification que les champs ne sont pas vides
        if (nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Veuillez remplir le nom et le prénom.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        // Recherche dans hotel.getListClient()
        Client clientTrouve = null;
        for (Client c : hotel.getListClient()) {
            if (c.getNomClient().equalsIgnoreCase(nom) && c.getPrenomClient().equalsIgnoreCase(prenom)) {
                clientTrouve = c;
                break;
            }
        }
 
        if (clientTrouve == null) {
            JOptionPane.showMessageDialog(vue, "Aucun client trouvé avec ce nom et prénom.", "Introuvable", JOptionPane.WARNING_MESSAGE);
        } else {
            new VueAfficherClient(clientTrouve);
            vue.dispose();
        }
    }
}
