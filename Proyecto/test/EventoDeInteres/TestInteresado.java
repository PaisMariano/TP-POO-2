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
	private Interesante spyEvento;
	
		@Before
		public void setUp() {
			interesadoUserSUT = new User(new String(""));
			interesadoCasaSUT = new CasaDeApuestas();
			spyEvento = spy(Interesante.class);
		}
	
		@Test
		public void testAlAgregarUnEventoEsteAgregaAlInteresado() {
			interesadoUserSUT.agregarInteresante(spyEvento);
			interesadoCasaSUT.agregarInteresante(spyEvento);

			verify(spyEvento).agregarInteresado(interesadoUserSUT);
			verify(spyEvento).agregarInteresado(interesadoCasaSUT);
		}
		
		public void testSeAgregaUnEventoALaLista() {
			ArrayList<Interesante> listSpy = spy(ArrayList.class);
			Interesante dummyEvento = mock(Interesante.class);
			
			interesadoUserSUT.setInteresantes(listSpy);
			interesadoCasaSUT.setInteresantes(listSpy);
			
			interesadoUserSUT.agregarInteresante(dummyEvento);
			interesadoCasaSUT.agregarInteresante(dummyEvento);
			
			verify(listSpy).add(dummyEvento);
		}
}
