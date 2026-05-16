package controleur;
 
import vue.VueAjoutClient;
import model.Client;
import model.Hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
 
public class ContValiderAjoutClient implements ActionListener {
 
    private Hotel hotel;
    private VueAjoutClient vue;
 
    public ContValiderAjoutClient(Hotel hotel, VueAjoutClient vue) {
        this.hotel = hotel;
        this.vue = vue;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs saisies dans la vue
        String nom = vue.nomClient.getText();
        String prenom = vue.prenomClient.getText();
 
        // Vérification que les champs ne sont pas vides
        if (nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        // Créer le client et l'ajouter à l'hôtel
        Client nouveauClient = new Client(nom, prenom, hotel);
 
        // Confirmation et fermeture
        JOptionPane.showMessageDialog(vue, "Client " + nom + " " + prenom + " ajouté avec succès !");
        vue.dispose();
    }
}
