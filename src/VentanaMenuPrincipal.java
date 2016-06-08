//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.WindowConstants;
//import javax.swing.event.MenuEvent;
//import javax.swing.event.MenuListener;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.Vector;
//
//public class VentanaMenuPrincipal extends javax.swing.JFrame
//{	
//	private static final long serialVersionUID = 1L;
//	private JMenuBar jBarradeMenues;
//	private JMenu jMenuVenderPrendas;
//	private JMenu jMenuPrendas;
//	private JMenuItem jMenuPrendasItemAlta;
//	private JMenuItem jMenuPrendasItemBaja;
//	private JMenuItem jMenuPrendasItemModificacion;
//	private JMenu jMenuListados;
//	private JMenuItem jMenuListadosItemListarPrendas;	
//	private JMenuItem jMenuListadosItemListarOCs;
//	private JMenu jMenuChequearPtoRep;
//	private JMenu jMenuSalir;
//	
//	private SistemaIndumentaria sistemaIndumentaria;
//
//	public static void main(String[] args) 
//	{
//		VentanaMenuPrincipal menuPrincipal = new VentanaMenuPrincipal();
//		menuPrincipal.setVisible(true);
//	}
//	
//	public VentanaMenuPrincipal()
//	{
//		super();
//		initGUI();
//		sistemaIndumentaria = new SistemaIndumentaria();
//	}
//	
//	private void initGUI(){
//		try {
//			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//			{	
//				//instancio y doy formato a la barra
//				jBarradeMenues = new JMenuBar();
//				setJMenuBar(jBarradeMenues);
//				jBarradeMenues.setPreferredSize(new java.awt.Dimension(392, 22));
//				
//				//Instacio y configuro los menues que va a incluir
//				{//Menu - Vender Prendas
//					jMenuVenderPrendas = new JMenu();
//					jBarradeMenues.add(jMenuVenderPrendas);
//					jMenuListados.setText("Vender Prendas");
//					jMenuListados.addMenuListener(new MenuListener() {
//						public void menuSelected(MenuEvent evt) {
//							//Vender prendas
//						}
//						public void menuDeselected(MenuEvent evt) {
//							
//						}
//						public void menuCanceled(MenuEvent evt) {
//							
//						}
//					});
//				}//FIN Menu - Vender Prendas
//				
//				{//Menu - Prendas
//					jMenuPrendas = new JMenu();
//					jBarradeMenues.add(jMenuPrendas);
//					jMenuPrendas.setText("ABM Prendas");
//					jMenuPrendas.setPreferredSize(new java.awt.Dimension(56, 21));
//					jMenuPrendas.addActionListener(new ActionListener(){
//							public void actionPerformed(ActionEvent evt) 
//							{
//								//Solo muestra la lista ABM
//							}//public void actionPerformed(ActionEvent evt)
//						}//new ActionListener()
//					);//addActionListener
//					{
//						jMenuPrendasItemAlta = new JMenuItem();
//						jMenuPrendas.add(jMenuPrendasItemAlta);
//						jMenuPrendasItemAlta.setText("Alta");
//						jMenuPrendasItemAlta.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) 
//							{
////								AltaAlumno a = new AltaAlumno(sistema);
////								a.setVisible(true);
//								
//							}
//						});
//					}
//					{
//						jMenuPrendasItemBaja = new JMenuItem();
//						jMenuPrendas.add(jMenuPrendasItemBaja);
//						jMenuPrendasItemBaja.setText("Modificacion");
//						jMenuPrendasItemBaja.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) 
//							{
////								ModificarAlumno m = new ModificarAlumno(sistema);
////								m.setVisible(true);
//							}
//						});
//					}
//					{
//						jMenuPrendasItemModificacion = new JMenuItem();
//						jMenuPrendas.add(jMenuPrendasItemModificacion);
//						jMenuPrendasItemModificacion.setText("Baja");
//						jMenuPrendasItemModificacion.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) 
//							{
////								EliminarAlumno app = new EliminarAlumno(sistema);
////								app.setVisible(true);
//							}
//						});
//					}
//				}//FIN Menu - ABM Prendas
//				
//				{//Menu - Listados
//					jMenuListados = new JMenu();
//					jBarradeMenues.add(jMenuListados);
//					jMenuListados.setText("Listados");
//					jMenuListados.setPreferredSize(new java.awt.Dimension(56, 21));
//					jMenuListados.addActionListener(new ActionListener(){
//							public void actionPerformed(ActionEvent evt) 
//							{
//							
//							}//public void actionPerformed(ActionEvent evt)
//						}//new ActionListener()
//					);//addActionListener
//					{
//						jMenuListadosItemListarPrendas = new JMenuItem();
//						jMenuListados.add(jMenuListadosItemListarPrendas);
//						jMenuListadosItemListarPrendas.setText("Listar Prendas");
//						jMenuListadosItemListarPrendas.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) 
//							{
//								//Listar prendas
//								//AltaAlumno a = new AltaAlumno(sistema);
//								//a.setVisible(true);								
//							}
//						});
//					}
//					{//Menu - Listar OCs
//						jMenuListadosItemListarOCs = new JMenuItem();
//						jMenuListados.add(jMenuListadosItemListarOCs);
//						jMenuListadosItemListarOCs.setText("Modificacion");
//						jMenuListadosItemListarOCs.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) 
//							{
//								//Listar OC
//							}
//						});
//					}
//				}//FIN Menu - Listados
//				
//				{//Menu - Chequear Ptos. Reposicion
//					jMenuChequearPtoRep = new JMenu();
//					jBarradeMenues.add(jMenuChequearPtoRep);
//					jMenuChequearPtoRep.setText("Chequear Ptos. Repos.");
//					jMenuChequearPtoRep.addMenuListener(new MenuListener() {
//						public void menuSelected(MenuEvent evt) {
//							//Ejecutar Chequear Pto Rep
//						}
//						public void menuDeselected(MenuEvent evt) {
//							
//						}
//						public void menuCanceled(MenuEvent evt) {
//							
//						}
//					});
//				}//FIN Menu - Chequear Ptos. Reposicion
//				
//				{//Menu - Salir
//					jMenuSalir = new JMenu();
//					jBarradeMenues.add(jMenuSalir);
//					jMenuSalir.setText("Salir");
//					jMenuSalir.addMenuListener(new MenuListener() {
//						public void menuSelected(MenuEvent evt) {
//							System.exit(0);
//						}
//						public void menuDeselected(MenuEvent evt) {
//							
//						}
//						public void menuCanceled(MenuEvent evt) {
//							
//						}
//					});
//				}
//			}
//			pack();
//			setSize(400, 300);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} //Try - Catch		
//		
//	}//private void initGUI()	
//} //public class VentanaMenuPrincipal extends javax.swing.JFrame
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;


public class VentanaMenuPrincipal extends javax.swing.JFrame {
	/**
	 * 
	 */

	private JMenuBar jBarradeMenues2;
	private JMenu jMenu1;
	private JMenuItem jMenuItem1;
	private JMenu jMenu2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;

	private static final long serialVersionUID = 1L;
	private JMenuBar jBarradeMenues;
	private JMenu jMenuVenderPrendas;
	private JMenu jMenuPrendas;
	private JMenuItem jMenuPrendasItemAlta;
	private JMenuItem jMenuPrendasItemBaja;
	private JMenuItem jMenuPrendasItemModificacion;
	private JMenu jMenuListados;
	private JMenuItem jMenuListadosItemListarPrendas;	
	private JMenuItem jMenuListadosItemListarOCs;
	private JMenu jMenuChequearPtoRep;
	private JMenu jMenuSalir;	
	
	private SistemaIndumentaria sistemaIndumentaria;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		VentanaMenuPrincipal ventanaPpal = new VentanaMenuPrincipal();
		ventanaPpal.setVisible(true);
	}
	
	public VentanaMenuPrincipal() {
		super();
		initGUI();
		sistemaIndumentaria = new SistemaIndumentaria();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jBarradeMenues = new JMenuBar();
				setJMenuBar(jBarradeMenues);
				jBarradeMenues.setPreferredSize(new java.awt.Dimension(392, 22));
				{					
					{//Menu - Vender Prendas
					jMenuVenderPrendas = new JMenu();
					jBarradeMenues.add(jMenuVenderPrendas);
					jMenuVenderPrendas.setText("Vender Prendas");
					jMenuVenderPrendas.addMenuListener(new MenuListener() {
							public void menuSelected(MenuEvent evt) {
								//Vender prendas
							}
							public void menuDeselected(MenuEvent evt) {
								
							}
							public void menuCanceled(MenuEvent evt) {
								
							}
						});
					}//FIN Menu - Vender Prendas
					
					
					
					
					
					
					
					
					
					jMenu1 = new JMenu();
					jBarradeMenues.add(jMenu1);
					jMenu1.setText("Alumnos");
					jMenu1.setPreferredSize(new java.awt.Dimension(56, 21));
					jMenu1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{
							
						}
					});
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Alta");
						jMenuItem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
//								AltaAlumno a = new AltaAlumno(sistema);
//								a.setVisible(true);
								
							}
						});
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("Modificacion");
						jMenuItem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
//								ModificarAlumno m = new ModificarAlumno(sistema);
//								m.setVisible(true);
							}
						});
					}
					{
						jMenuItem3 = new JMenuItem();
						jMenu1.add(jMenuItem3);
						jMenuItem3.setText("Baja");
						jMenuItem3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
//								EliminarAlumno app = new EliminarAlumno(sistema);
//								app.setVisible(true);
							}
						});
					}
				}
				{
					jMenu2 = new JMenu();
					jBarradeMenues.add(jMenu2);
					jMenu2.setText("Salir");
					jMenu2.addMenuListener(new MenuListener() {
						public void menuSelected(MenuEvent evt) {
							System.exit(0);
						}
						public void menuDeselected(MenuEvent evt) {
							
						}
						public void menuCanceled(MenuEvent evt) {
							
						}
					});
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
