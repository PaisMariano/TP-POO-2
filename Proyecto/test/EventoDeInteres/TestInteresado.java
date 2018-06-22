package EventoDeInteres;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import casaDeApuesta.CasaDeApuestas;
import usuarios.User;

public class TestInteresado {
	private Interesado interesadoUserSUT, interesadoCasaSUT;
	private EventoDeInteres spyEvento;
	
		@Before
		public void setUp() {
			interesadoUserSUT = new User();
			interesadoCasaSUT = new CasaDeApuestas();
			spyEvento = spy(EventoDeInteres.class);
		}
	
		@Test
		public void testAlAgregarUnEventoEsteAgregaAlInteresado() {
			interesadoUserSUT.agregarEventoDeInteres(spyEvento);
			interesadoCasaSUT.agregarEventoDeInteres(spyEvento);

			verify(spyEvento).agregarInteresado(interesadoUserSUT);
			verify(spyEvento).agregarInteresado(interesadoCasaSUT);
		}
		
		public void testSeAgregaUnEventoALaLista() {
			ArrayList<EventoDeInteres> listSpy = spy(ArrayList.class);
			EventoDeInteres dummyEvento = mock(EventoDeInteres.class);
			
			interesadoUserSUT.setEventos(listSpy);
			interesadoCasaSUT.setEventos(listSpy);
			
			interesadoUserSUT.agregarEventoDeInteres(dummyEvento);
			interesadoCasaSUT.agregarEventoDeInteres(dummyEvento);
			
			verify(listSpy).add(dummyEvento);
		}
}
