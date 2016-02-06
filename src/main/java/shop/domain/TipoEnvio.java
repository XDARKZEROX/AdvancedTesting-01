package shop.domain;

import java.util.Date;

import shop.util.DateCalculator;
import shop.util.DateFormat;

//Format: https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html

public class TipoEnvio {

	private int diasMinEntrega;
	private int diasMaxEntrega;
	private boolean sonDiasLaborables;
	
	public TipoEnvio(int diasMinEntrega, int diasMaxEntrega, boolean sonDiasLaborables) {
		this.diasMinEntrega = diasMinEntrega;
		this.diasMaxEntrega = diasMaxEntrega;
		this.sonDiasLaborables = sonDiasLaborables;
	}

	public String fechaEntrega(String fechaEnvioTexto) {
		Date fechaMinEntrega = null;
		Date fechaMaxEntrega = null;
		Date fechaEnvio=DateFormat.parse(fechaEnvioTexto);
		if (sonDiasLaborables) {
			fechaMinEntrega = DateCalculator.sumBusinessDays(fechaEnvio,diasMinEntrega);
			fechaMaxEntrega = DateCalculator.sumBusinessDays(fechaEnvio,diasMaxEntrega);
		} else {
			fechaMinEntrega = DateCalculator.sumDays(fechaEnvio,diasMinEntrega);
			fechaMaxEntrega = DateCalculator.sumDays(fechaEnvio,diasMaxEntrega);
		}
		if(diasMinEntrega==diasMaxEntrega){
			return DateFormat.format(fechaMinEntrega);
		}
		return DateFormat.format(fechaMinEntrega) +" - " + DateFormat.format(fechaMaxEntrega);
	}

}
