package shop.domain.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import shop.domain.RevisionesProducto;

public class RevisionesProductoTest {
	
	RevisionesProducto revisiones = new RevisionesProducto();
	
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
	
	@Ignore
	@Test
	public void shouldGetStarsNumber(){
		
		try {
			revisiones.nroEstrellas();
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	

}
