package apuesta;

import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import resultados.Resultado;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class TestApuesta {
	private Apuesta apuestaSUT;
	private EventoDeportivo spyEvento;
	private Resultado spyResultado;
	private TipoApuesta spyTipo;
	private Float monto;
	
	@Before
	public void setUp(){
		monto = new Float(2);
		spyEvento = mock(EventoDeportivo.class);
		spyResultado = mock(Resultado.class);
		spyTipo = mock(TipoApuesta.class);
		apuestaSUT = new Apuesta(monto, spyEvento, spyResultado, spyTipo);
	}
	
	@Test
	public void testLaApuestaEsCreadaConsistentemente() {
		assertEquals(monto, apuestaSUT.monto());
		assertEquals(spyResultado, apuestaSUT.getResultadoApostado());
	}
	
	@Test
	public void testAlCalcularLaGananciaBrutaDeLaApuestaSeDelegaEnElTipo() {
		apuestaSUT.gananciaBruta();
		verify(spyTipo).gananciaBruta(apuestaSUT);;
	}
	
	@Test
	public void testAlPreguntarSiEmpezoElEventoLaApuestaLoDelegaEnElEvento() {
		apuestaSUT.empezoEvento();
		verify(spyEvento).haComenzado();
	}
	
	@Test
	public void testAlConsultarLaCuotaConvenidaLaApuestaLoDelegaEnElResultado() {
		apuestaSUT.cuotaConvenida();
		verify(spyResultado).getCuotaApuesta(spyEvento, spyResultado);
	}
	
	@Test
	public void testAlCancelarLaApuestaLoDelegaEnElTipo() {
		apuestaSUT.cancelar();
		verify(spyTipo).cancelar(apuestaSUT);
	}
	
	@Test
	public void testAlReactivarLaApuestaLoDelegaEnElTipo() {
		apuestaSUT.reactivar();
		verify(spyTipo).reactivar(apuestaSUT);
	}
	
	@Test
	public void testGananciaNeta() {
		when(spyTipo.gananciaBruta(apuestaSUT)).thenReturn(new BigDecimal(6));
		BigDecimal total = apuestaSUT.gananciaNeta();
		assertEquals(total, new BigDecimal(4));
	}
	
	@Test 
	public void testLaApuestaEsDelMesCorrectoSiElEventoEstaFinalizadoYEsDelMesCorrespondiente() {
		int cuatro = 4;
		
		when(spyEvento.estaFinalizado()).thenReturn(true);
		when(spyEvento.esDelMes(4)).thenReturn(true);
		
		assertTrue(apuestaSUT.esApuestaDelMes(cuatro));
	}
	
	@Test 
	public void testLaApuestaEsDelMesCorrectoPeroElEventoNoEstaFinalizadoYEsDelMesCorrespondiente() {
		int cuatro = 4;
		
		when(spyEvento.estaFinalizado()).thenReturn(false);
		when(spyEvento.esDelMes(4)).thenReturn(true);
		
		assertFalse(apuestaSUT.esApuestaDelMes(cuatro));
	}
	
	@Test 
	public void testLaApuestaNoEsDelMesCorrectoPeroElEventoEstaFinalizadoYNoEsDelMesCorrespondiente() {
		int cuatro = 4;
		
		when(spyEvento.estaFinalizado()).thenReturn(true);
		when(spyEvento.esDelMes(4)).thenReturn(false);
		
		assertFalse(apuestaSUT.esApuestaDelMes(cuatro));
	}
	
	@Test 
	public void testLaApuestaEsDelMesCorrecto() {
		int cuatro = 4;
		
		when(spyEvento.estaFinalizado()).thenReturn(true);
		when(spyEvento.esDelMes(4)).thenReturn(true);
		
		assertTrue(apuestaSUT.esApuestaDelMes(cuatro));
	}

	
	
	@Test //se tiene que impactar que se descuentan 200 pe de multa
	public void testUnaApuestaSeguraSeCancelaAntesDeEmpezar() {
		
	}
	
	@Test//tiene que calcular lo que se descuenta y los saldos que quedan
	public void testUnaApuestaSeguraSeCancelaAntesDeTerminar() {
		
	}
	@Test //se tiene que ver el cambio de estado en la apuesta, tiene que volver a ser activada , y cobrar la penalidad
	public void testUnaApuestaSeguraSeReactivaAntesDeComenzar() {
		
	}
	@Test //ver que tiene que pasar, tiene que cambiar el estado de la apuesta?
	public void testUnaApuestaNoSeguraSeCancela() {
		
	}
}
