package apuesta;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;

	public class TestFinal {
		private Apuesta stubApuesta, spyApuesta;
		private TipoApuesta finalSUT;

			@Before
			public void setUp() {
				finalSUT = new Final();
				stubApuesta = mock(Apuesta.class);
				spyApuesta = mock(Apuesta.class);
			}
			
			@Test
			public void testAlCancelarTiraError() throws Exception {
					try {
                				finalSUT.cancelar(stubApuesta);
            				}
					catch(Exception e) {
						String mensajeOriginal= new String("Este tipo de apuesta no puede ser cancelada o reactivada.");
						String mensajeTraido= e.getMessage();
						assertEquals(mensajeOriginal,mensajeTraido);
				}
			}
			
			@Test
			public void testAlReactivarTiraError()throws Exception{
					try {
                				finalSUT.reactivar(stubApuesta);
            				}
					catch(Exception e){
						String mensajeOriginal = new String("Este tipo de apuesta no puede ser cancelada o reactivada.");
						String mensajeTraido= e.getMessage();
						assertEquals(mensajeOriginal,mensajeTraido);  
				}
			}
			
			@Test
			public void testLaGananciaBrutaEsLaMultiplicacionEntreLaCuotaConvenidaYElMonto() {
				Float dos = new Float(2);
				Float cuatro = new Float(4);
				
				when(stubApuesta.cuotaConvenida()).thenReturn(dos);
				when(stubApuesta.monto()).thenReturn(cuatro);
				
				BigDecimal esperado = new BigDecimal(dos * cuatro); 
				assertEquals(esperado, finalSUT.gananciaBruta(stubApuesta));
			}
}
