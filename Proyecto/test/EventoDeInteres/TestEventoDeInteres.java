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
			
			spyUsuario = spy(User.class);
			spyCasa = spy(CasaDeApuestas.class);
			
			eventoSUT.agregarInteresado(spyUsuario);
			eventoSUT.agregarInteresado(spyCasa);
			
			eventoSUT.cambie();
		}
	
		@Test
		public void testAlSerModificadoSusInteresadosSonAvisadosDelCambio() {
			verify(spyUsuario).cambio(eventoSUT);
			verify(spyCasa).cambio(eventoSUT);
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
