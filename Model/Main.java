public class Main {
    String nomHotel= "Tasty Hotel 4*";
    String adresse= "12 rue de la paix";
    Hotel h = new Hotel(nomHotel, adresse);
    String typeC = "Crousty";
    int numChambre = 1;
    int numEtage = 1;
    float prixChambre = (float)44.99;
    Chambre c = new Chambre(typeC, numChambre, numEtage, prixChambre, h);

    public static void main(String[] args) {
        Main main = new Main();
        main.c.ajouterAHotel();
        main.c.afficherChambre();
        main.h.afficherHotel();

    }
}