package vue;
import javax.swing.*;
import java.awt.*;
import model.Hotel;
public class VueAjoutClient extends JFrame{
	JButton AjoutClient = new JButton("Ajouter un client");
	JTextField valnom;
	JTextField valprenom;
	JTextField valdate;
	JLabel affnom;
	JLabel affprenom;
	JLabel affdate;
	Hotel hotel;
	
	public VueAjoutClient(Hotel h) {
		hotel = h;
		this.setTitle(hotel.nomHotel);
		this.setPreferredSize(new Dimension(300,200));
		
		valnom = new JTextField();
		valprenom = new JTextField();
		valdate = new JTextField();
		
		affnom = new JLabel("nom: ");
		affprenom = new JLabel("prenom: ");
		affdate = new JLabel("date: ");
		
		JPanel aff = new JPanel();
		aff.setLayout(new GridLayout(2,2));
		aff.add(affnom);
		aff.add(valnom);
		aff.add(affprenom);
		aff.add(valprenom);
		aff.add(affdate);
		aff.add(valdate);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(aff,BorderLayout.CENTER);
		this.getContentPane().add(AjoutClient,BorderLayout.SOUTH);
		
		
	}
	
	
	

}
