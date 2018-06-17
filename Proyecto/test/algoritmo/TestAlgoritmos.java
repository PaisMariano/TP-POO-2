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
		algProReciente = new CompetenciaHistoricaReciente();
		
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
	public void testCalcularCoeficienteOponente1AlgoritmoReciente(){
		Float coeficiente;
		ArrayList<EventoDeportivo> historicoCompleto = new ArrayList<EventoDeportivo>();
		
		for(int i = 0; i <= 30; i++) {
			historicoCompleto.add(evento);
		}		
		when(evento.participo(dummyOp1)).thenReturn(true);
		when(evento.participo(dummyOp2)).thenReturn(true);
		
		when(evento.getGanador()).thenReturn(dummyOp1);
		
		coeficiente = algProReciente.calcularProbabilidad(historicoCompleto, dummyOp1, dummyOp2);
		
		assertEquals(coeficiente, new Float(1));
	} 
	
	@Test
	public void testCalcularCoeficienteEmpateAlgoritmoReciente(){
		Float coeficiente;
		ArrayList<EventoDeportivo> historicoCompleto = new ArrayList<EventoDeportivo>();
		
		for(int i = 0; i <= 30; i++) {
			historicoCompleto.add(evento);
		}		
		
		when(evento.participo(dummyOp1)).thenReturn(true);
		when(evento.participo(dummyOp2)).thenReturn(true);
		 
		when(evento.getGanador()).thenReturn(dummyOp1);
		
		coeficiente = algProReciente.calcularProbabilidadEmpate(historicoCompleto, dummyOp1, dummyOp2);
		
		assertEquals(coeficiente, new Float(0.5));
	}
	
	@Test
	public void testCalcularCoeficienteOponente1AlgoritmoDirecto(){
		Float coeficiente;
		ArrayList<EventoDeportivo> historicoCompleto = new ArrayList<EventoDeportivo>();
		
		for(int i = 0; i <= 30; i++) {
			historicoCompleto.add(evento);
		}		
		
		when(evento.participaronVs(dummyOp1, dummyOp2)).thenReturn(true);
		
		when(evento.getGanador()).thenReturn(dummyOp1);
		
		coeficiente = algProDirecta.calcularProbabilidad(historicoCompleto, dummyOp1, dummyOp2);
		
		assertEquals(coeficiente, new Float(1));
	} 
	
	@Test
	public void testCalcularCoeficienteEmpateAlgoritmoDirecto(){
		Float coeficiente;
		ArrayList<EventoDeportivo> historicoCompleto = new ArrayList<EventoDeportivo>();
		
		for(int i = 0; i <= 30; i++) {
			historicoCompleto.add(evento);
		}		
		
		when(evento.participaronVs(dummyOp1, dummyOp2)).thenReturn(true);
		 
		when(evento.getGanador()).thenReturn(dummyOp1);
		
		coeficiente = algProDirecta.calcularProbabilidadEmpate(historicoCompleto, dummyOp1, dummyOp2);
		
		assertEquals(coeficiente, new Float(0));
	}
	  
}