package usuarios;

import apuesta.Apuesta;
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

 	@Before
 		

		public	void setUp() throws Exception {
		
		eventoDeportivoMock= mock(EventoDeportivo.class);
		EstadoEventoDeportivo resultado1 = mock(EstadoEventoDeportivo.class);//ver como poner el tema de los resultados
		tipoDeApuestaMock= mock(Apuesta.class);
		usuario1= new User();
		apuesta1= new Apuesta(unMonto, eventoDeportivo1, resultado1,tipoDeApuesta);
		tipoDeApuestaMock= mock(Final.class);
		usuario1= mock(User.class);
		unMonto = (float)400 ;
		eventoDeportivo1= mock(EventoDeportivo.class);
		resultadoMock = mock(Resultado.class);
		casaMock= mock(CasaDeApuestas.class);
		apuestaMock= mock(Apuesta.class);
	//apuesta1= new Apuesta(unMonto, eventoDeportivoMock, resultadoMock,tipoDeApuestaMock,casaMock);

 
		
 	}
 	
 	
 	
 
 	@Test
 	public	void testUnUsuarioAgregaUnaNuevaApuesta() {
		List<Apuesta> spyApuestas= spy(new ArrayList <Apuesta>());		
	//List<Apuesta> spyApuestas= spy(new ArrayList <Apuesta>());		
 
		usuario1.agregarNuevaApuesta(apuesta1);
		verify((usuario1.apuestasPropias()).add(apuestaDummy));
		usuario1.agregarNuevaApuesta(apuestaMock);
	verify(usuario1, (usuario1.apuestasPropias().add(apuestaMock)));
 		
 	}