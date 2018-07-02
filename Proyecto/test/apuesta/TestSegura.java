package apuesta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class TestSegura {
	private Segura segura;
	private Apuesta apuesta;
	
		@Before
		public void setUp() {
			segura = new Segura();
			apuesta = mock(Apuesta.class);
		}
			
		@Test
		public void testAlSerCreadaElPorcentajeDeDescuentoEsDel15() {
			Float esperado = new Float(15);
			assertEquals(esperado, segura.getPorcentajeDescuento());
		}
		
		@Test
		public void testAlSettearOtroPorcentajeElSUTCambia() {
			Float esperado = new Float(16);
			segura.setPorcentajeDescuento(esperado);
			assertEquals(esperado, segura.getPorcentajeDescuento());
		}
		
		@Test
		public void testElDescuentoEsElIndicado() {
			Float esperado = new Float(85);
			assertEquals(esperado, segura.descuento());
		}
		
		@Test
		public void testLaGanaciaBrutaRepresentaLaGananciaEstipuladaDeLaApuestaMenosElPorcentaje() {
			when(apuesta.cuotaConvenida()).thenReturn(new Float(20));
			when(apuesta.monto()).thenReturn(new Float(10));
			BigDecimal esperado = new BigDecimal(170);
			assertEquals(esperado, segura.gananciaBruta(apuesta));
		}
		
		@Test
		public void testLaGanaciaBrutaEs0() {
			when(apuesta.cuotaConvenida()).thenReturn(new Float(200));
			when(apuesta.monto()).thenReturn(new Float(0));
			BigDecimal esperado = new BigDecimal(0);
			assertEquals(esperado, segura.gananciaBruta(apuesta));
		}
}
