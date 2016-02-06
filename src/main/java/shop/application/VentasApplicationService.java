package shop.application;

import shop.data.OrdenDataAccess;
import shop.domain.DetalleEnvio;
import shop.domain.OrdenCompra;
import shop.domain.Producto;
import shop.services.CostoEnvioService;
import shop.services.CuponDescuentoService;

public class VentasApplicationService {

	OrdenDataAccess ordenDataAccess;
	public VentasApplicationService(){
		this.ordenDataAccess=new OrdenDataAccess();
	}

	public void agregarProductoAOrden(OrdenCompra orden, Producto producto) throws Exception {
		orden.agregarProducto(producto);
		ordenDataAccess.grabar(orden);
	}
	
	public void aplicarCupon(OrdenCompra orden, String cupon) throws Exception {
		CuponDescuentoService cuponService = new CuponDescuentoService();
		double descuento=cuponService.calcularDescuento(orden.getTotal(), cupon);
		orden.aplicarDescuento(descuento);
		ordenDataAccess.grabar(orden);
	}
	
	public void establecerFormaDeEnvio(OrdenCompra orden, DetalleEnvio envioDetalle) throws Exception {
		CostoEnvioService costoEnvioService = new CostoEnvioService();
		double costoEnvio=costoEnvioService.calcular(orden,envioDetalle);
		orden.agregarEnvio(costoEnvio);
		ordenDataAccess.grabar(orden);
	}

	public void aprobarOrden(OrdenCompra orden) throws Exception {
		if (orden.getNumeroProductos() > 100)
			throw new IllegalStateException("Orden invalida");
		orden.ingresarOrden();
		ordenDataAccess.grabar(orden);
	}
}
