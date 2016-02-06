package shop.domain;

public class DetalleEnvio {

	private String tipoEnvio;
	private String pais;
	
	public DetalleEnvio(String tipoEnvio,String pais){
		this.tipoEnvio = tipoEnvio;
		this.pais = pais;
	}
	
	public String getTipoEnvio() {
		return tipoEnvio;
	}
	public String getPais() {
		return pais;
	}
}
