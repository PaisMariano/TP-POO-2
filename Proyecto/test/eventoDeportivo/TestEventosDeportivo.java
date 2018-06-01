package eventoDeportivo;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import oponentes.Equipo;
import resultados.Empate;
import resultados.Ganado;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import estado.Finalizado;
import estado.NoComenzado;

import static org.mockito.Mockito.*;

import java.sql.Date;

public class TestEventosDeportivo {

	private Deporte unDeporte;
	private EventoDeportivo unEventoDeportivo, mockEventoDeportivo;
	private Equipo boca;
	private Equipo river;
	private Date fechaYHora;	
	private Equipo chacarita; 
	private Empate unEstadoEmpatado;
	private Ganado unEstadoGanado1;
	private EstadoEventoDeportivo estadoFinalizado;
	
	@Before
	public void setUp(){
		
		fechaYHora=mock(Date.class);
		river = mock(Equipo.class);
		boca = mock(Equipo.class);
		chacarita =  mock(Equipo.class);
		unDeporte = new Deporte("Boxeo");
		unEstadoEmpatado=new Empate();
		unEstadoGanado1=new Ganado(chacarita);
		
		unEventoDeportivo= new EventoDeportivo(unDeporte, river, boca, fechaYHora, "LaCasaDeTuHermana");
		mockEventoDeportivo=mock(EventoDeportivo.class);
		estadoFinalizado= new Finalizado();
	
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
	
	@Test public void testVerificarQueUnEventoEstaFinalizado() {
		
		EstadoEventoDeportivo finalizado=new Finalizado(); 
		unEventoDeportivo.setEstado(finalizado);
		assertTrue(unEventoDeportivo.estaFinalizado());
		
				
	}

	@Test public void testAnteDosOponentesSeCalculaLaCuota() {
		
		 Float[] probabilidades = {new Float(0.7),new Float(0.2),new Float(0.1)};
		 
		 unEventoDeportivo.calcularCuotas(probabilidades);
		 assertEquals(unEventoDeportivo.getCuotaOponente1(),(float) 1,3);
		 assertEquals(unEventoDeportivo.getCuotaOponente2(),(float)1,8);
		 assertEquals( unEventoDeportivo.getCuotaEmpate(),(float)1,9);
		
	}

	@Test public void testSeModificaElResultadoDelEventoDeportivo() {
		//por default se inicializa como empatado
		
		unEventoDeportivo.setResultado(unEstadoGanado1);
		assertEquals(unEventoDeportivo.getResultado(),unEstadoGanado1);	
	}
	
	@Test public void  testSeModificaElEstadoActualDelEvento() {
		//no lo toma bien por que toma identidad assertEquals(unEventoDeportivo.getEstado(), new NoComenzado());
		unEventoDeportivo.setEstado(estadoFinalizado);
	assertEquals(unEventoDeportivo.getEstado(), estadoFinalizado);
		
		
	}

}


