package estado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestNoComenzado {
	private EstadoEventoDeportivo noComenzado;
	
		@Before
		public void setUp() {
			noComenzado = new NoComenzado();
		}
		
		@Test
		public void testEstaEmpezado() {
			assertFalse(noComenzado.estaEmpezado());
		}
	
		@Test
		public void testEstaFinalizado() {
			assertFalse(noComenzado.estaFinalizado());
		}

}