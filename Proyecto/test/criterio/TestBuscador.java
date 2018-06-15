package criterio;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import eventoDeportivo.EventoDeportivo;
import expresionLogica.ExpresionLogica;

public class TestBuscador {
	private Buscador buscador;
	private List<EventoDeportivo> eventos;
	Criterio criterio;
	
	@Before
	public void setUp() {
		buscador = new Buscador();
		eventos = new ArrayList<EventoDeportivo>();
		criterio = mock(Criterio.class);
		
		eventos.add
	}

	@Test
	public void test() {
		buscador.realizarBusquedaEn(eventos, criterio) ;
	}

}
