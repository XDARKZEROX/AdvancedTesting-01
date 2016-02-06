package shop.domain.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import shop.domain.TipoEnvio;

public class TipoEnvioTest {
	
	/*
	 * Prueba 1:
	 * Hoy: 6 de Febrero
	 * Dias min: 3
	 * Dias max: 3
	 * Dias laborables: true
	 * Fecha de entrega; 10 de Febrero 
	 * 
	 * Prueba 2:
	 * Hoy: 6 de febrero
	 * Dias min: 3
	 * Dias max: 3
	 * Dias laborables: false
	 * Fecha de entrega; 9 de Febrero 
	 * 
	 * Prueba 3:
	 * Hoy: 6 de febrero
	 * Dias min: 3
	 * Dias max: 4
	 * Dias laborables: false
	 * Fecha de entrega; 9 al 10 Feb
	 * 
	 *  API: fechaEntrega('Feb. 6') = 'Feb.9'
	 * 
	 */
	
	//@Ignore
	@Test
	public void shouldGetDeliveryDate() throws Exception{
		String deliveryDate = "";
		String fechaEntrega = "Feb. 6, 2016";
		
		try {
			TipoEnvio tipoEnvio = new TipoEnvio(3, 3, true);
			deliveryDate = tipoEnvio.fechaEntrega(fechaEntrega);
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
		System.out.println(deliveryDate);
		Assert.assertNotNull(deliveryDate);
	}
	
	
	

}
