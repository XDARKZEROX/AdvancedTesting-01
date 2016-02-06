package shop.domain.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import shop.domain.RevisionesProducto;

public class RevisionesProductoTest {
	
	RevisionesProducto revisiones = new RevisionesProducto();
	
	@Test 
	public void testName() throws Exception{
		throw new Exception();
		
		//Arrange
		//Aca se instancia revisioes Producto
		
		//Act
		
		
		//Assert
		
	}
	
	//@Ignore
	@Test
	public void shouldAddProductRevision() {
		int calificacion = 2;
		try {
			revisiones.agregarRevision(calificacion);
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	//@Ignore
	@Test
	public void shouldGetStarsNumber(){
		long stars = 0;
		try {
			stars = revisiones.nroEstrellas();
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	
		Assert.assertEquals(2, stars);
	}
	

}
