package shop.domain.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import shop.domain.OrdenCompra;
import shop.domain.Producto;


public class OrdenCompraTest {
	OrdenCompra ordenCompra;
	Producto producto;
	
	
	@Before
	public void setUp() throws Exception {
		ordenCompra = new OrdenCompra();
		producto = new Producto(2);
		producto.setPrecio(15);
		
	}
	
	//@Ignore
	@Test
	public void shouldAddProduct(){
		
		try {
			ordenCompra.agregarProducto(producto);
		} catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	
	//@Ignore
	@Test
	public void shouldDeleteProduct(){
		
		try {
			ordenCompra.agregarProducto(producto);
			ordenCompra.removerLinea(2);
		} catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void shouldRecalculateSubtotal(){
		
		try {
			
		
		} catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	
	//Falta

}
