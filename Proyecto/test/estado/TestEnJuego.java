package estado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estado.EnJuego;
import estado.EstadoEventoDeportivo;

public class TestEnJuego {
	private EstadoEventoDeportivo enJuego;
	
		@Before
		public void setUp() {
			enJuego = new EnJuego();
		}
		
		@Test
		public void testEstaEmpezado() {
			assertTrue(enJuego.estaEmpezado());
		}
		
		@Test
		public void testEstaFinalizado() {
			assertFalse(enJuego.estaFinalizado());
		}

}
