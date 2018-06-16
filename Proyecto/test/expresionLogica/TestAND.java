package expresionLogica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import criterio.CriterioPorDeporte;
import criterio.CriterioPorFecha;
import criterio.CriterioPorLugar;
import criterio.CriterioPorOponente;

import static org.mockito.Mockito.*;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import oponentes.Deportista;
import oponentes.Oponente;

public class TestAND {
	private OperacionLogica andSUT;
	private ExpresionLogica stubExpresionIzq, stubExpresionDer;
	private EventoDeportivo stubEventoDeportivo0, stubEventoDeportivo1, stubEventoDeportivo2, stubEventoDeportivo3, eventoDeportivo0, eventoDeportivo1, eventoDeportivo2, eventoDeportivo3; 
	private List<EventoDeportivo> eventos, eventosConcretos, resultadoAND;
	private ExpresionLogica expresionNoSeCumple, expresionLogicaSimple0, expresionLogicaSimple1, expresionLogicaSimple2, expresionLogicaSimple3, expresionLogicaCompleja0, expresionLogicaCompleja1, expresionLogicaCompleja2, expresionLogicaCompleja3;
	private Date dummyFecha, fecha;
	private String dummyLugar, lugar;
	private Deporte deporte, otroDeporte;
	private Oponente oponente0, oponente1, oponente2, oponenteNoJuega;
	
		@Before
			public void setUp() {
			
				dummyLugar = new String("");
				lugar = new String("Holanda");
				
				fecha = new Date(7,7,7);
				dummyFecha = mock(Date.class);
				
				stubExpresionIzq = mock(ExpresionLogica.class);
				stubExpresionDer = mock(ExpresionLogica.class);
				
				eventos = new ArrayList<EventoDeportivo>();
				
				stubEventoDeportivo0 = mock(EventoDeportivo.class);
				stubEventoDeportivo1 = mock(EventoDeportivo.class);
				stubEventoDeportivo2 = mock(EventoDeportivo.class);
				
				deporte = new Deporte("Boxeo");
				otroDeporte = new Deporte("Esgrima"); 
				
				oponente0 = new Deportista(new String("John"), new String("Kennedy Tools"), dummyFecha, dummyLugar);
				oponente1 = new Deportista(new String("Haruki"), new String("Murakami"), dummyFecha, dummyLugar);
				oponente2 = new Deportista(new String("Leon"), new String("Tolstoi"), dummyFecha, dummyLugar);
				oponenteNoJuega = new Deportista(new String("Gabriel"), new String("Garcia Marquez"), dummyFecha, dummyLugar);
				
				//Entendiendo los criterios como las expresiones logicas simples...
				expresionLogicaSimple0 = new CriterioPorDeporte(deporte); 
				expresionLogicaSimple1 = new CriterioPorOponente(oponente0);
				expresionLogicaSimple2 = new CriterioPorLugar(lugar); 
				expresionLogicaSimple3 = new CriterioPorFecha(fecha);
				expresionNoSeCumple = new CriterioPorOponente(oponenteNoJuega);
				
				//... Y las complejas como la union, mediante una operacion logica de otras expresiones, ya sea que estan sean simples o complejas.
				expresionLogicaCompleja0 = new AND (expresionLogicaSimple0, expresionLogicaSimple1);
				expresionLogicaCompleja1 =new AND (expresionLogicaSimple2, expresionLogicaSimple3);
				expresionLogicaCompleja2 = new OR(expresionLogicaSimple0, expresionLogicaSimple2);
				expresionLogicaCompleja3 = new AND(expresionLogicaCompleja2, expresionLogicaCompleja1);
				
				eventosConcretos = new ArrayList<EventoDeportivo>();
				
				eventoDeportivo0 = new EventoDeportivo(deporte, oponente0, oponente1, dummyFecha, dummyLugar);
				eventoDeportivo1 = new EventoDeportivo(deporte, oponente1, oponente1, dummyFecha, dummyLugar);
				eventoDeportivo2 = new EventoDeportivo(otroDeporte, oponenteNoJuega, oponente1, fecha, lugar);
				eventoDeportivo3 = new EventoDeportivo(otroDeporte, oponenteNoJuega, oponente2, fecha, lugar);
				andSUT = new AND(stubExpresionIzq, stubExpresionDer);
				//Caso que se desea testear finalmente: andSUT = new AND(expresionLogicaCompleja2, expresionLogicaCompleja3);
				
				eventos.add(stubEventoDeportivo0);
				eventos.add(stubEventoDeportivo1);
				eventos.add(stubEventoDeportivo2);
				eventos.add(stubEventoDeportivo3);

				eventosConcretos.add(eventoDeportivo0);
				eventosConcretos.add(eventoDeportivo1);
				eventosConcretos.add(eventoDeportivo2);
				eventosConcretos.add(eventoDeportivo3);
		}
		
			@Test
			public void testAlUnirUnaBusquedaDeEnLaListaDeEventosConcretosCriterioQueNoSeCumpleSeRetornaUnaListaVacia() {
				andSUT.setExpresionIzquierda(expresionLogicaSimple0);
				andSUT.setExpresionDerecha(expresionNoSeCumple);
				resultadoAND = andSUT.getValor(eventosConcretos);
				assertEquals(0, resultadoAND.size());
				assertFalse(resultadoAND.contains(eventoDeportivo0));
				assertFalse(resultadoAND.contains(eventoDeportivo1));
				assertFalse(resultadoAND.contains(eventoDeportivo2));
				assertFalse(resultadoAND.contains(eventoDeportivo3));
			}
		
			@Test
			public void testAlUnirUnaBusquedaDeEnLaListaDeEventosConcretosCriterioPorDeporteYOponenteSeRetornaLaListaConElUnicoEventoQueLoCumple() {
				andSUT.setExpresionIzquierda(expresionLogicaSimple0);
				andSUT.setExpresionDerecha(expresionLogicaSimple1);
				resultadoAND = andSUT.getValor(eventosConcretos);
				assertEquals(1, resultadoAND.size());
			}
			
			@Test
			public void testAlUnirUnaBusquedaEnLaListaDeEventosConcretosDeCriterioPorDeporteYOponenteSeRetornaSeCompruebaQueSeaElEventoCorrecto() {
				andSUT.setExpresionIzquierda(expresionLogicaSimple0);
				andSUT.setExpresionDerecha(expresionLogicaSimple1);
				resultadoAND = andSUT.getValor(eventosConcretos);
				assertTrue(resultadoAND.contains(eventoDeportivo0));
			}
			
			@Test
			public void testAlUnirUnaBusquedaDeEnLaListaDeEventosConcretosCriterioPorFechaYLugarSeRetornaLaListaConLosUnicosDosEventosQueLoCumplen() {
				andSUT.setExpresionIzquierda(expresionLogicaSimple2);
				andSUT.setExpresionDerecha(expresionLogicaSimple3);
				resultadoAND = andSUT.getValor(eventosConcretos);
				assertEquals(2, resultadoAND.size());
			}
			
			@Test
			public void testAlUnirUnaBusquedaEnLaListaDeEventosConcretosDeCriterioPorFechaYLugarSeRetornaSeCompruebaQueSeanLosEventosCorrectos() {
				andSUT.setExpresionIzquierda(expresionLogicaSimple2);
				andSUT.setExpresionDerecha(expresionLogicaSimple3);
				resultadoAND = andSUT.getValor(eventosConcretos);
				assertTrue(resultadoAND.contains(eventoDeportivo2));
				assertTrue(resultadoAND.contains(eventoDeportivo3));
			}
			
			@Test
			public void testAlUnirUNaBusquedaEnLaListaDeEventosConcretosExpresionesComplejasQUeNoSeCumpleSeRetornaUnaListaVacia() {			
				andSUT.setExpresionIzquierda(expresionLogicaCompleja0);
				andSUT.setExpresionDerecha(expresionLogicaCompleja1);
				resultadoAND = andSUT.getValor(eventosConcretos);
				
				assertEquals(0, resultadoAND.size());				
			}
			
			@Test
			public void testAlUnirUNaBusquedaEnLaListaDeEventosConcretosExpresionesComplejasQUeTerminanCumpliendosePorUnSoloPartido() {
				EventoDeportivo eventoDeportivo4 = new EventoDeportivo(deporte, oponente1, oponente0, fecha, lugar); //Unico Evento que cumple todos los criterios.
				andSUT.setExpresionIzquierda(expresionLogicaCompleja0);
				andSUT.setExpresionDerecha(expresionLogicaCompleja1);
				
				eventosConcretos.add(eventoDeportivo4);
				resultadoAND = andSUT.getValor(eventosConcretos);
				
				assertEquals(1, resultadoAND.size());				
			}
			
			@Test
			public void testAlUnirUNaBusquedaEnLaListaDeEventosConcretosExpresionesComplejasQUeTerminanCumpliendosePorUnDeterminadoPartido() {
				EventoDeportivo eventoDeportivo4 = new EventoDeportivo(deporte, oponente1, oponente0, fecha, lugar); //Unico Evento que cumple todos los criterios.
				andSUT.setExpresionIzquierda(expresionLogicaCompleja0);
				andSUT.setExpresionDerecha(expresionLogicaCompleja1);
				
				eventosConcretos.add(eventoDeportivo4);
				resultadoAND = andSUT.getValor(eventosConcretos);
				
				assertTrue(resultadoAND.contains(eventoDeportivo4));				
			}
			
			@Test
			public void testLaExpresionIzquierdaEnLaOperacionEsLaCorrecta() {
				ExpresionLogica izq = andSUT.getExpresionIzquierda();
				assertEquals(stubExpresionIzq, izq);
			}
			
			@Test
			public void testLaExpresionDerechaEnLaOperacionEsLaCorrecta() {
				ExpresionLogica der = andSUT.getExpresionDerecha();
				assertEquals(stubExpresionDer, der);
			}
			
			@Test
			public void testLaExpresionIzquierdaEsCambiada() {
				ExpresionLogica izq = andSUT.getExpresionIzquierda();
				andSUT.setExpresionDerecha(izq);
				ExpresionLogica newIzq = andSUT.getExpresionIzquierda();
				assertEquals(andSUT.getExpresionDerecha(), newIzq);
			}
			
			@Test
			public void testLaExpresionDerechasEsCambiada() {
				ExpresionLogica der = andSUT.getExpresionDerecha();
				andSUT.setExpresionDerecha(der);
				ExpresionLogica newDer = andSUT.getExpresionIzquierda();
				assertEquals(andSUT.getExpresionIzquierda(), newDer);
			}
}
