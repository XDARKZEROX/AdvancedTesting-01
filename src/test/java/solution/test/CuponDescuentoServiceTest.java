package solution.test;

import org.junit.Assert;
import org.junit.Test;

import shop.data.CuponDataAccess;
import shop.services.CuponDescuentoService;

public class CuponDescuentoServiceTest {
	@Test
	public void calcularDescuento_cuponExistente_calcula() throws Exception {
		SimpleCuponDataAccess cuponDataAccess = new SimpleCuponDataAccess();
		cuponDataAccess.descuento=20;
		CuponDescuentoService cuponDescuentoService = new CuponDescuentoService(cuponDataAccess);
		
		double descuento = cuponDescuentoService.calcularDescuento(100, "navidad");
		
		Assert.assertEquals(20,descuento,0);
	}
	
	class SimpleCuponDataAccess extends CuponDataAccess {
		public int descuento;
		public int obtenerPorcentajeDescuento(String cupon){
			return descuento;
		}
	}
	
}
