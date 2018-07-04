package apuesta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estado.EstadoEventoDeportivo;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class TestSegura {
	private Segura segura;
	private Apuesta apuesta;
	
	private EstadoEventoDeportivo estadoEventoDep;
	
	private TipoApuesta tipoSut;
	private Apuesta spyApuesta;

	
		@Before
		public void setUp() {
			segura = new Segura();
			apuesta = mock(Apuesta.class);
			
			tipoSut = new Segura();
			spyApuesta = mock(Apuesta.class);
			estadoEventoDep = mock(EstadoEventoDeportivo.class);
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
		
		@Test
		public void testVerificoQueSeLeEnvieElMensajeCancelarAlEstado() {
			when(spyApuesta.elEstadoDelPartidoDeLaApuesta()).thenReturn(estadoEventoDep);
			
			tipoSut.cancelar(spyApuesta);		
			
			verify(estadoEventoDep).cancelar(spyApuesta);
			
		}
		
		@Test
		public void testVerificoQueSeLeEnvieElMensajeReactivarAlEstado() {
			when(spyApuesta.elEstadoDelPartidoDeLaApuesta()).thenReturn(estadoEventoDep);
			
			tipoSut.reactivar(spyApuesta);		
			
			verify(estadoEventoDep).reactivar(spyApuesta);
			
		}
		
}
