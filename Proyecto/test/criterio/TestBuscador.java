package criterio;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public class TestBuscador {
	private Buscador buscador;
	private List<EventoDeportivo> eventos;
	private Criterio spyCriterio;
	private EventoDeportivo dummyEvento;
	@Before
	public void setUp() {
		buscador = new Buscador();
		eventos = new ArrayList<EventoDeportivo>();
		spyCriterio = mock(Criterio.class);
		dummyEvento = mock(EventoDeportivo.class); 
		eventos.add(dummyEvento);
	}

	@Test
	public void testSeDelegaLaBusquedaDeseadaEnElCriterio() {
		buscador.realizarBusquedaEn(eventos, spyCriterio);
		verify(spyCriterio).getValor(eventos);
	}

}
