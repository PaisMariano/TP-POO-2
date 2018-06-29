package eventoDeInteres;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import casaDeApuesta.CasaDeApuestas;
import eventoDeInteres.Interesado;
import eventoDeInteres.Interesante;
import usuarios.User;

public class TestInteresado {
	private Interesado interesadoUserSUT, interesadoCasaSUT;
	private Interesante dummyEvento;
	
		@Before
		public void setUp() {
			interesadoUserSUT = mock(User.class);
			interesadoCasaSUT = mock(CasaDeApuestas.class);
			dummyEvento = mock(Interesante.class);
		}
		
	
		@Test
		public void testAlRecibirCambioLosSUTSeVerificaQueSeNotifiquenSiElEventoLeInteresa() {
			
			when(interesadoUserSUT.leInteresa(dummyEvento)).thenReturn(true);
			when(interesadoCasaSUT.leInteresa(dummyEvento)).thenReturn(true);
			
			interesadoUserSUT.recibirCambio(dummyEvento); 
			interesadoCasaSUT.recibirCambio(dummyEvento); 
			
			verify(interesadoUserSUT).notificar();
			verify(interesadoCasaSUT).notificar();
		}
		
		@Test
		public void testAlRecibirCambioLosSUTSeVerificaQueNoSeNotifiquenSiElEventoNoLeInteresa() {
			
			when(interesadoUserSUT.leInteresa(dummyEvento)).thenReturn(false);
			when(interesadoCasaSUT.leInteresa(dummyEvento)).thenReturn(false);
			
			interesadoUserSUT.recibirCambio(dummyEvento); 
			interesadoCasaSUT.recibirCambio(dummyEvento);
			
			verify(interesadoUserSUT, never()).notificar();
			verify(interesadoCasaSUT, never()).notificar();
		}
}
