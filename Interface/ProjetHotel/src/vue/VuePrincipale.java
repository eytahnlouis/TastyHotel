package vue;
import controleur.*;
import java.awt.*;
import javax.swing.*;
import model.Hotel;

public class VuePrincipale extends JFrame {
	
	
	JButton btnHotel = new JButton("Hotel");
	JButton btnSejour = new JButton("Sejours");
	JButton btnReservation = new JButton("Reservations");
	JButton btnClient = new JButton("Clients");
	
	
	Hotel hotel;
	
	public VuePrincipale(Hotel h) {
		hotel = h;
		this.setTitle("Gestion de l'hotel ");
		this.setPreferredSize(new Dimension(400,300));
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(4, 1, 10, 10));
		
		panelBtn.add(btnHotel);
		panelBtn.add(btnSejour);
		panelBtn.add(btnReservation);
		panelBtn.add(btnClient);
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panelBtn, BorderLayout.CENTER);
		
		

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
     // � ajouter � la fin du constructeur de VuePrincipale
        btnHotel.addActionListener(e -> new VueHotel(h));
        btnClient.addActionListener(e -> new VueChoisirPossibilitesClient(h));
        btnReservation.addActionListener(e -> new VueChoisirPossibiliteReservation(h));
        btnSejour.addActionListener(e -> new VueChercherClientSejour(h));
    }

}
	


	


