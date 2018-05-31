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
	
	private AlgoritmoProbabilidades algPro;
	private EventoDeportivo evento;
	private Oponente dummyOp1;
	private Oponente dummyOp2;
	private List<EventoDeportivo> historico;
		
	@Before
	public void setUp() throws Exception {
		//SetUp
		algPro = new CompetenciaHistoricaDirecta();
		
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
		
		algPro.calcularHistoricoEntre(historico, dummyOp1, dummyOp2);
		
		verify(evento, times(4)).participaronVs(dummyOp1, dummyOp2);
		
	}

	@Test
	public void testVerificoQueLaProbabilidadDelOponenteUnoSeaCuatro() {
		
		when(evento.getGanador()).thenReturn(dummyOp1);
		
		assertEquals(algPro.probabilidadGanador(historico, dummyOp1),new Float(4));
		
	}
	
}
