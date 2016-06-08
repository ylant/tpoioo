import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VentanaAltaPrenda extends JFrame {

	private JComboBox<String> cmbTemporada;
	private JComboBox<String> cmbMaterial;
	
	private JLabel lblTituloPantalla;
	private JLabel lblCodigo;
	private JLabel lblTemporada;		
	private JLabel lblNombre;
	private JLabel lblStock;
	private JLabel lblMaterial;
	private JLabel lblCantMat;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAgregar;
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtStock;
	private JTextField txtCantMat;
	
	private boolean bPrendaDeTemporada;
	
	private SistemaIndumentaria sistemaIndumentaria;
	private Vector<Material> materiales;
	private Vector<String> nombreMateriales;
	
	public VentanaAltaPrenda(SistemaIndumentaria sistema, boolean bEsdeTemporada){
		
		super();
		cargaComboMateriales();
		initGUI();
		sistemaIndumentaria = sistema;
		bPrendaDeTemporada 	= bEsdeTemporada;
		materiales = sistemaIndumentaria.getMateriales();
	}
	
	private void cargaComboMateriales() {
		// TODO Auto-generated method stub		
		
		for(int i=0;i<materiales.size();i++){
			
		 	nombreMateriales.addElement(materiales.elementAt(i).getNombreMaterial());						
		}
		
		if (nombreMateriales.size() > 0){
			
			cmbMaterial = new JComboBox<String>(nombreMateriales);
		}
			
	}

	private void initGUI(){				
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			{//texto Titulo
				
				lblTituloPantalla = new JLabel();
				getContentPane().add(lblTituloPantalla);
				lblTituloPantalla.setText("Alta Prenda Sin Temporada");
				
				if(bPrendaDeTemporada == true)
				{
					lblTituloPantalla.setText("Alta Prenda Temporada");					
				} //if(bPrendaDeTemporada)	
				
				lblTituloPantalla.setBounds(2, 1, 175, 20);				
			}
			//Codigo
			{ 
				lblCodigo = new JLabel();
				getContentPane().add(lblCodigo);
				lblCodigo.setText("Código: ");
				lblCodigo.setBounds(10,30, 80, 20);
			}						
			{
				txtCodigo = new JTextField();
				getContentPane().add(txtCodigo);
				txtCodigo.setBounds(70, 28, 60, 20);
			}		
			
			//Nombre
			{ 
				lblNombre= new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Nombre: ");
				lblNombre.setBounds(10,68, 80, 20);
			}			
			
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(70, 66, 250, 20);
			}	
			
			//Stock
			{ 
				lblStock= new JLabel();
				getContentPane().add(lblStock);
				lblStock.setText("Stock: ");
				lblStock.setBounds(10,106, 80, 20);
			}			
			
			{
				txtStock = new JTextField();
				getContentPane().add(txtStock);
				txtStock.setBounds(70,104, 60, 20);
			}
			
			//Stock
			{ 
				lblMaterial= new JLabel();
				getContentPane().add(lblMaterial);
				lblMaterial.setText("Material: ");
				lblMaterial.setBounds(10,134, 80, 20);
			}			
			
			{	
												
				getContentPane().add(cmbMaterial);
				cmbMaterial.setBounds(70,132, 180, 20);	
			}			
//			{ //lbltemporada
//				lblTemporada = new JLabel();
//				getContentPane().add(lblTemporada);
//				lblTemporada.setText("Temporada");
//				lblTemporada.setBounds(100,100, 80, 20);
//			}
//			
//			{ //lbltemporada
//				lblTemporada = new JLabel();
//				getContentPane().add(lblTemporada);
//				lblTemporada.setText("Temporada");
//				lblTemporada.setBounds(100,100, 80, 20);
//			}
//
//			{ //lbltemporada
//				lblTemporada = new JLabel();
//				getContentPane().add(lblTemporada);
//				lblTemporada.setText("Temporada");
//				lblTemporada.setBounds(100,100, 80, 20);
//			}
			
			{ //lbltemporada
				lblTemporada = new JLabel();
				getContentPane().add(lblTemporada);
				lblTemporada.setText("Temporada");
				lblTemporada.setBounds(100,100, 80, 20);
			}
			
			{//ComboBox de Temporadas
				
				cmbTemporada = new JComboBox<String>();
				getContentPane().add(cmbTemporada);
				cmbTemporada.setBounds(200,100, 80, 20);
				
				// add items to the combo box
				cmbTemporada.addItem("Verano");
				cmbTemporada.addItem("Otoño");
				cmbTemporada.addItem("Invierno");
				cmbTemporada.addItem("Primavera");				
			}
			
			pack();
			setSize(800, 800);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
	}
	
}


//// create an empty combo box with items of type String
//JComboBox<String> comboLanguage = new JComboBox<String>();
// 
//// add items to the combo box
//comboLanguage.addItem("English");
//comboLanguage.addItem("French");
//comboLanguage.addItem("Spanish");
//comboLanguage.addItem("Japanese");
//comboLanguage.addItem("Chinese");
