package expresionLogica;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import eventoDeportivo.EventoDeportivo;

public class TestOR {
	private OperacionLogica orSut;
	private ExpresionLogica stubExpresionIzq, stubExpresionDer;
	private List<EventoDeportivo> eventos;

		@Before
		public void setUp() {
			stubExpresionIzq = mock(ExpresionLogica.class);
			stubExpresionDer = mock(ExpresionLogica.class);
			orSut = new OR(stubExpresionIzq, stubExpresionDer);
		}
		
		@Test
		public void testLaExpresionIzquierdaEnLaOperacionEsLaCorrecta() {
			ExpresionLogica izq = orSut.getExpresionIzquierda();
			assertEquals(stubExpresionIzq, izq);
		}
		
		@Test
		public void testLaExpresionDerechaEnLaOperacionEsLaCorrecta() {
			ExpresionLogica der = orSut.getExpresionDerecha();
			assertEquals(stubExpresionDer, der);
		}
}