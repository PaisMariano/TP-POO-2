package usuarios;

import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;

import java.util.List;

public class TestsUsuarios {
	private User usuario1;
	private Apuesta apuestaDummy;
	private Apuesta apuesta1;
	private EventoDeportivo eventoDeportivo1;
	private Apuesta tipoDeApuestaMock;
	
	@Before
	
	
	
	public	void setUp() throws Exception {
		eventoDeportivo1= mock(EventoDeportivo.class);
		EstadoEventoDeportivo resultado1 = mock(EstadoEventoDeportivo.class);//ver como poner el tema de los resultados
		tipoDeApuestaMock= mock(Apuesta.class);
		usuario1= new User();
		apuesta1= new Apuesta(400, eventoDeportivo1, resultado1,tipoDeApuesta);

		
	}
	
	
	

	@Test
	public	void testUnUsuarioAgregaUnaNuevaApuesta() {
		List<Apuesta> spyApuestas= spy(new ArrayList <Apuesta>());		

		usuario1.agregarNuevaApuesta(apuesta1);
		verify((usuario1.apuestasPropias()).add(apuestaDummy));
		
	}

	
	@Test//la idea es que ante una apuesta ganadora se sepa la ganacia neta.hay que ver como se toma el resultado. se tiene que poner 
	public	void testunUsuarioHaceUnaApuestaGanadoraYTieneGananciaNetaYBruta(){

		usuario1.agregarNuevaApuesta(apuestaDummy);
		apuestaDummy.
		
		when(tipoDeApuestaMock.resultado()).thenReturn(Ganador); //o su paralelo
		assertEquals(gananciaNeta(CasaDeApuestas _casa))
		
	}
	
	
	@Test
	public	void testUsuarioHaceUnaApuestaYNoTieneTieneGanacia() {
		
		
	}
}
