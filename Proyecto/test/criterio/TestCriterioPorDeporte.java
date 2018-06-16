package criterio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class  TestCriterioPorDeporte  {
	private String dummyLugar, boxeo, futbol, natacion;
	private CriterioPorDeporte criterioSUT0, criterioNoSeCumple;
	
	private Date dummyFecha;
	
	private Deporte deporte0, deporte1, deporte2;
	
	private Oponente dummyOponente;

	private EventoDeportivo eventoDeportivo0, eventoDeportivo1, eventoDeportivo2, eventoDeportivo3, stubEventoDeportivo0, stubEventoDeportivo1, stubEventoDeportivo2, stubEventoDeportivo3;
	
	private List<EventoDeportivo> eventos, eventosConcretos, partidosDeFutbol;
	
		@Before
		public void setUp() {
			dummyLugar = new String("");
			
			futbol = new String("Futbol");
			boxeo = new String("Boxeo");
			natacion = new String("Natacion");
			
			dummyFecha = mock(Date.class);
			
			deporte0 = new Deporte(futbol);
			deporte1 = new Deporte(boxeo);
			deporte2 = new Deporte(natacion);
			
			dummyOponente = mock(Oponente.class);
			
			stubEventoDeportivo0 = mock(EventoDeportivo.class);
			stubEventoDeportivo1 = mock(EventoDeportivo.class);
			stubEventoDeportivo2 = mock(EventoDeportivo.class);
			stubEventoDeportivo3 = mock(EventoDeportivo.class);
			
			criterioSUT0 = new CriterioPorDeporte(deporte0); //Futbol
			
			criterioNoSeCumple = new CriterioPorDeporte(deporte2);//Ningun evento deportivo de la lista de eventos es de este deporte.
			
			eventos = new ArrayList<EventoDeportivo>(); 
			
			eventoDeportivo0 = new EventoDeportivo(deporte0, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			eventoDeportivo1 = new EventoDeportivo(deporte0, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			eventoDeportivo2 = new EventoDeportivo(deporte1, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			eventoDeportivo3 = new EventoDeportivo(deporte1, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			
			eventosConcretos = new ArrayList<EventoDeportivo>(); 
		
			eventos.add(stubEventoDeportivo0);
			eventos.add(stubEventoDeportivo1);
			eventos.add(stubEventoDeportivo2);
			eventos.add(stubEventoDeportivo3);
			
			eventosConcretos.add(eventoDeportivo0);
			eventosConcretos.add(eventoDeportivo1);
			eventosConcretos.add(eventoDeportivo2);
			eventosConcretos.add(eventoDeportivo3);
			
			partidosDeFutbol = criterioSUT0.buscarEn(eventosConcretos);
		}
		
		@Test
		public void testBuscarEnDevuelveLosDosPartidosDeFutbol() {
			List<EventoDeportivo> resultado = criterioSUT0.buscarEn(eventos);
			
			when(stubEventoDeportivo0.esDeDeporte(deporte0)).thenReturn(true);
			when(stubEventoDeportivo1.esDeDeporte(deporte0)).thenReturn(false);
			when(stubEventoDeportivo2.esDeDeporte(deporte0)).thenReturn(false);
			when(stubEventoDeportivo3.esDeDeporte(deporte0)).thenReturn(false);
			assertEquals(1, resultado.size());
			assertTrue(resultado.contains(stubEventoDeportivo0));
			assertTrue(resultado.contains(stubEventoDeportivo1));
			assertTrue(!resultado.contains(stubEventoDeportivo2));
		}
		
		@Test
		public void testBuscarEnDevuelveUnaListaVaciaAlNoCumplirNingunPartido() {
			List<EventoDeportivo> resultado = criterioSUT0.buscarEn(eventos);
			
			when(stubEventoDeportivo0.esDeDeporte(deporte0)). thenReturn(false);
			when(stubEventoDeportivo1.esDeDeporte(deporte0)). thenReturn(false);
			when(stubEventoDeportivo2.esDeDeporte(deporte0)). thenReturn(false);
			when(stubEventoDeportivo3.esDeDeporte(deporte0)). thenReturn(false);
			assertTrue(resultado.isEmpty());
		}
		
		@Test
		public void testBuscarEnLaListaDeEventosConcretosDevuelveSoloDosEventos() {
			assertEquals(2, partidosDeFutbol.size());
		}
		
		@Test
		public void testAlBuscarEnLaListaDeEventosLosPartidosDeFutbolDevuelveLosCorrectos() {
			assertTrue(partidosDeFutbol.contains(eventoDeportivo0));
			assertTrue(partidosDeFutbol.contains(eventoDeportivo1));
			assertFalse(partidosDeFutbol.contains(eventoDeportivo2));
			assertFalse(partidosDeFutbol.contains(eventoDeportivo3));
		}
		
		@Test
		public void testBuscarEnLaListaDeEventosConcretosDevuelveUnalistaVaciaAlNoCumplirseElCriterioDeBusqueda() {
			assertTrue(partidosDeFutbol.isEmpty());
		}
		
		@Test
		public void testAlEnviarElMensajeSeBuscaEnSeInteraccionaConLosElementosDeEventos() {
			criterioNoSeCumple.buscarEn(eventos);
			
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte0);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte0);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte0);
			
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte2);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte2);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte2);
		}
	
}