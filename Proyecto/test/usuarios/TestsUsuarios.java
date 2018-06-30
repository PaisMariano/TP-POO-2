package usuarios;

import usuarios.User;
import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import eventoDeInteres.Interesante;

import java.math.BigDecimal;
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
	
 		Apuesta apuestaMockEnero,apuestaMockJunio;
 		EventoDeportivo eventoDeportivoMock,eventoDeportivoMock2;
 		User usuario1;
 		Interesante interesanteMock;
 		
 		
 		
 		@Before
		public	void setUp() throws Exception {
		eventoDeportivoMock2=mock(EventoDeportivo.class);
		eventoDeportivoMock= mock(EventoDeportivo.class);
		apuestaMockEnero = mock(Apuesta.class);
		apuestaMockJunio = mock(Apuesta.class);
		usuario1 = new User("pepe@gmail.com"); 
		
 		}
 		
 		
 	@Test
 	public void testSeAgregaUnaApuestaAlUsuarioYSeIncrementanLasPropias() {
 		
 		assertTrue(usuario1.apuestasPropias().isEmpty());
 		
 		usuario1.agregarNuevaApuesta(apuestaMockEnero);
 		assertEquals(usuario1.apuestasPropias().size(),1);
 				
 	}
 	
 		
	@Test
	public	void testLasGanaciasNetasYBrutasSeDeterminanSegunElMes(){
		

		usuario1.agregarNuevaApuesta(apuestaMockJunio);
		usuario1.agregarNuevaApuesta(apuestaMockEnero);
		when(apuestaMockEnero.esApuestaDelMes(1)).thenReturn(true);
		when(apuestaMockJunio.esApuestaDelMes(1)).thenReturn(false); //o su paralelo
		when((apuestaMockEnero).gananciaBruta()).thenReturn(new BigDecimal(100));
		
		usuario1.gananciaBruta(1);
		
		verify(apuestaMockEnero).gananciaBruta();
		verify(apuestaMockJunio,never()).gananciaBruta();
				
		
		when((apuestaMockEnero).gananciaNeta()).thenReturn(new BigDecimal(100));
		usuario1.gananciaNeta(1);
		
		verify(apuestaMockEnero).gananciaNeta();
		verify(apuestaMockJunio,never()).gananciaNeta();
				
		
		
		
	}
	
	
	//seguir esto, hacer que cuendo se pregunta por un evento que no se hizo apuesta de false.
	@Test
	public	void testElUsuarioSeInteresaPorLosEventoQueApuesta() {


		interesanteMock=mock(Interesante.class);
		
		usuario1.agregarNuevaApuesta(apuestaMockJunio);
		usuario1.agregarNuevaApuesta(apuestaMockEnero);
		
		when(apuestaMockJunio.getEventoDeInteres()).thenReturn(interesanteMock);
		//when((apuestaMockEnero).get()).thenReturn(new BigDecimal(100));
		
			
		assertTrue(usuario1.leInteresa(interesanteMock));
		
	}
 		
	
	
	
	
	
	
}
