package factorDeCancelacionOReactivacionDeApuesta;

import org.junit.Before;
import org.junit.Test;
import apuesta.Apuesta;
import estado.EnJuego;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestFinalizado {
	private EstadoEventoDeportivo finalizado;
	private Apuesta apuesta;
	
		@Before
		public void setUp() {
			apuesta = mock(Apuesta.class);
			finalizado = new EnJuego();
		}
	
		@Test
		public void testSeLePideCancelarALaApuestaYFalla() {
			//Lanza excepcion
		}
		
		@Test
		public void testSeLePideReactivarALaApuestaYFalla() {
			//Lanza excepcion
			//Esto tiene que romper
		}

}
