package usuarios;

import apuesta.Apuesta;
import apuesta.Final;
import apuesta.TipoApuesta;
import casaDeApuesta.CasaDeApuestas;
import eventoDeportivo.EventoDeportivo;
import resultados.Resultado;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;

import algoritmo.AlgoritmoProbabilidades;
import algoritmo.CompetenciaHistoriaReciente;
import apuesta.TipoApuesta;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.spi.TimeZoneNameProvider;

public class TestsUsuarios {
	private User usuario1;
	private Apuesta apuestaMock;
	private Apuesta apuesta1;

	private EventoDeportivo eventoDeportivoMock;

	private Final tipoDeApuestaMock;
	private Float unMonto; 
	private Resultado resultadoMock;
	private CasaDeApuestas casaMock;
	
	
	@Before
	public	void setUp() throws Exception {	
	eventoDeportivoMock= mock(EventoDeportivo.class);
	EstadoEventoDeportivo resultado1 = mock(EstadoEventoDeportivo.class);//ver como poner el tema de los resultados
	tipoDeApuestaMock= mock(Final.class);
	usuario1= mock(User.class);
	unMonto = (float)400 ;
	resultadoMock = mock(Resultado.class);
	casaMock= mock(CasaDeApuestas.class);
	apuestaMock= mock(Apuesta.class);
	//apuesta1= new Apuesta(unMonto, eventoDeportivoMock, resultadoMock,tipoDeApuestaMock,casaMock);
	}
	
	

	@Test
	public	void testUnUsuarioAgregaUnaNuevaApuesta() {
		//List<Apuesta> spyApuestas= spy(new ArrayList <Apuesta>());		
		usuario1.agregarNuevaApuesta(apuestaMock);
		verify(usuario1, (usuario1.apuestasPropias().add(apuestaMock)));
	}

	/*
	@Test//la idea es que ante una apuesta ganadora se sepa la ganacia neta.hay que ver como se toma el resultado. se tiene que poner 
	public	void testunUsuarioHaceUnaApuestaGanadoraYTieneGananciaNetaYBruta(){

		usuario1.agregarNuevaApuesta(apuestaDummy);
		apuestaDummy.
		
		when(tipoDeApuestaMock.resultado()).thenReturn(Ganador); //o su paralelo
		assertEquals(gananciaNeta(CasaDeApuestas _casa))
		
	}
	
	
	@Test
	public	void testUsuarioHaceUnaApuestaYNoTieneTieneGanacia() {
		
		
	}*/
}
