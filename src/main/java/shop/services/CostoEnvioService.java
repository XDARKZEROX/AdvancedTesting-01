package shop.services;

import shop.data.CostoPaisDataAccess;
import shop.domain.DetalleEnvio;
import shop.domain.OrdenCompra;

public class CostoEnvioService {

	public double calcular(OrdenCompra orden, DetalleEnvio envioDetalle) {
		CostoPaisDataAccess costoPaisDataAccess = new CostoPaisDataAccess();
		if (envioDetalle.getTipoEnvio() == "FREE") {
			return 0;
		}
		if (envioDetalle.getTipoEnvio() == "ESTANDAR") {
			if (orden.getSubtotal() >= 100 && envioDetalle.getPais() == "USA") {
				return 0;
			} else {
				return costoPaisDataAccess.obtenerCostoEnvio(envioDetalle.getPais());
			}
		}
		if (envioDetalle.getTipoEnvio() == "URGENTE") {
			double costoPais = costoPaisDataAccess.obtenerCostoEnvio(envioDetalle
					.getPais());
			return costoPais * 1.2;
		}
		throw new IllegalStateException("Tipo Envio inválido");
	}
}
