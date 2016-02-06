package shop.domain;

public class LineaOrden {
	private Producto producto;
	private int cantidad;

	public LineaOrden(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public double total() {
		return this.producto.getPrecio() * this.getCantidad();
	}

	public boolean contieneProducto(int productoId){
		return this.producto.getId() == productoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void incrementarCantidad(int incremento) {
		this.cantidad += incremento;
	}
}
