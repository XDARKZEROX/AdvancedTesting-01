package shop.services;

import shop.data.CuponDataAccess;

public class CuponDescuentoService {
	
	CuponDataAccess cuponDataAccess;
	public CuponDescuentoService(CuponDataAccess cuponDataAccess){
		this.cuponDataAccess = cuponDataAccess;
	}

	public double calcularDescuento(double costoTotal, String cupon) throws Exception {
		//CuponDataAccess cuponDataAccess=new CuponDataAccess();
		
		int discountPercentage = 0;
		if (cupon != null) {
			discountPercentage = cuponDataAccess.obtenerPorcentajeDescuento(cupon);
		}
		return costoTotal * discountPercentage / 100;
	}
	
}
