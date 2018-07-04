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
	
	@Test	
	public void testGetCuotaOponente1() {
		
		when(dummyCasa.calcularProbabilidadGanador(river, boca)).thenReturn(new Float(0.5));
		
		EventoDeportivo eve = new EventoDeportivo(dummyCasa, unDeporteFutbol, river, boca, fechaYHora, "Francia");
		
		Float total = eve.getCuotaOponente1();
		
		assertEquals(total, new Float(1.5));
		
	}
	
	@Test	
	public void testGetCuotaOponente2() {
		
		when(dummyCasa.calcularProbabilidadGanador(boca, river)).thenReturn(new Float(0.5));
		
		EventoDeportivo eve = new EventoDeportivo(dummyCasa, unDeporteFutbol, river, boca, fechaYHora, "Francia");
		
		Float total = eve.getCuotaOponente2();
		
		assertEquals(total, new Float(1.5));
		
		
	}
	
	@Test	
	public void testGetCuotaEmpate() {
		
		when(dummyCasa.calcularProbabilidadEmpate(river, boca)).thenReturn(new Float(0.2));
		
		EventoDeportivo eve = new EventoDeportivo(dummyCasa, unDeporteFutbol, river, boca, fechaYHora, "Francia");
		
		Float total = eve.getCuotaEmpate();
		
		assertEquals(total, new Float(1.8));
				
		
	}
	
	@Test	
	public void testGetEstado() {
		
		NoComenzado estado = new NoComenzado();
		
		unEventoDeportivo.setEstado(estado);
		
		assertEquals(unEventoDeportivo.getEstado(), estado);	
		
	}
	
	@Test	
	public void testGetResultado() {
		
		unEventoDeportivo.setResultado(resultadoGanadorRiver);
		
		assertEquals(unEventoDeportivo.getResultado(), resultadoGanadorRiver);
		
	}
	
	@Test	
	public void testGetGanador() {
		
		unEventoDeportivo.setResultado(resultadoGanadorRiver);
		
		assertEquals(unEventoDeportivo.getGanador(), river);
		
	}
	
	@Test	
	public void testEsDelMes() {
		
		assertTrue(this.unEventoDeportivo.esDelMes(2));
		
	}
	
	@Test	
	public void testElEventoNoEsDelMes() {
		assertFalse(this.unEventoDeportivo.esDelMes(8));
	}
	
	@Test	
	public void testElEventoHaComenzado() {		
		
		unEventoDeportivo.setEstado(estadoFinalizado);
		
		assertFalse(unEventoDeportivo.haComenzado());
		
	}
	
	@Test	
	public void testElEventoHaHaTerminado() {
		
		unEventoDeportivo.setEstado(estadoFinalizado);
		
		assertTrue(unEventoDeportivo.haTerminado());
		
	}
	
	@Test
	public void testUnEventoDeportivoNoParticipoUnoDeLosOponentes() {
		Oponente sanLorenzo = mock(Oponente.class); 
		assertFalse(unEventoDeportivo.participaronVs(boca, sanLorenzo));
	}
	
	@Test
	public void testUnEventoDeportivoNoParticipoElOtroDeLosOponentes() {
		Oponente sanLorenzo = mock(Oponente.class); 
		assertFalse(unEventoDeportivo.participaronVs(sanLorenzo, river));
	}
	
}


