package usuarios;

import usuarios.User; 
import apuesta.Apuesta;
import apuesta.Segura;
import apuesta.TipoApuesta;
import eventoDeportivo.EventoDeportivo;
import resultados.Resultado;
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
		User usuario1;
 		Apuesta apuestaMockEnero,apuestaMockJunio,apuesta;
 		EventoDeportivo eventoDeportivoMock,eventoDeportivoMock2;
 		
 		Interesante interesanteMock;
 		Resultado resultado;
 		Segura tipoDeApuesta;
 		
 		@Before
		public	void setUp() throws Exception {

		usuario1 = new User("pepe@gmail.com"); 

		apuestaMockEnero = mock(Apuesta.class);
		apuestaMockJunio = mock(Apuesta.class);
 		resultado = mock(Resultado.class);
 		tipoDeApuesta = mock(Segura.class);
		eventoDeportivoMock2=mock(EventoDeportivo.class);
		eventoDeportivoMock= mock(EventoDeportivo.class);
		apuesta=new Apuesta((float)10,eventoDeportivoMock,resultado,tipoDeApuesta);

		when(apuestaMockJunio.getEventoDeInteres()).thenReturn(eventoDeportivoMock);
		when(apuestaMockEnero.getEventoDeInteres()).thenReturn(eventoDeportivoMock);

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
		when(apuestaMockJunio.esApuestaDelMes(1)).thenReturn(false); 
		when((apuestaMockEnero).gananciaBruta()).thenReturn(new BigDecimal(100));
		
		usuario1.gananciaBruta(1);
		
		verify(apuestaMockEnero).gananciaBruta();
		verify(apuestaMockJunio,never()).gananciaBruta();
				
		
		when((apuestaMockEnero).gananciaNeta()).thenReturn(new BigDecimal(100));
		usuario1.gananciaNeta(1);
		
		verify(apuestaMockEnero).gananciaNeta();
		verify(apuestaMockJunio,never()).gananciaNeta();
				
		
		
		
	}
	
	@Test
	public	void testElUsuarioSeInteresaPorLosEventoQueApuesta() {


		interesanteMock=mock(Interesante.class);
		
		usuario1.agregarNuevaApuesta(apuestaMockJunio);
		usuario1.agregarNuevaApuesta(apuestaMockEnero);
		
		when(apuestaMockJunio.getEventoDeInteres()).thenReturn(interesanteMock);
		
		assertTrue(usuario1.leInteresa(interesanteMock));
		
	}    
 		
}
	

	
	
	

