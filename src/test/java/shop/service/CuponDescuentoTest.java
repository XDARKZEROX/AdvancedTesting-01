package shop.service;

import org.junit.Assert;
import org.junit.Test;

import shop.application.VentasApplicationService;
import shop.services.CuponDescuentoService;

public class CuponDescuentoTest {
	
	CuponDescuentoService cuponDescuentoService = new CuponDescuentoService();
	double costoTotal = 15;
	String nombreCupon = "navidad";
	
	//@Ignore
	@Test
	public void shouldAddProductRevision() {
		double descuentoTotal = 0.0;
		try {
			descuentoTotal = cuponDescuentoService.calcularDescuento(costoTotal, nombreCupon);
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
		System.out.println(descuentoTotal);
		Assert.assertEquals(1.5, descuentoTotal);
		
	}
}
