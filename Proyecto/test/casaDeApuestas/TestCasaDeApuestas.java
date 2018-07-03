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

	private CasaDeApuestas casaDeApuestas1, casaDeApuestas, casaDeApuestasMock;
	private ArrayList<User> usuariosEmpty, usuarios;
	private ArrayList<EventoDeportivo> eventosEmpty;
	private User usuarioMock1;
	private AlgoritmoProbabilidades algoritmoMock;
	private EventoDeportivo eventoDeportivoMock, eventoDeportivoMock2;
	private BalanceNotifier balanceMock;
	private CompetenciaHistoricaDirecta algoritmoHistorico;

	@Before
	public void setUp() throws Exception {

		eventosEmpty = new ArrayList<EventoDeportivo>();
		eventoDeportivoMock = mock(EventoDeportivo.class);
		eventoDeportivoMock2 = mock(EventoDeportivo.class);
		balanceMock = mock(TextMessageBalanceNotifier.class);
		algoritmoMock = mock(AlgoritmoProbabilidades.class);

	}

	@Test
	public void testSeAgregaUnaNuevaApuestasALaCasaDeApuestas() {
		casaDeApuestas = new CasaDeApuestas(usuarios, algoritmoMock, balanceMock, eventosEmpty);

		assertEquals(casaDeApuestas.getUsuarios(), usuarios);
		assertEquals(casaDeApuestas.getEventosDeportivos(), eventosEmpty);

	}

	@Test
	public void testSeIngresaUnNuevoUsuario() {
		ArrayList<User> usuariosSpy = spy(new ArrayList<User>());
		casaDeApuestas1 = new CasaDeApuestas(usuariosSpy, algoritmoMock, balanceMock, eventosEmpty);
		casaDeApuestas1.agregarUsuario(usuarioMock1);

		verify(usuariosSpy).add(usuarioMock1);
		assertEquals(casaDeApuestas1.getUsuarios(), usuariosSpy);

	}

	@Test
	public void testSeIngresaUnEventoDeportivo() {

		ArrayList<EventoDeportivo> spyEventos = spy(new ArrayList<EventoDeportivo>());
		casaDeApuestas1 = new CasaDeApuestas(usuariosEmpty, algoritmoMock, balanceMock, spyEventos);
		casaDeApuestas1.agregarEvento(eventoDeportivoMock);

		assertEquals(casaDeApuestas1.getEventosDeportivos().size(), 1);
		verify(spyEventos).add(eventoDeportivoMock);
		assertEquals(casaDeApuestas1.getEventosDeportivos(), spyEventos);

	}

	@Test
	public void testSeCreaUnEventoDeportivo() {
		casaDeApuestas = new CasaDeApuestas(usuarios, algoritmoMock, balanceMock, eventosEmpty);
		casaDeApuestasMock = mock(CasaDeApuestas.class);

		casaDeApuestas.agregarEvento(eventoDeportivoMock);
		casaDeApuestas.agregarEvento(eventoDeportivoMock2);

		when(eventoDeportivoMock2.nombreDeporte()).thenReturn("Tenis");
		assertEquals("Tenis", (eventoDeportivoMock2.nombreDeporte()));
		assertEquals(casaDeApuestas.getEventosDeportivos().size(), 2);

	}

	@Test
	public void testLaCasaDeApuestasConoceSusEventosFinalizados() {

		casaDeApuestas = new CasaDeApuestas(usuarios, algoritmoMock, balanceMock, eventosEmpty);
		ArrayList<EventoDeportivo> finalizados = new ArrayList<EventoDeportivo>();

		assertTrue(casaDeApuestas.getEventosFinalizados().isEmpty());

		casaDeApuestas.agregarEvento(eventoDeportivoMock);
		casaDeApuestas.agregarEvento(eventoDeportivoMock2);

		when(eventoDeportivoMock2.estaFinalizado()).thenReturn(true);
		when(eventoDeportivoMock.estaFinalizado()).thenReturn(true);
		finalizados.add(eventoDeportivoMock);
		finalizados.add(eventoDeportivoMock2);
		assertEquals(casaDeApuestas.getEventosFinalizados(), finalizados);

	}

}
