package eventoDeportivo;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import oponentes.Equipo;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;

import java.sql.Date;

public class TestEventosDeportivo {

	private Deporte unDeporte;
	private EventoDeportivo unEventoDeportivo;
	private Equipo boca;
	private Equipo river;
	private Date fechaYHora;
	
	private Equipo chacarita; 
	
	
	@Before
	public void setUp(){
		fechaYHora=mock(Date.class);
		river = mock(Equipo.class);
		boca = mock(Equipo.class);
		chacarita =  mock(Equipo.class);
		unDeporte = new Deporte("Boxeo");
		unEventoDeportivo= new EventoDeportivo(unDeporte, river, boca, fechaYHora, "LaCasaDeTuHermana");
	}
	

	@Test
	public void unNuevoDeporteCuentaConUnNombre() {
	
		unDeporte = new Deporte("Boxeo");
		assertEquals((unDeporte.getNombre()),"Boxeo");	
		
	}
	
	@Test public void testCompararSiUnOponenteParticipoEnElEvento() {
		
		assertFalse(unEventoDeportivo.participo(chacarita));
		assertTrue(unEventoDeportivo.participo(river));
	}
	
	@Test public void testCompararLosOponentesCompitieron() {
		
		assertFalse(unEventoDeportivo.participaronVs(chacarita, boca));
		assertTrue(unEventoDeportivo.participaronVs(river, boca));
		assertTrue(unEventoDeportivo.participaronVs(boca , river));
	}
	
}
