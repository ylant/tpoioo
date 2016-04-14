import java.util.Vector;
import java.util.Date;
public class Factura 
{
	private int nroFactura;
	private String nombreLocal="LA SALADA";
	private String nombreCliente;

	private Date fecha;
	private float precioTotal;
	private Vector<itemFactura>itemfacturas;
	
	public Vector<itemFactura> getItemfacturas() {
		return itemfacturas;
	}


	public void setItemfacturas(Vector<itemFactura> itemfacturas) {
		this.itemfacturas = itemfacturas;
	}


	public Factura(int nroFactura, String fecha, String nombreCliente) 
	{
		super();
		Date fechaactual = new Date();
		this.nroFactura = nroFactura;
		this.nombreCliente = nombreCliente;
		this.fecha = fechaactual;
		itemfacturas = new Vector<itemFactura>();

	}
	
	
	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public int getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	public String getNombreLocal() {
		return nombreLocal;
	}
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	public void incorporarItemFactura(int cantidadComprada, Prenda prenda)
	{
		prenda.setStockPrenda(prenda.getStockPrenda()-cantidadComprada);
		itemFactura itemfactura = new itemFactura(cantidadComprada, prenda);
		this.setPrecioTotal(this.getPrecioTotal()+(cantidadComprada * prenda.getPrecioPrenda()));
		this.itemfacturas.add(itemfactura);
	}

}
