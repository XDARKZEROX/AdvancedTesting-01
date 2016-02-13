package shop.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import shop.data.RevisionDataAccess;
import shop.domain.Revision;

public class VentasApplicationServiceTest {
	
	RevisionDataAccess revisionDataAccess = new RevisionDataAccess();
	VentasApplicationService ventasApplicationService = new VentasApplicationService(revisionDataAccess);
	Revision revision;
	
	@Before
	public void setUp() throws Exception {
		revision = new Revision();
		revision.setCalificacion(20);
		revision.setComentario("Excelente");
		revision.setId(3);
		revision.setProductId(1);
		revision.setRevisorNombre("Alexander");
	}
	
	
	//@Ignore
	//@Test(expected=AssertionError.class)
	@Test
	public void shouldAddProductRevision() {
		Revision revisionBuscada = new Revision();
		
		try {
			RevisionDataAccess revisionDataAccess = new RevisionDataAccess();
			ventasApplicationService.agregarRevision(revision);
			revisionBuscada =  revisionDataAccess.buscar(1, "Alexander");
			
		} catch(Exception e) {
			Assert.fail(e.getMessage());
			Assert.assertTrue(true);
		}
		
		Assert.assertNotNull(revisionBuscada);
	}

}
