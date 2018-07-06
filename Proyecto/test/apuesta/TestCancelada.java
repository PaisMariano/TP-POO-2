package apuesta;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import estado.EstadoEventoDeportivo;
import eventoDeportivo.EventoDeportivo;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class TestCancelada {
	private Apuesta spyApuesta;
	private TipoApuesta canceladaSUT;
	private EstadoEventoDeportivo spyEstado;

		@Before
		public void setUp() {
			canceladaSUT = new Cancelada();
			spyApuesta = mock(Apuesta.class);
			spyEstado = mock(EstadoEventoDeportivo.class);
		}
		
		@Test
		public void testAlCancelarTiraError() throws Exception{
			try {
                		canceladaSUT.cancelar(spyApuesta);
            		}
            
			catch(Exception e){

	                String mensajeOriginal= new String("Esta apuesta no puede ser cancelada");
	                String mensajeTraido= e.getMessage();
	                assertEquals(mensajeOriginal,mensajeTraido);               
            }


			
		}
		
		@Test
		public void testLaGananciaBrutaEsCero() {
			assertEquals(new BigDecimal(0), canceladaSUT.gananciaBruta(spyApuesta));
		}
		
		@Test
		public void testAlReactivarLoDelegaEnELEstadoDelPartidoDeLaApuesta(){
			
			when(spyApuesta.elEstadoDelPartidoDeLaApuesta()).thenReturn(spyEstado);
			
			canceladaSUT.reactivar(spyApuesta);
			
			verify(spyApuesta).elEstadoDelPartidoDeLaApuesta();
			verify(spyEstado).reactivar(spyApuesta);
		}
}
