package eventoDeportivo;

import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import apuesta.Apuesta;
import casaDeApuesta.CasaDeApuestas;
import eventoDeportivo.EventoDeportivo;
import resultados.Resultado;
import oponentes.Equipo;
import oponentes.Oponente;
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
import java.util.ArrayList;

public class TestEventoDeportivo {

	private Deporte unDeporteFutbol,deporteBoxeo;
	private EventoDeportivo unEventoDeportivo,otroEventoDeportivo, mockEventoDeportivo;
	private Oponente boca,river,chacarita;
	
	private Date fechaYHora;	
	 
	private Resultado resultadoEmpatado,resultadoGanadorRiver;

	private EstadoEventoDeportivo estadoFinalizado;
	private CasaDeApuestas dummyCasa;
	
	
	@Before
	public void setUp(){
		fechaYHora = new Date(2,2,2);
		river = mock(Equipo.class);
		boca = mock(Equipo.class);
		chacarita =  mock(Equipo.class);
		
		unDeporteFutbol = new Deporte("Futbol");
		deporteBoxeo=new Deporte("Boxeo");
		
		resultadoEmpatado=new Empate();
		resultadoGanadorRiver=new Ganado(river);
		dummyCasa=mock(CasaDeApuestas.class);	
		estadoFinalizado = new Finalizado();
		
		unEventoDeportivo= new EventoDeportivo(dummyCasa, unDeporteFutbol, river, boca, fechaYHora, "Francia");
		mockEventoDeportivo=mock(EventoDeportivo.class);

		
	}	
	

	@Test
	public void unEventoDeportivoAlComenzarModificaSuEstado() {
		assertFalse(unEventoDeportivo.estaFinalizado());
		assertFalse(unEventoDeportivo.empezoEvento());
		assertEquals((unEventoDeportivo.getDeporte()),unDeporteFutbol);	
		
		unEventoDeportivo.setEstado(estadoFinalizado);
		
		assertTrue(unEventoDeportivo.estaFinalizado());
		
	}
	
	@Test 
	public void testCompararSiUnOponenteParticipoEnElEvento() {
		assertTrue(unEventoDeportivo.esDeDeporte(unDeporteFutbol));
		assertFalse(unEventoDeportivo.esDeDeporte(deporteBoxeo));
		assertFalse(unEventoDeportivo.participo(chacarita));
		assertTrue(unEventoDeportivo.participo(river));
		assertTrue(unEventoDeportivo.participaronVs(river,boca));
		assertFalse (unEventoDeportivo.participaronVs(chacarita,boca));
		
		ArrayList <Oponente >oponentes= new ArrayList<Oponente>();
		oponentes.add(river);
		oponentes.add(boca);
		
		assertEquals(unEventoDeportivo.getOponentes(),oponentes);
	}
	
	@Test 
	public void testAlIngresarElresultadoSeNotifica() {
		unEventoDeportivo.setResultado(resultadoEmpatado);
		assertEquals(unEventoDeportivo.getResultado(),resultadoEmpatado);
	
		unEventoDeportivo.setResultado(resultadoGanadorRiver);
		assertEquals(unEventoDeportivo.getResultado(),resultadoGanadorRiver);
		assertTrue(unEventoDeportivo.participaronVs(boca ,river));
	} 
	
		
	
	
		/*
		 * 
		 * 
		 * 
		
	//dummyCasa, unDeporteFutbol, river, boca, fechaYHora, "Francia"
	@Test 
	public void testAlCrearUnEventoDeportivoSeCalCulanLasCuotas() {
		otroEventoDeportivo= mock(EventoDeportivo.class);
	//	new EventoDeportivo(dummyCasa, unDeporteFutbol, river, boca, fechaYHora, "Francia")).calcularCuota((float)100);
	
		dummyCasa.calcularProbabilidadGanador(river, boca)
		when(dummyCasa.calcularProbabilidadGanador(river, boca)).thenReturn(new Float(100));
		when(dummyCasa.calcularProbabilidadGanador(river, boca)).thenReturn(new Float(100));
		
		verify(otroEventoDeportivo)
		//when(mockEventoDeportivo.getCuotaEmpate()).thenReturn(new Float(200));
		//when(mockEventoDeportivo.getCuotaOponente2()).thenReturn(new Float(300));
		
		 assertEquals(mockEventoDeportivo.getCuotaOponente1(),(float)100,0);
		 assertEquals( mockEventoDeportivo.getCuotaEmpate(),(float)(200),0);
		 assertEquals(mockEventoDeportivo.getCuotaOponente2(),(float)300,0);		
		
		
	}
	
	

	/*
	@Test
	public void testEsDeUnDeterminadoDeporte() {
		assertTrue(unEventoDeportivo.esDeDeporte(unDeporte));
	}
	
	@Test
	public void testNoEsDeUnDeterminadoDeporte() {
		Deporte otroDeporte = new Deporte("Natacion");
		assertFalse(unEventoDeportivo.esDeDeporte(otroDeporte));
	}
	
	@Test
	public void testSeJugoEnUnDeterminadoLugar() {
		assertTrue(unEventoDeportivo.seJugoEn(new String("Francia")));
	}
	
	@Test
	public void testNoSeJugoEnUnDeterminadoLugar() {
		assertFalse(unEventoDeportivo.seJugoEn(new String("Marte")));
	}
	
	@Test
	public void testSeJugoEnUnaDeterminadaFecha() {
		assertTrue(unEventoDeportivo.sucedioEn(fechaYHora));
	}
	
	@Test
	public void testNoSeJugoEnUnaDeterminadaFecha() {
		Date fechaCualquiera = new Date(4, 4, 4);
		assertFalse(unEventoDeportivo.sucedioEn(fechaCualquiera));
	}
	*/
}


