import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VentanaOpcionAltaPrenda extends JFrame {
	
	private JButton btnPrendaTemporada;
	private JButton btnPrendaSinTemporada;	
	private JLabel 	lblTituloOpcionPrenda;
	
	private SistemaIndumentaria sistemaIndumentaria;

	public VentanaOpcionAltaPrenda(SistemaIndumentaria sistema) {
		super();
		initGUI();
		sistemaIndumentaria = sistema;
	}

	private void initGUI() {
		
		try {			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			{//texto Titulo
				
				lblTituloOpcionPrenda = new JLabel();
				getContentPane().add(lblTituloOpcionPrenda);
				lblTituloOpcionPrenda.setText("Alta Prenda - Elija una Opción");
				lblTituloOpcionPrenda.setBounds(2, 1, 175, 20);
				
			}
			
			{ //Boton Prenda Temporada
				btnPrendaTemporada = new JButton();		
				getContentPane().add(btnPrendaTemporada);
				btnPrendaTemporada.setText("Prenda de Temporada");
				btnPrendaTemporada.setBounds(100, 80, 180, 28);//(x,y,w,h)
				btnPrendaTemporada.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.exit(0);//Ventana Alta Prenda Temporada 
					}
				});				
			}
			
			{ //Boton Prenda sin Temporada
				btnPrendaSinTemporada = new JButton();		
				getContentPane().add(btnPrendaSinTemporada);
				btnPrendaSinTemporada.setText("Prenda Sin Temporada");
				btnPrendaSinTemporada.setBounds(100, 140, 180, 28);//(x,y,h,w)
				btnPrendaSinTemporada.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.exit(0);//Ventana Alta Prenda Temporada 
					}
				});				
			}
			
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
