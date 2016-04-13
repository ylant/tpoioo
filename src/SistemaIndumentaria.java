import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class SistemaIndumentaria 
{
	private Vector<Prenda>prendas;
	private Vector<Material>materiales;
	private Vector<Proveedor>proveedores;

	
	private void cargaInicial()
	{
		Proveedor proveedor1 = new Proveedor("Cachito SA", 5);
		Proveedor proveedor2 = new Proveedor("Pepito SA", 2);
		proveedores.add(proveedor1);
		proveedores.add(proveedor2);

		Material material1 = new Material(10, "botones", 80, proveedor1, (float) 5.5, 100, 20);
		Material material2 = new Material(20, "algodon", 80, proveedor2, (float) 12.5, 200, 10);
		materiales.add(material1);
		materiales.add(material2);


		PrendaSinTemporada prenda_sin_temporada3 = new PrendaSinTemporada(20, "pantalon1", 10, material1, 20);
		prendas.add(prenda_sin_temporada3);
		
		PrendaSinTemporada prenda_sin_temporada2 = new PrendaSinTemporada(10, "pantalon2", 10, material2, 10);
		prendas.add(prenda_sin_temporada2);
	}
	
	public SistemaIndumentaria()
	{
		prendas = new Vector<Prenda>();
		materiales = new Vector<Material>();
		proveedores = new Vector<Proveedor>();

		cargaInicial();
		
	}
	
	public Prenda AltaPrendaSinTemporada(int codigo, String nombrePrenda, int stock, Material material, int cantMaterial)
	{

		Prenda devolucionPrenda;
		if (material.reducirStock(cantMaterial))
		{
			PrendaSinTemporada prenda_sin_temporada = new PrendaSinTemporada(codigo, nombrePrenda, stock, material, cantMaterial);
			prenda_sin_temporada.calcularPrecio();
			devolucionPrenda = prenda_sin_temporada;
			prendas.add(prenda_sin_temporada);
			material.imprimirCantStock();
		}
		else
		{
			return null;
		}
		return devolucionPrenda;
	}
	
	public Prenda AltaPrendaDeTemporada(int codigo, String nombrePrenda, int stock, Material material, int cantMaterial, String epoca)
	{
		Prenda devolucionPrenda;
		if (material.reducirStock(cantMaterial))
		{
			prendaDeTemporada prenda_de_temporada = new prendaDeTemporada(codigo, nombrePrenda, stock, material, cantMaterial, epoca);
			prenda_de_temporada.calcularPrecio();
			devolucionPrenda = prenda_de_temporada;
			prendas.add(prenda_de_temporada);
			material.imprimirCantStock();
		}
		else
		{
			return null;
		}
		return devolucionPrenda;
	}
	
	
	public Prenda buscarPrenda(int cod)
	{
		System.out.println("Buscando prenda!");

		for (int i=0; i<prendas.size();i++)
		{
			if (prendas.elementAt(i).sosPrenda(cod))
				return prendas.elementAt(i);
		}

		return null;
	}
	
	public Material buscarMaterial(int cod)
	{
		System.out.println("Buscando Material!");

		for (int i=0; i<materiales.size();i++)
		{
			if (materiales.elementAt(i).sosMaterial(cod))
				return materiales.elementAt(i);
		}

		return null;
	}

	public Vector<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(Vector<Prenda> prendas) {
		this.prendas = prendas;
	}
	
	public boolean bajaPrenda(int codigo)
	{
		Prenda prendainstanciada;
		prendainstanciada = this.buscarPrenda(codigo);
		if (prendainstanciada == null)
			return false;
		prendainstanciada.setCodigoPrenda(prendainstanciada.getCodigoPrenda() * -1);
		return true;
	}
	
	
}
