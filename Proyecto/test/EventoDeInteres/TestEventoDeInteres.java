package EventoDeInteres;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import casaDeApuesta.CasaDeApuestas;
import usuarios.User;

import static org.mockito.Mockito.*;


public class TestEventoDeInteres {
	private EventoDeInteres eventoSUT;
	private Interesado spyUsuario;
	private Interesado spyCasa;
	
		@Before
		public void setUp() {
			eventoSUT = new EventoDeInteres();
			spyUsuario = spy(User.class);
			spyCasa = spy(CasaDeApuestas.class);
			
			eventoSUT.agregarInteresado(spyUsuario);
			eventoSUT.agregarInteresado(spyCasa);
			
			eventoSUT.iChanged();
		}
	
		@Test
		public void testAlSerModificadoSusInteresadosSonAvisadosDelCambio() {
			verify(spyUsuario).changed(eventoSUT);
			verify(spyCasa).changed(eventoSUT);
		}
		
		public void testSeAgreganLosInteresados() {
			ArrayList<Interesado> listSpy = spy(ArrayList.class);
			
			Interesado dummyInteresado = mock(Interesado.class);
			eventoSUT = new EventoDeInteres(listSpy);
			eventoSUT.agregarInteresado(dummyInteresado);
			
			verify(listSpy).add(dummyInteresado);
			verify(listSpy).add(dummyInteresado);
		}

}
