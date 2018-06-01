package casaDeApuestas;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import algoritmo.AlgoritmoProbabilidades;
import algoritmo.CompetenciaHistoriaReciente;
import algoritmo.CompetenciaHistoricaDirecta;
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
		usuarioMario =new User();
		usuarioJuan = new User();
		
		
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
		casaDeApuestasMock=mock(CasaDeApuestas.class);

		
		
}

	@Test 
  public void testSeCreaUnaCasaDeApuestasNueva() {
		casaDeApuestas= new  CasaDeApuestas(usuarios,algoritmoHistorico,balanceMock,eventosEmpty);
		
		assertEquals(casaDeApuestas.getUsuarios(),usuarios);
		assertEquals(casaDeApuestas.getEventosDeportivos(),eventosEmpty);
		
		
	}
	
	@Test
	public void testSeIngresaUnNuevoUsuario (){
		 ArrayList <User> usuariosSpy=spy(new ArrayList <User>());
		 casaDeApuestas1= new  CasaDeApuestas(usuariosSpy, algoritmoMock,balanceMock,eventosEmpty);
		 casaDeApuestas1.agregarusuario(usuarioMock1);
		
		verify(usuariosSpy).add(usuarioMock1);
		assertEquals(casaDeApuestas1.getUsuarios(),usuariosSpy);
		
}
	
	@Test 
	public void testSeIngresaUnEventoDeportivo(){
	
		 ArrayList <EventoDeportivo> spyEventos =spy(new ArrayList <EventoDeportivo>());

		 casaDeApuestas1= new  CasaDeApuestas(usuariosEmpty, algoritmoMock,balanceMock,spyEventos);
		 casaDeApuestas1.agregarEvento(eventoDeportivoMock);
		
		verify(spyEventos).add(eventoDeportivoMock);
		assertEquals(casaDeApuestas1.getEventosDeportivos(),spyEventos);

	
}
	@Test
	public void testSeCreaUnEventoDeportivo(){
		
		Oponente oponenteDummy1=mock(Oponente.class);
		Oponente oponenteDummy2=mock(Oponente.class);
		Date fechaDummy= mock(Date.class);
		Deporte tenis=mock(Deporte.class);
		EventoDeportivo evDummy= mock(EventoDeportivo.class);
		casaDeApuestasMock.crearEventoDeportivo(oponenteDummy1, oponenteDummy2,tenis, fechaDummy, "ElDocke");
		
		//verify(casaDeApuestasMock).calcularProbabilidadesDe((casaDeApuestasMock.getEventosDeportivos()),oponenteDummy1,oponenteDummy2);
		verify(casaDeApuestasMock).agregarEvento(evDummy);
	}
	
	

}
