package criterio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import casaDeApuesta.CasaDeApuestas;

import static org.mockito.Mockito.*;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;

public class  TestCriterioPorDeporte  {
	private String dummyLugar, boxeo, futbol, natacion;
	private CriterioPorDeporte criterioSUT, criterioNoSeCumple;
	private Date dummyFecha;
	private Deporte deporte0, deporte1, deporte2;
	private Oponente dummyOponente;
	private EventoDeportivo eventoDeportivo0, eventoDeportivo1, eventoDeportivo2, eventoDeportivo3, stubEventoDeportivo0, stubEventoDeportivo1, stubEventoDeportivo2, stubEventoDeportivo3;
	private List<EventoDeportivo> eventos, eventosConcretos, partidosDeFutbol;
	private CasaDeApuestas dummyCasa;
	
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
			
			dummyCasa = mock(CasaDeApuestas.class);
			
			stubEventoDeportivo0 = mock(EventoDeportivo.class);
			stubEventoDeportivo1 = mock(EventoDeportivo.class);
			stubEventoDeportivo2 = mock(EventoDeportivo.class);
			stubEventoDeportivo3 = mock(EventoDeportivo.class);
			
			criterioSUT = new CriterioPorDeporte(deporte0); //Futbol
			
			criterioNoSeCumple = new CriterioPorDeporte(deporte2);//Ningun evento deportivo de la lista de eventos es de este deporte.
			
			eventos = new ArrayList<EventoDeportivo>(); 
			
			eventoDeportivo0 = new EventoDeportivo(dummyCasa, deporte0, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			eventoDeportivo1 = new EventoDeportivo(dummyCasa, deporte0, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			eventoDeportivo2 = new EventoDeportivo(dummyCasa, deporte1, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			eventoDeportivo3 = new EventoDeportivo(dummyCasa, deporte1, dummyOponente, dummyOponente, dummyFecha, dummyLugar);
			
			eventosConcretos = new ArrayList<EventoDeportivo>(); 
		
			eventos.add(stubEventoDeportivo0);
			eventos.add(stubEventoDeportivo1);
			eventos.add(stubEventoDeportivo2);
			eventos.add(stubEventoDeportivo3);
			
			eventosConcretos.add(eventoDeportivo0);
			eventosConcretos.add(eventoDeportivo1);
			eventosConcretos.add(eventoDeportivo2);
			eventosConcretos.add(eventoDeportivo3);
			
			partidosDeFutbol = criterioSUT.buscarEn(eventosConcretos);
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
			List<EventoDeportivo> resultado = criterioNoSeCumple.buscarEn(eventosConcretos);
			assertTrue(resultado.isEmpty());
		}
		
		@Test
		public void testElEventoDeportivo0YElEventoDeportivo1CumplenLaCondicionDelCriterioSut() {
			boolean t1 = criterioSUT.cumpleCondicion(eventoDeportivo0);
			boolean t2 = criterioSUT.cumpleCondicion(eventoDeportivo1);
			
			assertTrue(t1);
			assertTrue(t2);
		}
		
		@Test
		public void testElEventoDeportivo2YElEventoDeportivo3NoCumplenLaCondicionDelCriterioSut() {
			boolean t1 = criterioSUT.cumpleCondicion(eventoDeportivo2);
			boolean t2 = criterioSUT.cumpleCondicion(eventoDeportivo3);
			
			assertFalse(t1);
			assertFalse(t2);
		}
		
		@Test
		public void testNingunEventoCumpleLaCondicionDelCriterioQUeNoSeCumple() {
			boolean f0 = criterioNoSeCumple.cumpleCondicion(eventoDeportivo0);
			boolean f1 = criterioNoSeCumple.cumpleCondicion(eventoDeportivo1);
			boolean f2 = criterioNoSeCumple.cumpleCondicion(eventoDeportivo2);
			boolean f3 = criterioNoSeCumple.cumpleCondicion(eventoDeportivo3);
			
			assertFalse(f0);
			assertFalse(f1);
			assertFalse(f2);
			assertFalse(f3);
		}
		
		@Test
		public void testAlEnviarElMensajeSeBuscaEnASeInteraccionaConLosElementosDeEventos() {
			criterioSUT.buscarEn(eventos);			
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte0);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte0);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte0);
		}
	
		
		@Test
		public void testAlEnviarElMensajeSeBuscaEnSeInteraccionaConLosElementosDeEventos() {
			criterioNoSeCumple.buscarEn(eventos);
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte2);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte2);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte2);
		}
		
		@Test
		public void testBuscarEnDevuelveUnaListaVaciaAlNoCumplirNingunPartido() {
			List<EventoDeportivo> resultado = criterioSUT.buscarEn(eventos);
			
			when(stubEventoDeportivo0.esDeDeporte(deporte0)). thenReturn(false);
			when(stubEventoDeportivo1.esDeDeporte(deporte0)). thenReturn(false);
			when(stubEventoDeportivo2.esDeDeporte(deporte0)). thenReturn(false);
			when(stubEventoDeportivo3.esDeDeporte(deporte0)). thenReturn(false);
			assertTrue(resultado.isEmpty());
		}
	
}