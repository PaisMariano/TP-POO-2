package criterio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;

public class TestBuscador {
	private Buscador buscador;
	private List<EventoDeportivo> eventos;
	private Criterio spyCriterio;
	private Criterio mockCriterio;
	private EventoDeportivo stubEvento0;
	private EventoDeportivo stubEvento1;
	private EventoDeportivo stubEvento2;
	
	private EventoDeportivo eventoConcreto0;
	private EventoDeportivo eventoConcreto1;
	private EventoDeportivo eventoConcreto2;
	
	private Date fecha;
	
	private Deporte deporteConcreto0;
	private Deporte deporteConcreto1;
	private Deporte deporteConcreto2;
	
	@Before
	public void setUp() {
		buscador = new Buscador();
		eventos = new ArrayList<EventoDeportivo>();
		spyCriterio = mock(Criterio.class);
		mockCriterio = mock(Criterio.class);
		stubEvento0 = mock(EventoDeportivo.class); 
		stubEvento1 = mock(EventoDeportivo.class);
		stubEvento2 = mock(EventoDeportivo.class);
		
		eventos.add(stubEvento0);
		eventos.add(stubEvento1);
		eventos.add(stubEvento2);
		
		buscador.realizarBusquedaEn(eventos, spyCriterio);
	}

	@Test
	public void testSeDelegaLaBusquedaDeseadaEnElCriterio() {
		verify(spyCriterio).getValor(eventos);
	}

	@Test
	public void testDevuelveUnaListaVaciaCuandoElCriterioNoSeCumplePorNingunEvento() {
		verify(spyCriterio).getValor(eventos);
	}
	
	@Test
	public void testDevuelveUnaListaConUnSoloElementoCuandoElCriterioSeCumplePorUnSoloEvento() {  
		buscador.realizarBusquedaEn(eventos, spyCriterio);
		verify(spyCriterio).getValor(eventos);
	}
	
	@Test
	public void testDevuelveUnaListaConDosElementosCuandoElCriterioSeCumplePorDosEventos() {
		buscador.realizarBusquedaEn(eventos, spyCriterio);
		verify(spyCriterio).getValor(eventos);
	}
}
