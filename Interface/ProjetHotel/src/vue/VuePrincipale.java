package vue;
import javax.swing.*;
import model.Hotel;
import java.awt.*;
import controleur.*;

public class VuePrincipale extends JFrame {
	JLabel affNom;
	JLabel affAdresse;
	JTextField valNom;
	JTextField valAdresse;
	
	JButton ouvrir;
	
	
	Hotel hotel;
	
	public VuePrincipale(Hotel h) {
		hotel = h;
		this.setTitle("Gestion d'hotel ");
		this.setPreferredSize(new Dimension(300,150));
		
		affNom = new JLabel("Nom de l'hotel :");
		affAdresse = new JLabel("Adresse de l'hotel :");
		valNom =  new JTextField();
		valAdresse = new JTextField();
		ouvrir = new JButton("valider");
		
		JPanel formulaire = new JPanel(new GridLayout(2,2,8,8));
		formulaire.add(affNom);
		formulaire.add(valNom);
		formulaire.add(affAdresse);
		formulaire.add(valAdresse);
				
		
		JPanel panelBtn = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panelBtn.add(ouvrir);
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(formulaire, BorderLayout.CENTER);
		this.getContentPane().add(panelBtn, BorderLayout.SOUTH);
		
		ouvrir.addActionListener(new ContCreerHotel());
		 
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}


	

}
