package algoritmo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import oponentes.Deportista;
import oponentes.Oponente;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

public class TestAlgoritmos {
	
	private AlgoritmoProbabilidades algProDirecta;
	private AlgoritmoProbabilidades algProReciente;
	private EventoDeportivo evento;
	private Oponente dummyOp1;
	private Oponente dummyOp2;
	private List<EventoDeportivo> historico;
		
	@Before
	public void setUp() throws Exception {
		//SetUp
		algProDirecta = new CompetenciaHistoricaDirecta();
		algProReciente = new CompetenciaHistoriaReciente();
		
		dummyOp1 = mock(Deportista.class);
		dummyOp2 = mock(Deportista.class);
		evento = mock(EventoDeportivo.class);
		
		historico = new ArrayList<EventoDeportivo>();
		
		historico.add(evento);
		historico.add(evento);
		historico.add(evento);
		historico.add(evento);
	}

	
	@Test
	public void testCalcularHistoricoEntreTeniendoCuatroIteraciones() {
		
		when(evento.participaronVs(dummyOp1, dummyOp2)).thenReturn(true);
		
		algProDirecta.calcularHistoricoEntre(historico, dummyOp1, dummyOp2);
		
		verify(evento, times(4)).participaronVs(dummyOp1, dummyOp2);
		
	}

	@Test
	public void testVerificoQueLaCantidadDeVictoriasDelOponenteUnoSeaCuatro() {
		
		when(evento.getGanador()).thenReturn(dummyOp1);
		assertEquals(algProDirecta.probabilidadGanador(historico, dummyOp1),new Float(4));
		
	}

	@Test
	public void testCalcularCoeficiente(){
		Float[] coeficiente;
		ArrayList<EventoDeportivo> historicoCompleto = new ArrayList<EventoDeportivo>();
		
		//agrego 30 veces el evento para probar la funcionalidad.
		for(int i = 0; i <= 30; i++) {
			historicoCompleto.add(evento);
		}		
		//esto sirve para que se me generen dos listas de 30 para cada uno.
		when(evento.participo(dummyOp1)).thenReturn(true);
		when(evento.participo(dummyOp2)).thenReturn(true);
		
		//solo oponente 1 gano 10 partidos, en cambio oponente 2 gano 0.
		when(evento.getGanador()).thenReturn(dummyOp1);
		
		coeficiente = algProReciente.calcularProbabilidad(historicoCompleto, dummyOp1, dummyOp2);
		
		assertEquals(coeficiente[0], new Float(1));
		//assertEquals(coeficiente[0], new Float(0));
		//assertEquals(coeficiente[0], new Float(0.5));
		
	}
}