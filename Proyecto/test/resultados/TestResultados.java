package resultados;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import oponentes.*;

public class TestResultados {
	
	private Resultado empate, ganado1, ganado2;
	private Equipo dummyEquipo;
	private Deportista dummyDeportista;
	
		@Before
		public void setUp() {
			dummyEquipo = mock(Equipo.class);
			dummyDeportista = mock(Deportista.class);
			ganado1 = new Ganado(dummyEquipo);
			ganado2 = new Ganado(dummyDeportista);
			empate = new Empate();
		}
		
		@Test
		public void testElGanadorDelResultado1EsELDummyEquipo() {
			assertEquals(ganado1.getGanador(), dummyEquipo);
		}
		
		@Test
		public void testElGanadorDelResultado2EsELDummyDeportista() {
			assertEquals(ganado2.getGanador(), dummyDeportista);
		}
		
		@Test
		public void testElGanadorDelEmpateEsUnNullObject() {
			Oponente oponenteNull = new None();
			assertEquals(empate.getGanador(), oponenteNull); //No quiero preguntar si son el mismo, quiero saber si son iguales.
		}
}
