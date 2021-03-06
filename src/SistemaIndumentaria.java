import java.util.Vector;

public class SistemaIndumentaria 
{
	private Vector<Prenda>prendas;
	private Vector<Material>materiales;
	private Vector<Proveedor>proveedores;
	private Vector<Material>materialesAPedir;
	private Vector<ordenDeCompra>ordenesDeCompra;
	private Vector<Factura>facturas;
	
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

		Prenda prenda_sin_temporada3 = this.AltaPrendaSinTemporada(20, "pantalon1", 10, material1, 65);
		prenda_sin_temporada3.setPrecioPrenda(200);
		ControlarStockMateriales();
	//	prendas.add(prenda_sin_temporada3); el metodo altaprendasintemporada ya realiza un add
		
		Prenda prenda_sin_temporada2 = this.AltaPrendaSinTemporada(10, "pantalon2", 10, material2, 75);
		prenda_sin_temporada2.setPrecioPrenda(400);

	//	prendas.add(prenda_sin_temporada2); el metodo altaprendasintemporada ya realiza un add
	}
	
	public SistemaIndumentaria()
	{
		prendas = new Vector<Prenda>();
		materiales = new Vector<Material>();
		proveedores = new Vector<Proveedor>();
		materialesAPedir = new Vector<Material>();
		ordenesDeCompra = new Vector<ordenDeCompra>();
		facturas = new Vector<Factura>();
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
	
	public void ControlarStockMateriales()
	{
		for (int i = 0; i < materiales.size(); i++) {
			Material mat = materiales.elementAt(i);
			if(mat.getCantStock() <= mat.getPuntoDeReposicion())
			{
				materialesAPedir.add(mat);
			}
		}
		if(materialesAPedir.size()>0)
		{
			Vector<Material>aux;
			aux = new Vector<Material>();
			aux.add(materialesAPedir.elementAt(0));
			materialesAPedir.removeElementAt(0);
			int count = 0;
			while(aux.size() > 0)
			{
				for (int i = 0; i < materialesAPedir.size(); i++)
				{
					Material mat = materialesAPedir.elementAt(i);
					if(mat.getProveedor().getCodigoProveedor() == aux.elementAt(0).getProveedor().getCodigoProveedor())
					{
						aux.add(mat);
						materialesAPedir.removeElementAt(i);
						i--;
					}
				}
				// Crear Orden de compra
				this.generarOrdenDeCompra(aux);
				count++;
				aux.removeAllElements();
				if(materialesAPedir.size() > 0)
				{
					aux.add(materialesAPedir.elementAt(0));
					materialesAPedir.removeElementAt(0);
				}
			}
			System.out.println("Se generaron: "+count+" ordenes de compras");
		}
	}
	
	public void generarOrdenDeCompra(Vector<Material> materiales)
	{
		Vector<itemOC>itemocs;
		itemocs = new Vector<itemOC>();
		for (int i = 0; i < materiales.size(); i++) {
			Material mat = materiales.elementAt(i);
			itemOC itemOc = new itemOC(mat, mat.getCantidadAPedir());
			itemocs.add(itemOc);
		}
		// El codigo de la orden de compra (ordenesDeCompra.size()) ira aumentando 1,2,3.. secuencialmente.
		ordenDeCompra orden = new ordenDeCompra(ordenesDeCompra.size()+1, "Hoy",itemocs);
		ordenesDeCompra.add(orden);
	}
	
	public void ListarOrdenesDeCompra() {
		// Faltaria chequear si las ordenes de compra son del mismo proveedor
		if(ordenesDeCompra.size() > 0)
		{
			System.out.println("Ordenes de compras:");
			for (int i = 0; i < ordenesDeCompra.size(); i++) {
				ordenDeCompra orden = ordenesDeCompra.elementAt(i);
				Vector<itemOC> items = orden.getItemsOCs();
				System.out.println("------------------");
				System.out.println("Fecha: "+orden.getFechaOC());
				System.out.println("Codigo: "+orden.getCodigoOC());
				System.out.println("Materiales a pedir:");
				for (int j = 0; j < items.size(); j++) {
					itemOC item = items.elementAt(j);
					System.out.println("  ----------------");
					System.out.println(" - Nombre: "+item.getMaterial().getNombreMaterial());
					System.out.println(" - Cantidad: "+item.getCantPedir());
					System.out.println("  ----------------");
				}
				System.out.println("Proveedor: "+orden.getNombreProveedor());
				System.out.println("TOTAL: "+orden.getTotalOC());
				System.out.println("------------------");
			}
		}
		else
		{
			System.out.println("No hay ordenes de compra");
		}
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
	
	//Nuevo CAGUIRRE
	public Vector<Material> getMateriales() {
		return materiales;
	}	
	
	
	public void setPrendas(Vector<Prenda> prendas) {
		this.prendas = prendas;
	}
	
	public int generarFactura(int numeroCliente, String nombreCliente)
	{
		int numeroFactura = facturas.size()+1;
		Factura nuevaFactura = new Factura(numeroFactura, numeroCliente, nombreCliente);
		facturas.add(nuevaFactura);
		return nuevaFactura.getNroFactura();
	}

	public Factura buscarFactura(int numFactura){
		if(facturas.size() > 0){
			for (int i = 0; i < facturas.size(); i++) {
				if(numFactura == facturas.elementAt(i).getNroFactura()){
					return facturas.elementAt(i);
				}
			}
		}
		return null;
	}
	
	public void eliminarFactura(Factura factura){
		if(facturas.size()>0){
			int nroFac = factura.getNroFactura();
			for (int i = 0; i < facturas.size(); i++) {
				if(nroFac == facturas.elementAt(i).getNroFactura()){
					facturas.removeElementAt(i);
					break;
				}
			}
		}
	}
	
	public void agregarPrenda(int codfac, int codPrenda, int cantidad) {
		Factura fac = buscarFactura(codfac);
		Prenda prenda = buscarPrenda(codPrenda);
		fac.incorporarItemFactura(cantidad, prenda);
	}
	
	public boolean bajaPrenda(int codigo)
	{
		Prenda prendainstanciada;
		prendainstanciada = this.buscarPrenda(codigo);
		if (prendainstanciada == null)
			return false;
		//prendainstanciada.setCodigoPrenda(prendainstanciada.getCodigoPrenda() * -1);
		prendainstanciada.baja();
		return true;
	}
	
	public void modificarPrenda(){
		
	}
	
	public Vector<Vector> getOC() 
	{
		
		 Vector<Vector> filas = new Vector<Vector>();
		 Vector<String> titulo = new Vector<String>();
		 String codigot = "Codigo:";
		 String fechat = "Fecha:";
		 String totalt = "Total:";
		 String proveedort = "Proveedor:";
		titulo.add(codigot);
		titulo.add(fechat);
		titulo.add(totalt);
		titulo.add(proveedort);
		filas.add(titulo);
		 for (int i = 0; i < ordenesDeCompra.size(); i++) {
				ordenDeCompra ordenDecompra = ordenesDeCompra.elementAt(i);
				int codigo = ordenDecompra.getCodigoOC();
				String fecha = ordenDecompra.getFechaOC();
				float total = ordenDecompra.getTotalOC();
				String proveedor = ordenDecompra.getNombreProveedor();
				Vector<String> aux = new Vector<String>();
				aux.add(Integer.toString(codigo));
				aux.add(fecha);
				aux.add(Float.toString(total));
				aux.add(proveedor);
				filas.add(aux);
		
				
			}
	
		
	
		return filas;
	}
}
