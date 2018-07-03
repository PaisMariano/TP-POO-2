package EventoDeInteres;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import apuesta.Apuesta;
import apuesta.ITipoApuesta;
import apuesta.TipoApuesta;
import casaDeApuesta.CasaDeApuestas;
import eventoDeInteres.Interesado;
import eventoDeInteres.Interesante;
import eventoDeportivo.EventoDeportivo;
import resultados.Empate;
import resultados.Resultado;
import usuarios.User;

public class TestInteresado {
	private Interesado interesadoUserSUT, interesadoCasaSUT;
	private User user;
	private CasaDeApuestas casa;
	private EventoDeportivo stubEvento, otroEvento;
	private String mail;
	private Resultado resultado, otroResultado;
	
	
		@Before
		public void setUp() {
			mail = new String("asd@gmail.com");
			casa = new CasaDeApuestas();	
			user = new User(mail);
			
			interesadoUserSUT = spy(Interesado.class);
			interesadoCasaSUT = mock(CasaDeApuestas.class);
			stubEvento = mock(EventoDeportivo.class);
		}
		
		private void setUpUsuarioHaceApuestas() {
			Resultado resultado = mock(Resultado.class);
			Resultado otroResultado = mock(Resultado.class);
			TipoApuesta tipo = mock(TipoApuesta.class);
			Float numero = new Float(2);
			
			
			Apuesta apuesta0 = new Apuesta(numero, stubEvento, resultado, tipo);
			Apuesta apuesta1 = new Apuesta(numero, stubEvento, otroResultado, tipo);
			user.agregarNuevaApuesta(apuesta0);
			user.agregarNuevaApuesta(apuesta1);
		}
		
		private void setUpCasaDeApuestasComoInteresado() {
			casa = new CasaDeApuestas();
		}
		
		
		@Test
		public void testElUsuarioNoLeInteresaElPartidoAlCualNoAposto() {
			this.setUpUsuarioHaceApuestas();
			
			EventoDeportivo otroEvento = mock(EventoDeportivo.class);

			assertFalse(user.leInteresa(otroEvento));			
		}

		@Test
		public void testElUsuarioLeInteresaElPartidoAlCualAposto() {
			this.setUpUsuarioHaceApuestas();
			
			assertTrue(user.leInteresa(stubEvento));
			assertFalse(user.leInteresa(otroEvento));
		}
		
		@Test
		public void testLaCasaLeInteresaElPartidoQueEstaEmpezado() {
			this.setUpCasaDeApuestasComoInteresado();
			
			when(stubEvento.haComenzado()).thenReturn(true);		
			assertTrue(casa.leInteresa(stubEvento));			
		}

		@Test
		public void testLaCasaNoLeInteresaElPartidoQueNoEstaEmpezado() {
			this.setUpCasaDeApuestasComoInteresado();
			
			when(stubEvento.haComenzado()).thenReturn(false);
			assertFalse(casa.leInteresa(stubEvento));
		}
		
		@Test
		public void testAlRecibirCambioElUsuarioInteresadoConcretoSeVerificaQueSeNotifiquenSiElEventoLeInteresa() {
			User spyUser = spy(user);
			this.setUpUsuarioHaceApuestas();
			
			spyUser.recibirCambio(stubEvento);
			
			verify(spyUser).leInteresa(stubEvento); 
			assertTrue(spyUser.leInteresa(stubEvento));
			verify(spyUser, times(1)).notificar();
		}
		
		@Test
		public void testAlRecibirCambioElUsuarioInteresadoConcretoSeVerificaQueNoSeNotifiquenSiElEventoNoLeInteresa() {
			User spyUser = spy(user);
			this.setUpUsuarioHaceApuestas();
			
			spyUser.recibirCambio(otroEvento);
			
			verify(spyUser).leInteresa(otroEvento); 
			assertFalse(spyUser.leInteresa(otroEvento));
			verify(spyUser, never()).notificar();
		}
		
		@Test
		public void testAlRecibirCambioLaCasaInteresadaConcretaSeVerificaQueSeNotifiquenSiElEventoLeInteresa() {
			CasaDeApuestas spyCasa = spy(casa);
			this.setUpCasaDeApuestasComoInteresado();
			
			when(stubEvento.haComenzado()).thenReturn(true);
			spyCasa.recibirCambio(stubEvento);
			
			verify(spyCasa).leInteresa(stubEvento); 
			verify(spyCasa, times(1)).notificar();
		}
		
		@Test
		public void testAlRecibirCambioLaCasaInteresadaConcretaSeVerificaQueNoSeNotifiquenSiElEventoNoLeInteresa() {
			CasaDeApuestas spyCasa = spy(casa);
			this.setUpCasaDeApuestasComoInteresado();
			
			when(stubEvento.haComenzado()).thenReturn(false);
			spyCasa.recibirCambio(stubEvento);
			
			verify(spyCasa).leInteresa(stubEvento); 
			verify(spyCasa, never()).notificar();
		}
	
		@Test
		public void testAlRecibirCambioLosSUTSeVerificaQueNoSeNotifiquenSiElEventoNoLeInteresa() {
			
			when(interesadoUserSUT.leInteresa(stubEvento)).thenReturn(false);
			when(interesadoCasaSUT.leInteresa(stubEvento)).thenReturn(false);
				
			interesadoUserSUT.recibirCambio(stubEvento); 
			interesadoCasaSUT.recibirCambio(stubEvento);
			
			verify(interesadoUserSUT, never()).notificar();
			verify(interesadoCasaSUT, never()).notificar();
		}
}
