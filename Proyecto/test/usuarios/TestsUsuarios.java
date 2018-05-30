package usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apuesta.*;
import casaDeApuesta.CasaDeApuestas;
import eventoDeportivo.EventoDeportivo;
import oponentes.*;
import usuarios.User;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

class TestsUsuarios {
	private User usuario1;
	private Apuesta apuestaDummy;
	private Apuesta apuesta1;
	private EventoDeportivo eventoDeportivo1;
	private Apuesta tipoDeApuestaMock;
	
	@BeforeEach
	
	
	
	void setUp() throws Exception {
		eventoDeportivo1= mock(EventoDeportivo.class);
		resultado1= mock(Resultado.class);//ver como poner el tema de los resultados
		tipoDeApuestaMock= mock(Apuesta.class);
		usuario1= new User();
		apuesta1= new Apuesta(400, eventoDeportivo1, resultado1,tipoDeApuesta);

		
	}
	
	
	

	@Test
	void testUnUsuarioAgregaUnaNuevaApuesta() {
		List<Apuesta> spyApuestas= spy(new ArrayList <Apuesta>());		

		usuario1.agregarNuevaApuesta(apuesta1);
		verify((usuario1.apuestasPropias()).add(apuestaDummy));
		
	}

	
	@Test//la idea es que ante una apuesta ganadora se sepa la ganacia neta.hay que ver como se toma el resultado. se tiene que poner 
	void testunUsuarioHaceUnaApuestaGanadoraYTieneGananciaNetaYBruta(){

		usuario1.agregarNuevaApuesta(apuestaDummy);
		apuestaDummy.
		
		when(tipoDeApuestaMock.resultado()).thenReturn(Ganador); //o su paralelo
		assertEquals(gananciaNeta(CasaDeApuestas _casa))
		
	}
	
	
	@Test
	void testUsuarioHaceUnaApuestaYNoTieneTieneGanacia() {
		
		
	}
}
