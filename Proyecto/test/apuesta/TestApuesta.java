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
	private Apuesta apuestaSpy;
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
		apuestaSpy = mock(Apuesta.class);
		
	}
	
	@Test
	public void testAlSerCreadaLaApuestaElMontoEsElPAsadoEnElConstructor() {
		assertEquals(monto, apuestaSUT.monto());
	}
	
	@Test
	public void testSeModificaElMontoDeLaApuesta() {
		Float esperado = new Float(16);
		apuestaSUT.setMonto(esperado);
		assertEquals(esperado, apuestaSUT.monto());
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
	
	@Test
	public void testSeReduceElMontoEn16unidades() {
		apuestaSUT.setMonto(new Float(32));
		apuestaSUT.reducirMontoConPenalidad(new Float(16));
		assertEquals(new Float(16), apuestaSUT.monto());
	}
	
	@Test
	public void testCambiarElTipoDeApuestaACancelada(){
			
		
		this.apuestaSpy.cambiarElTipoDeApuestaACancelada();
				
		
	}

}
