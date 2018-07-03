package estado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFinalizado {
	private EstadoEventoDeportivo finalizado;
	
		@Before
		public void setUp() {
			finalizado = new Finalizado();
		}
		
		@Test
		public void testEstaEmpezado() {
			assertFalse(finalizado.estaEmpezado());
		}
	
		@Test
		public void testEstaFinalizado() {
			assertTrue(finalizado.estaFinalizado());
		}

}
