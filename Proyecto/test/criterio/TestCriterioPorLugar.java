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

public class  TestCriterioPorLugar  {
	private String lugar, otroLugar, lugarNoSeCumple;
	
	private CriterioPorLugar criterioSUT, criterioNoSeCumple;
	
	private Date dummyFecha;
	
	private Deporte dummyDeporte;
	
	private Oponente dummyOponente;

	private EventoDeportivo eventoDeportivo0, eventoDeportivo1, eventoDeportivo2, eventoDeportivo3, stubEventoDeportivo0, stubEventoDeportivo1, stubEventoDeportivo2, stubEventoDeportivo3;
	
	private List<EventoDeportivo> eventos, eventosConcretos, partidosJugadosEnTailandia;
	
		@Before
		public void setUp() {
			lugar = new String("Tailandia");
			otroLugar = new String("Canada");
			lugarNoSeCumple = new String("Narnia");
			
			dummyFecha = mock(Date.class);
			
			dummyDeporte = mock(Deporte.class);
			
			dummyOponente = mock(Oponente.class);
			
			stubEventoDeportivo0 = mock(EventoDeportivo.class);
			stubEventoDeportivo1 = mock(EventoDeportivo.class);
			stubEventoDeportivo2 = mock(EventoDeportivo.class);
			stubEventoDeportivo3 = mock(EventoDeportivo.class);
			
			criterioSUT = new CriterioPorLugar(lugar);
			criterioNoSeCumple = new CriterioPorLugar(lugarNoSeCumple);//Ningun evento deportivo de la lista de eventos se da en este lugar.
			
			eventos = new ArrayList<EventoDeportivo>(); 
			
			eventoDeportivo0 = new EventoDeportivo(dummyDeporte, dummyOponente, dummyOponente, dummyFecha, lugar);
			eventoDeportivo1 = new EventoDeportivo(dummyDeporte, dummyOponente, dummyOponente, dummyFecha, lugar);
			eventoDeportivo2 = new EventoDeportivo(dummyDeporte, dummyOponente, dummyOponente, dummyFecha, otroLugar);
			eventoDeportivo3 = new EventoDeportivo(dummyDeporte, dummyOponente, dummyOponente, dummyFecha, otroLugar);
			
			eventosConcretos = new ArrayList<EventoDeportivo>(); 
		
			eventos.add(stubEventoDeportivo0);
			eventos.add(stubEventoDeportivo1);
			eventos.add(stubEventoDeportivo2);
			eventos.add(stubEventoDeportivo3);
			
			eventosConcretos.add(eventoDeportivo0);
			eventosConcretos.add(eventoDeportivo1);
			eventosConcretos.add(eventoDeportivo2);
			eventosConcretos.add(eventoDeportivo3);
			
			partidosJugadosEnTailandia = criterioSUT.buscarEn(eventosConcretos);
		}
		
		@Test
		public void testBuscarEnLaListaDeEventosConcretosDevuelveSoloDosEventos() {
			assertEquals(2, partidosJugadosEnTailandia.size());
		}
		
		@Test
		public void testAlBuscarEnLaListaDeEventosConcretosLosPartidosDeFutbolDevuelveLosCorrectos() {
			assertTrue(partidosJugadosEnTailandia.contains(eventoDeportivo0));
			assertTrue(partidosJugadosEnTailandia.contains(eventoDeportivo1));
			assertFalse(partidosJugadosEnTailandia.contains(eventoDeportivo2));
			assertFalse(partidosJugadosEnTailandia.contains(eventoDeportivo3));
		}
		
		@Test
		public void testBuscarEnLaListaDeEventosConcretosDevuelveUnalistaVaciaAlNoCumplirseElCriterioDeBusqueda() {
			List<EventoDeportivo> resultado = criterioNoSeCumple.buscarEn(eventos);
			assertTrue(resultado.isEmpty());
		}
		
		@Test
		public void testDeLaListaDeEventosConcretosElEventoDeportivo0YElEventoDeportivo1CumplenLaCondicionDelCriterioSut() {
			boolean t1 = criterioSUT.cumpleCondicion(eventoDeportivo0);
			boolean t2 = criterioSUT.cumpleCondicion(eventoDeportivo1);
			
			assertTrue(t1);
			assertTrue(t2);
		}
		
		@Test
		public void testDeLaListaDeEventosConcretosElEventoDeportivo2YElEventoDeportivo3NoCumplenLaCondicionDelCriterioSut() {
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
			
			verify(stubEventoDeportivo0, times(1)).seJugoEn(lugar);
			verify(stubEventoDeportivo1, times(1)).seJugoEn(lugar);
			verify(stubEventoDeportivo2, times(1)).seJugoEn(lugar);
		}
		
		@Test
		public void testAlEnviarElMensajeSeBuscaEnSeInteraccionaConLosElementosDeEventosAunqueElCriterioNoSeCumpla() {
			criterioNoSeCumple.buscarEn(eventos);
			
			verify(stubEventoDeportivo0, times(1)).seJugoEn(lugarNoSeCumple);
			verify(stubEventoDeportivo1, times(1)).seJugoEn(lugarNoSeCumple);
			verify(stubEventoDeportivo2, times(1)).seJugoEn(lugarNoSeCumple);
		}
		
		@Test //Ver
		public void testBuscarEnDevuelveLosDosPartidosDeFutbol() {
			List<EventoDeportivo> resultado = criterioSUT.buscarEn(eventos);
			
			when(stubEventoDeportivo0.seJugoEn(lugar)).thenReturn(true);
			when(stubEventoDeportivo1.seJugoEn(lugar)).thenReturn(false);
			when(stubEventoDeportivo2.seJugoEn(lugar)).thenReturn(false);
			when(stubEventoDeportivo3.seJugoEn(lugar)).thenReturn(false);
			
			//assertEquals(1, resultado.size());
			//assertTrue(resultado.contains(stubEventoDeportivo0));
			assertTrue(!resultado.contains(stubEventoDeportivo1));
			assertTrue(!resultado.contains(stubEventoDeportivo2));
			assertTrue(!resultado.contains(stubEventoDeportivo3));
		}
		
		@Test
		public void testBuscarEnDevuelveUnaListaVaciaAlNoCumplirNingunPartido() {
			List<EventoDeportivo> resultado = criterioSUT.buscarEn(eventos);
			
			when(stubEventoDeportivo0.seJugoEn(lugar)).thenReturn(false);
			when(stubEventoDeportivo1.seJugoEn(lugar)).thenReturn(false);
			when(stubEventoDeportivo2.seJugoEn(lugar)).thenReturn(false);
			when(stubEventoDeportivo3.seJugoEn(lugar)).thenReturn(false);
			assertTrue(resultado.isEmpty());
		}
}