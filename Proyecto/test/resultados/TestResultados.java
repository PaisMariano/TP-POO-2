package resultados;

import org.junit.Before;
import org.junit.Test;

import eventoDeportivo.EventoDeportivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import oponentes.*;

public class TestResultados {
	
	private Resultado empate, ganado1, ganado2;
	private Equipo dummyEquipo;
	private Deportista dummyDeportista;
	private EventoDeportivo dummyEvento;
	private ArrayList<Oponente> oponentes;
	
		@Before
		public void setUp() {
			dummyEquipo = mock(Equipo.class);
			dummyDeportista = mock(Deportista.class);
			dummyEvento = mock(EventoDeportivo.class);
			ganado1 = new Ganado(dummyEquipo);
			ganado2 = new Ganado(dummyDeportista);
			empate = new Empate();
			oponentes = new ArrayList<Oponente>();
			
			oponentes.add(dummyEquipo);
			oponentes.add(dummyDeportista);
			
		}
		
		@Test 
		public void testElGanadorDelResultado1EsELDummyEquipo() {
			assertEquals(ganado1.getApostado(), dummyEquipo);
		}
		
		@Test
		public void testElGanadorDelResultado2EsELDummyDeportista() {
			assertEquals(ganado2.getApostado(), dummyDeportista);
		}
		
		@Test
		public void testElGanadorDelEmpateEsUnNullObject() {
			Oponente oponenteNull = null;
			assertEquals(empate.getApostado(), oponenteNull);
		}
		
		@Test
		public void testVerificoQueSeLeMandeElMensajeGetCuotaEmpateAlEvento() {
			
			when(dummyEvento.getCuotaEmpate()).thenReturn(new Float(1));
			
			empate.getCuotaApuesta(dummyEvento, empate);
			
			verify(dummyEvento,times(1)).getCuotaEmpate();
			
		}
		
		@Test
		public void testVerificoQueDevuelvaLaCuotaDelOponente1() {
			
			when(dummyEvento.getCuotaOponente2()).thenReturn(new Float(0));
			when(dummyEvento.getCuotaOponente1()).thenReturn(new Float(1));
			when(dummyEvento.getOponentes()).thenReturn(this.oponentes);
			
			
			assertEquals(ganado1.getCuotaApuesta(dummyEvento, ganado1), new Float(1));
			
		} 
}
