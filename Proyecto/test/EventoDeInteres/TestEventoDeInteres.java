package EventoDeInteres;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import casaDeApuesta.CasaDeApuestas;
import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import oponentes.Oponente;
import usuarios.User;

import static org.mockito.Mockito.*;


public class TestEventoDeInteres {
	private EventoDeInteres eventoSUT;
	private Interesado spyUsuario;
	private Interesado spyCasa;
	private Deporte dummyDeporte;
	private Oponente dummyOponente0, dummyOponente1;
	private Date dummyFecha;
	private String dummyLugar;
	
		@Before
		public void setUp() {
			dummyDeporte = mock(Deporte.class);
			dummyOponente0 = mock(Oponente.class);
			dummyOponente1 = mock(Oponente.class);
			dummyFecha = mock(Date.class);
			dummyLugar = new String("");
			
			eventoSUT = new EventoDeportivo(dummyDeporte, dummyOponente0, dummyOponente1, dummyFecha, dummyLugar);
			
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
			
			eventoSUT.setInteresados(listSpy);
			eventoSUT.agregarInteresado(dummyInteresado);
			
			verify(listSpy).add(dummyInteresado);
			verify(listSpy).add(dummyInteresado);
		}

}
