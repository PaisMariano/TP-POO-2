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

public class TestCriterioPorDeporte {
	private CriterioPorDeporte criterioSUT0;
	private CriterioPorDeporte criterioSUT1;
	private CriterioPorDeporte criterioNoSeCumple;
	
	private String lugar;
	
	private String futbol;
	private String boxeo;
	private String rugby;

	private Date dummyFecha;
	
	private Deporte deporte0;
	private Deporte deporte1;
	private Deporte deporte2;
	
	private Oponente dummyOponente0;
	private Oponente dummyOponente1;

	private EventoDeportivo eventoDeportivo0;
	private EventoDeportivo eventoDeportivo1;
	private EventoDeportivo eventoDeportivo2;
	
	private EventoDeportivo stubEventoDeportivo0;
	private EventoDeportivo stubEventoDeportivo1;
	private EventoDeportivo stubEventoDeportivo2;
	
	private List<EventoDeportivo> eventos;
	
		@Before
		public void setUp() {
			
			lugar = new String("Rosario");
			
			futbol = new String("Futbol");
			boxeo = new String("Boxeo");
			rugby = new String("Rugby");
			
			dummyFecha = mock(Date.class);
			
			deporte0 = new Deporte(futbol);
			deporte1 = new Deporte(boxeo);
			deporte2 = new Deporte (rugby);
			dummyOponente0 = mock(Oponente.class);
			dummyOponente1 = dummyOponente0;
			
			eventoDeportivo0 = new EventoDeportivo(deporte0, dummyOponente0, dummyOponente1, dummyFecha, lugar);
			eventoDeportivo1 = new EventoDeportivo(deporte0, dummyOponente0, dummyOponente1, dummyFecha, lugar);
			eventoDeportivo2 = new EventoDeportivo(deporte1, dummyOponente0, dummyOponente1, dummyFecha, lugar);
			
			stubEventoDeportivo0 = mock(EventoDeportivo.class);
			stubEventoDeportivo1 = mock(EventoDeportivo.class);
			stubEventoDeportivo2 = mock(EventoDeportivo.class);
			
			criterioSUT0 = new CriterioPorDeporte(deporte0);//Futbol
			criterioSUT1 = new CriterioPorDeporte(deporte1);//Boxeo
			criterioNoSeCumple = new CriterioPorDeporte(deporte2);//Ningun evento deportivo de la lista de eventos es de este deporte.
			
			eventos = new ArrayList<EventoDeportivo>(); 
			eventos.add(stubEventoDeportivo0);
			eventos.add(stubEventoDeportivo1);
			eventos.add(stubEventoDeportivo2);
			
		}
		
		@Test
		public void testBuscarEnDevuelveLosDosPartidosDeFutbol() {
			
			when(stubEventoDeportivo0.esDeDeporte(deporte0)).thenReturn(true);
			when(stubEventoDeportivo0.esDeDeporte(deporte0)).thenReturn(true);
			when(stubEventoDeportivo0.esDeDeporte(deporte0)).thenReturn(false);
			
			assertEquals(2, criterioSUT0.buscarEn(eventos).size());
			
		}

		@Test
		public void testBuscarEnDevuelve0Elementos() {
			
			criterioSUT1.buscarEn(eventos);
			criterioNoSeCumple.buscarEn(eventos);
			
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte0);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte0);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte0);
			
			
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte1);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte1);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte1);
	
			verify(stubEventoDeportivo0, times(1)).esDeDeporte(deporte2);
			verify(stubEventoDeportivo1, times(1)).esDeDeporte(deporte2);
			verify(stubEventoDeportivo2, times(1)).esDeDeporte(deporte2);
	
		}
	
}
