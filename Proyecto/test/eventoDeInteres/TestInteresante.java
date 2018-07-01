package eventoDeInteres;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import casaDeApuesta.CasaDeApuestas;
import eventoDeInteres.Interesado;
import eventoDeInteres.Interesante;
import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;
import usuarios.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class TestInteresante {
	private Interesante eventoSUT;
	private Interesado spyUsuario;
	private Interesado spyCasa;
	private Deporte dummyDeporte;
	private Oponente dummyOponente0, dummyOponente1;
	private Date dummyFecha;
	private String dummyLugar;
	private CasaDeApuestas dummyCasa;
	
		@Before
		public void setUp() {
			dummyDeporte = mock(Deporte.class);
			dummyOponente0 = mock(Oponente.class);
			dummyOponente1 = mock(Oponente.class);
			dummyFecha = mock(Date.class);
			dummyLugar = new String("");
			
			dummyCasa = mock(CasaDeApuestas.class);
			
			eventoSUT = new EventoDeportivo(dummyCasa, dummyDeporte, dummyOponente0, dummyOponente1, dummyFecha, dummyLugar);
			
			spyUsuario = mock(User.class);
			spyCasa = mock(CasaDeApuestas.class);
			
		}
		
		@Test
		public void testalSerCreadoElInteresanteNoTieneNingunInteresado() {
			List<Interesado> losInteresadosDelPartido = eventoSUT.interesados();
			assertTrue(losInteresadosDelPartido.isEmpty());
			assertEquals(0, losInteresadosDelPartido.size());
		}
	
		@Test
		public void testAlSerModificadoSusInteresadosSonAvisadosDelCambio() {
			eventoSUT.agregarInteresado(spyUsuario);
			eventoSUT.agregarInteresado(spyCasa);
			
			eventoSUT.notificarCambio();
			
			verify(spyUsuario).recibirCambio(eventoSUT);
			verify(spyCasa).recibirCambio(eventoSUT);
		}
		
		@Test
		public void testSeAgreganLosInteresados() {
			ArrayList<Interesado> listSpy = spy(ArrayList.class);
			Interesado dummyInteresado = mock(Interesado.class);
			
			eventoSUT.setInteresados(listSpy);
			eventoSUT.agregarInteresado(dummyInteresado);
			
			verify(listSpy).add(dummyInteresado);
		}
		
		@Test
		public void testLosInteresadosDeUnEventoSonLosCorrectos() {
			List<Interesado> vacia = new ArrayList<Interesado>();
			Interesado dummyInteresado0 = mock(Interesado.class);
			Interesado dummyInteresado1 = mock(Interesado.class);
			Interesado dummyInteresado2 = mock(Interesado.class);
			
			eventoSUT.setInteresados(vacia);
			eventoSUT.agregarInteresado(dummyInteresado0);
			eventoSUT.agregarInteresado(dummyInteresado1);
			
			List<Interesado> interesadosDelEvento = eventoSUT.interesados();
			assertEquals(2, interesadosDelEvento.size());
			assertTrue(interesadosDelEvento.contains(dummyInteresado0));
			assertTrue(interesadosDelEvento.contains(dummyInteresado1));
			assertFalse(interesadosDelEvento.contains(dummyInteresado2));
		}
		
		
}
