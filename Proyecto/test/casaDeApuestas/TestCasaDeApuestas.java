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
	private EventoDeportivo eventoDeportivoMock;
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
	
		balanceMock= mock(TextMessageBalanceNotifier.class);
		algoritmoMock = mock(AlgoritmoProbabilidades.class);
	

}

	@Test 
  public void testSeAgregaUnaNuevaApuestasALaCasaDeApuestas() {
		casaDeApuestas= new  CasaDeApuestas(usuarios,algoritmoHistorico,balanceMock,eventosEmpty);
		
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

	
}//ver manana 
	@Test
	public void testSeCreaUnEventoDeportivo(){
		casaDeApuestas= new  CasaDeApuestas(usuarios,algoritmoHistorico,balanceMock,eventosEmpty);
		casaDeApuestasMock= mock(CasaDeApuestas.class);
		
		Oponente oponenteDummy1=mock(Oponente.class);
		Oponente oponenteDummy2=mock(Oponente.class);
		Date fechaDummy= mock(Date.class);
		Deporte tenis=new Deporte("Tenis");
		Deporte deporteDummy=mock(Deporte.class);
		Float[] probabilidades = {new Float(0.7),new Float(0.2),new Float(0.1)};
		
		
		casaDeApuestas.agregarEvento(eventoDeportivoMock);
		casaDeApuestas.agregarEvento(eventoDeportivoMock);		
		
		EventoDeportivo ultimoEvento=casaDeApuestas.getEventosDeportivos().get(2);
		EventoDeportivo eventOriginal= new EventoDeportivo(casaDeApuestas, tenis,oponenteDummy1, oponenteDummy2, fechaDummy, "ElDocke");
		
		assertEquals(casaDeApuestas.getEventosDeportivos().size(),3);
		assertEquals("Tenis", (ultimoEvento.nombreDeporte()));
		//no me deja comparar los dos objetos	assertEquals(eventOriginal,ultimoEvento);
		//verify(casaDeApuestasMock).calcularProbabilidadesDe(casaDeApuestasMock.getEventosDeportivos(), oponenteDummy1, oponenteDummy2);

		//verify((casaDeApuestas).calcularProbabilidadesDe((casaDeApuestasMock.getEventosDeportivos()),oponenteDummy1,oponenteDummy2));

		// assertTrue(ultimoEvento==eventoOriginal);
	}
	
	
	
	
	@Test //raro y mal 
	public void testAlTenerDosOponentesSeConoceSusProbabilidadesDeGanar() {

		Oponente oponenteDummy1=mock(Oponente.class);
		Oponente oponenteDummy2=mock(Oponente.class);
		
		Float[] probabilidades = {new Float(0.7),new Float(0.2),new Float(0.1)};
		List <EventoDeportivo> eventosOp1 =new ArrayList <EventoDeportivo>();

		
		AlgoritmoProbabilidades algPro =mock(AlgoritmoProbabilidades.class);
	
		
		casaDeApuestas= new  CasaDeApuestas(usuarios,algPro,balanceMock,eventosOp1);
		Date fechaDummy= mock(Date.class);
		
	
		//mmmm ver .... 
		//when(algPro.calcularProbabilidad(eventosOp1,oponenteDummy1,oponenteDummy2)).thenReturn(probabilidades);
		//Float[] probabilidadesFinal =  casaDeApuestas.calcularProbabilidadesDe( oponenteDummy1, oponenteDummy2);
		
		//assertEquals(probabilidadesFinal[0],new Float(0.7));
		//assertEquals(probabilidadesFinal[1],new Float(0.2));
		//assertEquals(probabilidadesFinal[2],new Float(0.1));
		
		//Float[] calcularProbabilidadesDe(List<EventoDeportivo> eventoHistorico, Oponente _op1, Oponente _op2)
		
	}


}
