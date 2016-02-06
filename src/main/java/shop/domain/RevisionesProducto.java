package shop.domain;

import java.util.ArrayList;
import java.util.List;

public class RevisionesProducto {
	List<Integer> calificaciones = new ArrayList<Integer>();
	
	public void agregarRevision(int calificacion) {
		calificaciones.add(calificacion);
	}

	public long nroEstrellas() {
		return Math.round(promedio());
	}

	public double promedio() {
		int suma = 0;
		for (Integer revision : calificaciones) {
			suma += revision;
		}
		return suma / calificaciones.size();
	}
	
	public int nroCalificaciones() {
		return calificaciones.size();
	}
}