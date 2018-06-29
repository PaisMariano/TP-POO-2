package usuarios;

import usuarios.User;
import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;

import org.junit.Before; 
import org.junit.Test;
import org.mockito.InOrder;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;
import usuarios.*;

public class TestsUsuarios{
	
 		Apuesta apuestaMock;
 		EventoDeportivo eventoDeportivoMock,resultado1;
 		User usuario1;
 	
 		@Before
		public	void setUp() throws Exception {
		
		eventoDeportivoMock= mock(EventoDeportivo.class);
		apuestaMock = mock(Apuesta.class);
		usuario1 = new User("pepe@gmail.com"); 
		
 		}
 		
 		
 	@Test
 	public void testSeAgregaUnaApuestaAlUsuarioYSeIncrementanLasPropias() {
 		
 		assertTrue(usuario1.apuestasPropias().isEmpty());
 		
 		usuario1.agregarNuevaApuesta(apuestaMock);
 		assertEquals(usuario1.apuestasPropias().size(),1);
 				
 		
 	}
 	
 		
	@Test
	public	void testLasGanaciasNetasSeDeterminanSegunElMes(){

		usuario1.agregarNuevaApuesta(apuestaDummy);
		apuestaDummy.
		when(tipoDeApuestaMock.resultado()).thenReturn(Ganador); //o su paralelo
		assertEquals(gananciaNeta(CasaDeApuestas _casa))
	}
	
	@Test
	public	void testUsuarioHaceUnaApuestaYNoTieneTieneGanacia() {
		
	}
 		*/
}
