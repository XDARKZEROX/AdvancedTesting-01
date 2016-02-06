package shop.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenCompra {

	private String id;
	private String estado;
	private double subtotal;
	private double costoEnvio;
	private double descuento;
	private double total;

	public OrdenCompra() {
		this.subtotal = 0;
		this.costoEnvio = 0;
		this.descuento = 0;
		this.total = 0;
		this.estado = "borrador";
	}

	private List<LineaOrden> lineas = new ArrayList<LineaOrden>();

	public void agregarProducto(Producto producto) {
		LineaOrden linea = this.buscarLinea(producto.getId());

		if (linea == null) {
			this.lineas.add(new LineaOrden(producto, 1));
		} else {
			linea.incrementarCantidad(1);
		}
		
		recalcularSubTotal();
		recalcularTotal();
	}

	public void removerLinea(int productoId) {
		LineaOrden linea = buscarLinea(productoId);
		if (linea == null)
			throw new IllegalStateException("No existe el producto");
		this.lineas.remove(linea);

		recalcularSubTotal();
		recalcularTotal();
	}

	private void recalcularSubTotal() {
		subtotal = 0;
		for (LineaOrden linea : lineas) {
			subtotal += linea.total();
		}
	}

	private void recalcularTotal() {
		this.total = this.subtotal + this.costoEnvio - this.descuento;
	}
	
	public int getNumeroLineas() {
		return this.lineas.size();
	}
	
	public int getNumeroProductos() {
		int numeroProductos = 0;
		for (LineaOrden linea : lineas) {
			numeroProductos += linea.getCantidad();
		}
		return numeroProductos;
	}
	
	public void aplicarDescuento(double descuento){
		this.descuento=descuento;
		recalcularTotal();
	}
	
	public void agregarEnvio(double costoEnvio){
		this.costoEnvio=costoEnvio;
		recalcularTotal();
	}
	
	public void ingresarOrden() {
		this.estado = "ingresado";
	}

	private LineaOrden buscarLinea(int productoId) {
		for (LineaOrden linea : lineas) {
			if (linea.contieneProducto(productoId)) {
				return linea;
			}
		}
		return null;
	}
	
	public List<LineaOrden> getLineas() {
		return Collections.unmodifiableList(this.lineas);
	}
	
	public String getEstado() {
		return estado;
	}

	public String getCostoEnvio() {
		return estado;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public double getTotal() {
		return total;
	}
	
	public String getId() {
		return id;
	}
}
