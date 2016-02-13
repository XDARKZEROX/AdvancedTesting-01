package shop.domain;

public class Revision {

	private int id;
	private int productId;
	private String revisorNombre;
	private String comentario;
	private int calificacion;

	public Revision(){}
	public Revision(int productId, String revisorNombre, int calificacion, String comentario) {
				this.productId = productId;
				this.revisorNombre = revisorNombre;
				this.comentario = comentario;
				this.calificacion = calificacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getRevisorNombre() {
		return revisorNombre;
	}

	public void setRevisorNombre(String revisorNombre) {
		this.revisorNombre = revisorNombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
}
