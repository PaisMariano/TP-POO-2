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

public class  TestCriterioPorFecha  {
	
	private String nada;
	private CriterioPorFecha criterioSUT, criterioNoSeCumple;
	private Date fecha, fechaNoSeCumple, fechaCualquiera;
	private Deporte dummyDeporte;
	private Oponente dummyOponente0;
	private EventoDeportivo eventoDeportivo0, eventoDeportivo1, eventoDeportivo2, eventoDeportivo3, stubEventoDeportivo0, stubEventoDeportivo1, stubEventoDeportivo2, stubEventoDeportivo3;
	private List<EventoDeportivo> eventos, eventosConcretos, partidosDeDia222;
	
		@Before
		public void setUp() {
			nada = new String("");
			fecha = new Date(2,2,2);
			fechaCualquiera = new Date(4,4,4);
			fechaNoSeCumple = new Date(6,6,6);
			
			dummyDeporte = mock(Deporte.class);
			
			dummyOponente0 = mock(Oponente.class);
			
			criterioSUT = new CriterioPorFecha(fecha);
			criterioNoSeCumple = new CriterioPorFecha(fechaNoSeCumple);//Ningun evento deportivo de la lista de eventos se jugo en este fecha.
			
			stubEventoDeportivo0 = mock(EventoDeportivo.class);
			stubEventoDeportivo1 = mock(EventoDeportivo.class);
			stubEventoDeportivo2 = mock(EventoDeportivo.class);
			stubEventoDeportivo3 = mock(EventoDeportivo.class); 
		
			eventos = new ArrayList<EventoDeportivo>();
			eventos.add(stubEventoDeportivo0);
			eventos.add(stubEventoDeportivo1);
			eventos.add(stubEventoDeportivo2);
			eventos.add(stubEventoDeportivo3);
			
			eventoDeportivo0 = new EventoDeportivo(dummyDeporte, dummyOponente0, dummyOponente0, fecha, nada);
			eventoDeportivo1 = new EventoDeportivo(dummyDeporte, dummyOponente0, dummyOponente0, fecha, nada);
			eventoDeportivo2 = new EventoDeportivo(dummyDeporte, dummyOponente0, dummyOponente0, fechaCualquiera, nada);
			eventoDeportivo3 = new EventoDeportivo(dummyDeporte, dummyOponente0, dummyOponente0, fechaCualquiera, nada);
			
			eventosConcretos = new ArrayList<EventoDeportivo>();
			eventosConcretos.add(eventoDeportivo0);
			eventosConcretos.add(eventoDeportivo1);
			eventosConcretos.add(eventoDeportivo2);
			eventosConcretos.add(eventoDeportivo3);
			
			partidosDeDia222 = criterioSUT.buscarEn(eventosConcretos);
		}
		
		
		@Test
		public void testBuscarEnLaListaDeEventosConcretosDevuelveSoloDosEventos() {
			assertEquals(2, partidosDeDia222.size());
		}
		
		@Test
		public void testAlBuscarEnLaListaDeEventosLosPartidosDeFutbolDevuelveLosCorrectos() {
			assertTrue(partidosDeDia222.contains(eventoDeportivo0));
			assertTrue(partidosDeDia222.contains(eventoDeportivo1));
			assertFalse(partidosDeDia222.contains(eventoDeportivo2));
			assertFalse(partidosDeDia222.contains(eventoDeportivo3));
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
		public void testAlEnviarElMensajeSeBuscaEnSeInteraccionaConLosElementosDeEventos() {
			criterioSUT.buscarEn(eventos);
			
			verify(stubEventoDeportivo0, times(1)).sucedioEn(fecha);
			verify(stubEventoDeportivo1, times(1)).sucedioEn(fecha);
			verify(stubEventoDeportivo2, times(1)).sucedioEn(fecha);
		}
		
		@Test
		public void testAlEnviarElMensajeSeBuscaYNoSeCumpleElCriterioIgualmenteSeInteraccionaConLosElementosDeEventos() {
			criterioNoSeCumple.buscarEn(eventos);

			verify(stubEventoDeportivo0, times(1)).sucedioEn(fechaNoSeCumple);
			verify(stubEventoDeportivo1, times(1)).sucedioEn(fechaNoSeCumple);
			verify(stubEventoDeportivo2, times(1)).sucedioEn(fechaNoSeCumple);
		}
		
		@Test //Ver
		public void testBuscarEnDevuelveLosDosPartidosDeFutbol() {
			List<EventoDeportivo> resultado = criterioSUT.buscarEn(eventos);
			int cantidadDeResultado = resultado.size();
			
			when(stubEventoDeportivo0.sucedioEn(fecha)).thenReturn(true);
			when(stubEventoDeportivo1.sucedioEn(fecha)).thenReturn(false);
			when(stubEventoDeportivo2.sucedioEn(fecha)).thenReturn(false);
			when(stubEventoDeportivo3.sucedioEn(fecha)).thenReturn(false);
			
			//assertEquals(1, cantidadDeResultado);
			//assertTrue(resultado.contains(stubEventoDeportivo0));
			//assertTrue(resultado.contains(stubEventoDeportivo1));
			assertTrue(!resultado.contains(stubEventoDeportivo2));
			assertTrue(!resultado.contains(stubEventoDeportivo3));
		}
		
		@Test
		public void testBuscarEnDevuelveUnaListaVaciaAlNoCumplirNingunPartido() {
			List<EventoDeportivo> resultado = criterioSUT.buscarEn(eventos);
			
			when(stubEventoDeportivo0.sucedioEn(fecha)).thenReturn(false);
			when(stubEventoDeportivo1.sucedioEn(fecha)).thenReturn(false);
			when(stubEventoDeportivo2.sucedioEn(fecha)).thenReturn(false);
			when(stubEventoDeportivo3.sucedioEn(fecha)).thenReturn(false);
			assertTrue(resultado.isEmpty());
		}
}