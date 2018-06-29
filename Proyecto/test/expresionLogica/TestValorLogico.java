package expresionLogica;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import criterio.CriterioDeBusqueda;
import eventoDeportivo.EventoDeportivo;

public class TestValorLogico {
	private ValorLogico valorSUT;
	private CriterioDeBusqueda spyCriterio, dummyCriterio;
	
		@Before
		public void setUp() {
			spyCriterio = mock(CriterioDeBusqueda.class);
			dummyCriterio = mock(CriterioDeBusqueda.class);
			valorSUT = new ValorLogico(spyCriterio);
		}
	
		@Test
		public void testAlSerCreadoElValorLogicoElCriterioQueEnvuelveEsElCorrecto() {
			assertEquals(spyCriterio, valorSUT.getCriterio());
		}
		
		@Test
		public void testAlCambiarElCriterioQueElValorLogicoEnvuelveEseCriterioEsElCorrecto() {
			valorSUT.setCriterio(dummyCriterio);
			assertEquals(dummyCriterio, valorSUT.getCriterio());
		}
		
		@Test
		public void testAlPedirleAlValorLogicoElGetValorLoDelegaEnElCriterio() {
			List<EventoDeportivo> dummyList = new ArrayList<EventoDeportivo>();
			valorSUT.getValor(dummyList);
			verify(spyCriterio).buscarEn(dummyList);
		}
}
