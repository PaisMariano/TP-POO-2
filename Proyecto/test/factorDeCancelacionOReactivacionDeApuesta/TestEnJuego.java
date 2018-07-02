package factorDeCancelacionOReactivacionDeApuesta;

import org.junit.Before;
import org.junit.Test;
import apuesta.Apuesta;
import estado.EnJuego;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestEnJuego {
	private EstadoEventoDeportivo enJuego;
	private Apuesta apuesta;
	
		@Before
		public void setUp() {
			apuesta = mock(Apuesta.class);
			enJuego = new EnJuego();
		}
	
		@Test
		public void test() {
			fail("Not yet implemented");
		}

}
