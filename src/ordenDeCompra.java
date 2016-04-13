import java.util.Vector;

public class ordenDeCompra {
	
	
	private int codigoOC;
	private String fechaOC;
	private float totalOC;
	private Vector<itemOC>itemsOCs;
	private Proveedor nombreProveedor;
	
	public 	ordenDeCompra(int codigoOC, String fechaOC, float precioUnitarioOC, 
			float totalOC, String nombreProveedor, int cantidad, Material material) 
	{
		super();
		
		itemsOCs 		= new Vector<itemOC>();
		itemOC itempOCs = new itemOC(material, cantidad);
		
		this.codigoOC 			= codigoOC;
		this.fechaOC 			= fechaOC;
		this.totalOC 			= totalOC;
		itemsOCs.add(itempOCs);
	}	
	
	public int getCodigoOC() {
		return codigoOC;
	}
	public void setCodigoOC(int codigoOC) {
		this.codigoOC = codigoOC;
	}
	public Vector<itemOC> getItemsOCs() {
		return itemsOCs;
	}
	public void setItemsOCs(Vector<itemOC> itemsOCs) {
		this.itemsOCs = itemsOCs;
	}
	public String getFechaOC() {
		return fechaOC;
	}
	public void setFechaOC(String fechaOC) {
		this.fechaOC = fechaOC;
	}

	public float getTotalOC() {
		return totalOC;
	}
	public void setTotalOC(float totalOC) {
		this.totalOC = totalOC;
	}

	public Proveedor getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(Proveedor nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	public void calcularPrecioTotal()
	{
		float total = 0;
		for (int i=0; i<itemsOCs.size();i++)
		{
			total = total + (itemsOCs.elementAt(i).getCantPedir() * itemsOCs.elementAt(i).getMaterial().getCosto());
		}
		System.out.println("El valor total de la OC es: " + total);
		this.totalOC = total;	
	}

	public void incorporarItemOC(int cantPedir, Material material){
		
		itemOC itemOC = new itemOC(material, cantPedir);	
		this.itemsOCs.addElement(itemOC);	
		
	}
	
	public boolean sosOC(int codigo){
		return codigo == codigoOC;
	}
		
}
