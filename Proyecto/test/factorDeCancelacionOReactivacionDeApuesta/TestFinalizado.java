package factorDeCancelacionOReactivacionDeApuesta;

import org.junit.Before;
import org.junit.Test;
import apuesta.Apuesta;
import estado.Finalizado;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestFinalizado {
	private Finalizado finalizado;
	private Apuesta apuesta;
	
		@Before
		public void setUp() {
			apuesta = mock(Apuesta.class);
			finalizado = new Finalizado();
		}
	
		@Test
		public void testNoTienePenalizacion() {
			assertEquals(new Float(0), finalizado.penalidad(apuesta));
		}
		
		@Test
		public void testSeLePideCancelarALaApuestaYFalla()throws Exception  {
			//Lanza excepcion
			//Esto tiene que romper
			finalizado.cancelar(apuesta);
			
		}
		
		@Test
		public void testSeLePideReactivarALaApuestaYFalla()throws Exception  {
			//Lanza excepcion
			//Esto tiene que romper
			finalizado.reactivar(apuesta);
		}

}
