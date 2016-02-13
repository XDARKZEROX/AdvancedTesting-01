package shop.domain;

public class Producto {
	
	private int id;
	private double precio;
	
	public RevisionesProducto revisiones=new RevisionesProducto();
	
	public Producto(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
