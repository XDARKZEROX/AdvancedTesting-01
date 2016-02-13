package solution.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import shop.application.VentasApplicationService;
import shop.data.RevisionDataAccess;
import shop.domain.Revision;

public class VentasApplicationServiceTest {

//	@Ignore
	@Test
	public void agregarRevision_primeraRevision_persisteLaRevision() throws Exception {
//		RevisionDataAccess dataAccess=new RevisionDataAccess();
//		dataAccess.eliminarTodo();
		
		SimpleRevisionDataAccess revisionDataAccess = new SimpleRevisionDataAccess();		
		VentasApplicationService service=new VentasApplicationService(revisionDataAccess);
		
		Revision revision1 = new Revision(1, "JuanCarlos", 5, "que buen libro");
		Revision revision2 = new Revision(1, "Miguel", 5, "que buen libro");
		
		service.agregarRevision(revision1);
		assertEquals(revisionDataAccess.nroGrabado, 1);
		service.agregarRevision(revision2);
		assertEquals(revisionDataAccess.nroGrabado, 2);
		
//		List<Revision> obtenerTodas = dataAccess.obtenerTodos();
//		assertEquals(2,obtenerTodas.size());
	}
	
	class SimpleRevisionDataAccess extends RevisionDataAccess{
		public Revision buscar(int productId, String revisorNombre){
			return null;
		}
		
		public int nroGrabado = 0;
		public void grabar(Revision revision) throws Exception {
			nroGrabado = nroGrabado + 1;
		}
	}
}
