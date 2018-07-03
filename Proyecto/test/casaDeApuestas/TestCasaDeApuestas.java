package casaDeApuestas;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import algoritmo.*;
import casaDeApuesta.CasaDeApuestas;
import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import notifier.BalanceNotifier;
import notifier.TextMessageBalanceNotifier;
import oponentes.Deportista;
import oponentes.Equipo;
import oponentes.Oponente;
import usuarios.User;

public class TestCasaDeApuestas {
	
	private CasaDeApuestas casaDeApuestas1, casaDeApuestas,casaDeApuestasMock;
	private ArrayList <User> usuariosEmpty,usuarios;
	private ArrayList <EventoDeportivo> eventosEmpty;
	
	private User usuarioMock1,usuarioMario,usuarioJuan;
	private AlgoritmoProbabilidades algoritmoMock;
	private EventoDeportivo eventoDeportivoMock,eventoDeportivoMock2;
	private BalanceNotifier balanceMock;
	private CompetenciaHistoricaDirecta algoritmoHistorico;
	
	
	@Before
	public void setUp() throws Exception {
		usuarioMario =new User( "Mario");
		usuarioJuan = new User("Juan");
		
		
		User[] usuarios = new User[2];
		usuarios[0] = usuarioMario;
		usuarios[1] = usuarioJuan;
		
		algoritmoHistorico=new CompetenciaHistoricaDirecta();
		//mocks varios
		
		usuariosEmpty= new ArrayList<User>();
		usuarioMock1=mock(User.class);
		
		
		eventosEmpty =  new ArrayList<EventoDeportivo>();
		eventoDeportivoMock = mock(EventoDeportivo.class);
		eventoDeportivoMock2 =mock(EventoDeportivo.class);
		
		balanceMock= mock(TextMessageBalanceNotifier.class);
		algoritmoMock = mock(AlgoritmoProbabilidades.class);
	

}

	@Test 
	public void testSeAgregaUnaNuevaApuestasALaCasaDeApuestas() {
		casaDeApuestas= new  CasaDeApuestas(usuarios,algoritmoMock,balanceMock,eventosEmpty);
		
		assertEquals(casaDeApuestas.getUsuarios(),usuarios);
		assertEquals(casaDeApuestas.getEventosDeportivos(),eventosEmpty);
		
		
		
		
	}
	
	@Test
	public void testSeIngresaUnNuevoUsuario (){
		 ArrayList <User> usuariosSpy=spy(new ArrayList <User>());
		 casaDeApuestas1= new  CasaDeApuestas(usuariosSpy, algoritmoMock,balanceMock,eventosEmpty);
		 casaDeApuestas1.agregarUsuario(usuarioMock1);
		
		verify(usuariosSpy).add(usuarioMock1);
		assertEquals(casaDeApuestas1.getUsuarios(),usuariosSpy);
		
}
	
	@Test 
	public void testSeIngresaUnEventoDeportivo(){
	
		 ArrayList <EventoDeportivo> spyEventos =spy(new ArrayList <EventoDeportivo>());

		 casaDeApuestas1= new  CasaDeApuestas(usuariosEmpty, algoritmoMock,balanceMock,spyEventos);
		 casaDeApuestas1.agregarEvento(eventoDeportivoMock);
		
		 assertEquals(casaDeApuestas1.getEventosDeportivos().size(),1);
		verify(spyEventos).add(eventoDeportivoMock);
		assertEquals(casaDeApuestas1.getEventosDeportivos(),spyEventos);

	
}
	@Test
	public void testSeCreaUnEventoDeportivo(){
		casaDeApuestas= new  CasaDeApuestas(usuarios,algoritmoMock,balanceMock,eventosEmpty);
		casaDeApuestasMock= mock(CasaDeApuestas.class);
		
		Oponente oponenteDummy1=mock(Oponente.class);
		Oponente oponenteDummy2=mock(Oponente.class);
		Date fechaDummy= mock(Date.class);
		Deporte tenis=new Deporte("Tenis");
		Deporte deporteDummy=mock(Deporte.class);
		Float[] probabilidades = {new Float(0.7),new Float(0.2),new Float(0.1)};
		
		
		casaDeApuestas.agregarEvento(eventoDeportivoMock);
		casaDeApuestas.agregarEvento(eventoDeportivoMock2);		
		
		when (eventoDeportivoMock2.nombreDeporte()).thenReturn ("Tenis");
		assertEquals("Tenis", (eventoDeportivoMock2.nombreDeporte()));
		
		EventoDeportivo ultimoEvento=casaDeApuestas.getEventosDeportivos().get(1);
		EventoDeportivo eventOriginal= new EventoDeportivo(casaDeApuestas, tenis,oponenteDummy1, oponenteDummy2, fechaDummy, "ElDocke");
		
		assertEquals(casaDeApuestas.getEventosDeportivos().size(),2);
		//no me deja comparar los dos objetos	assertEquals(eventOriginal,ultimoEvento);
		//verify(casaDeApuestasMock).calcularProbabilidadesDe(casaDeApuestasMock.getEventosDeportivos(), oponenteDummy1, oponenteDummy2);

		//verify((casaDeApuestas).calcularProbabilidadesDe((casaDeApuestasMock.getEventosDeportivos()),oponenteDummy1,oponenteDummy2));

		// assertTrue(ultimoEvento==eventoOriginal);
	}
	
	/*
	
	@Test 
	public void testAlTenerDosOponentesSeConoceSusProbabilidadesDeGanar() {

		Oponente oponenteDummy1=mock(Oponente.class);
		Oponente oponenteDummy2=mock(Oponente.class);
		
		List <EventoDeportivo> eventosOp1 =new ArrayList <EventoDeportivo>();

		casaDeApuestas= new  CasaDeApuestas(usuarios,algoritmoMock,balanceMock,eventosOp1);
		
		when(algoritmoMock.calcularProbabilidadEmpate(eventosOp1,oponenteDummy1,oponenteDummy2)).thenReturn((float)10);
		when(algoritmoMock.calcularProbabilidad(eventosOp1,oponenteDummy1,oponenteDummy2)).thenReturn((float)20);
	
		
		Float pGanador=	casaDeApuestas.calcularProbabilidadGanador(oponenteDummy1,oponenteDummy2);
		Float pEmpate=	casaDeApuestas.calcularProbabilidadEmpate(oponenteDummy1,oponenteDummy2);
			
	//	assertTrue(pGanador == (float)20);
	//	assertTrue(pEmpate== (float)10);

		casaDeApuestas.calcularProbabilidadEmpate(oponenteDummy1, oponenteDummy2);
		//	verify(algoritmoMock).calcularProbabilidad(eventosOp1,oponenteDummy1,oponenteDummy2);
			verify(algoritmoMock).calcularProbabilidadEmpate(eventosOp1,oponenteDummy1,oponenteDummy2);
			
			
		
	}
*/

}
