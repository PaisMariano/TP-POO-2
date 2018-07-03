package factorDeCancelacionOReactivacionDeApuesta;

import org.junit.Before;
import org.junit.Test;
import apuesta.Apuesta;
import estado.EnJuego;
import estado.EstadoEventoDeportivo;
import estado.NoComenzado;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestNoComenzado {
	private NoComenzado noComenzado;
	private Apuesta apuesta;
	
		@Before
		public void setUp() {
			apuesta = mock(Apuesta.class);
			noComenzado = new NoComenzado();
		}
		
		@Test
		public void testLaPenalidadEsDe200Pesos() {
			assertEquals(new Float(200), noComenzado.penalidad(apuesta));
		}
		
		@Test
		public void testAlCancelarLaApuestaSeLeCobraUnaPenalidadDe200() {
			noComenzado.cancelar(apuesta);
			verify(apuesta).cambiarElTipoDeApuestaACancelada();
			verify(apuesta).reducirMontoConPenalidad(new Float(200));
		}

		@Test
		public void testSePuedeReactivarLaApuesta() {
			noComenzado.reactivar(apuesta);
			verify(apuesta).cambiarElTipoDeApuestaASegura();
		}

}
