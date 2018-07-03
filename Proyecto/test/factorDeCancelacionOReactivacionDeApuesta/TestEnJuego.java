package factorDeCancelacionOReactivacionDeApuesta;

import org.junit.Before;
import org.junit.Test;
import apuesta.Apuesta;
import estado.EnJuego;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestEnJuego {
	private EnJuego enJuego;
	private Apuesta apuesta;
	
		@Before
		public void setUp() {
			apuesta = mock(Apuesta.class);
			enJuego = new EnJuego();
		}
		
		@Test
		public void testLaPenalidadEsDel30Porciento() {
			when(apuesta.monto()).thenReturn(new Float(1000));
		
			
			Float total = enJuego.penalidad(apuesta);
			assertEquals(new Float(300),total);
		}
	
		@Test
		public void testAlCancelarLaApuestaSeLeCobraUnaPenalidadDeL30PorcientoDelMonto() {
			when(apuesta.monto()).thenReturn(new Float(2000));
		
			enJuego.cancelar(apuesta);
			
			verify(apuesta).cambiarElTipoDeApuestaACancelada();
			verify(apuesta).reducirMontoConPenalidad(new Float(600));
		}

		@Test
		public void testSePuedeReactivarLaApuesta() throws Exception{
			//Esto tiene que romper
			//Lanza excepcion
			enJuego.reactivar(apuesta);
		}
}
