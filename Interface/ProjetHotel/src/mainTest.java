
import model.Hotel;
import vue.VuePrincipale;
 

public class mainTest{
    public static void main(String[] args) {
        Hotel h = new Hotel("Tasty Hotel 4*", "12 rue de la paix");

        new VuePrincipale(h);
    }
}