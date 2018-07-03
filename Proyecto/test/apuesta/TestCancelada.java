package apuesta;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class TestCancelada {
	private Apuesta spyApuesta;
	private TipoApuesta canceladaSUT;

		@Before
		public void setUp() {
			canceladaSUT = new Cancelada();
			spyApuesta = mock(Apuesta.class);
			
		}
		
		@Test
		public void testAlCancelarTiraError() {
			
		}
		
		@Test
		public void testLaGananciaBrutaEsCero() {
			assertEquals(new BigDecimal(0), canceladaSUT.gananciaBruta(spyApuesta));
		}
		@Test
		public void testAlReactivarLoDelegaEnLaApuesta(){
			//Falta implementar, como corroborar que la excepcion se lance?
		}
}
