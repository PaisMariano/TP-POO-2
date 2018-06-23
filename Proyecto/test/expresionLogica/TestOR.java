package expresionLogica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import casaDeApuesta.CasaDeApuestas;
import criterio.CriterioDeBusqueda;
import criterio.CriterioPorDeporte;
import criterio.CriterioPorFecha;
import criterio.CriterioPorLugar;
import criterio.CriterioPorOponente;

import static org.mockito.Mockito.*;

import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;
import oponentes.Deportista;
import oponentes.Oponente;

public class TestOR {
	private OperacionLogica orSUT;
	private ExpresionLogica stubExpresionIzq, stubExpresionDer;
	private EventoDeportivo eventoDeportivo0, eventoDeportivo1, eventoDeportivo2, eventoDeportivo3; 
	private List<EventoDeportivo> eventos, eventosConcretos, resultadoor;
	private ExpresionLogica expresionNoSeCumple, expresionLogicaSimple0, expresionLogicaSimple1, expresionLogicaSimple2, expresionLogicaSimple3, expresionLogicaCompleja0, expresionLogicaCompleja1, expresionLogicaCompleja2, expresionLogicaCompleja3;
	private CriterioDeBusqueda criterioDeporte, criterioOponente, criterioFecha, criterioLugar, criterioNoSeCumple;
	private Date dummyFecha, fecha;
	private String dummyLugar, lugar;
	private Deporte deporte, otroDeporte;
	private Oponente oponente0, oponente1, oponente2, oponenteNoJuega;
	private CasaDeApuestas dummyCasa;
	
		@Before
			public void setUp() {
			
				dummyLugar = new String("");
				lugar = new String("Holora");
				
				fecha = new Date(7,7,7);
				dummyFecha = mock(Date.class);
				
				stubExpresionIzq = mock(ExpresionLogica.class);
				stubExpresionDer = mock(ExpresionLogica.class);
				
				eventos = new ArrayList<EventoDeportivo>();
				
				deporte = new Deporte("Boxeo");
				otroDeporte = new Deporte("Esgrima"); 
				
				oponente0 = new Deportista(new String("John"), new String("Kennedy Tools"), dummyFecha, dummyLugar);
				oponente1 = new Deportista(new String("Haruki"), new String("Murakami"), dummyFecha, dummyLugar);
				oponente2 = new Deportista(new String("Leon"), new String("Tolstoi"), dummyFecha, dummyLugar);
				oponenteNoJuega = new Deportista(new String("Gabriel"), new String("Garcia Marquez"), dummyFecha, dummyLugar);
				
				
				criterioDeporte = new CriterioPorDeporte(deporte);
				criterioOponente = new CriterioPorOponente(oponente0);
				criterioLugar = new CriterioPorLugar(lugar);
				criterioFecha = new CriterioPorFecha(fecha);
				criterioNoSeCumple = new CriterioPorOponente(oponenteNoJuega);
				
				dummyCasa = mock(CasaDeApuestas.class);
				
				//Entendiendo los criterios como las expresiones logicas simples...
				expresionLogicaSimple0 = new ValorLogico(criterioDeporte); 
				expresionLogicaSimple1 = new ValorLogico(criterioOponente);
				expresionLogicaSimple2 = new ValorLogico(criterioLugar); 
				expresionLogicaSimple3 = new ValorLogico(criterioFecha);
				expresionNoSeCumple = new ValorLogico(criterioNoSeCumple);
				
				//... Y las complejas como la union, mediante una operacion logica de otras expresiones, ya sea que estan sean simples o complejas.
				expresionLogicaCompleja0 = new OR (expresionLogicaSimple0, expresionLogicaSimple2);
				expresionLogicaCompleja1 =new OR (expresionLogicaSimple1, expresionLogicaSimple3);
				expresionLogicaCompleja2 = new AND(expresionLogicaSimple0, expresionLogicaSimple2);
				expresionLogicaCompleja3 = new OR(expresionLogicaCompleja2, expresionLogicaCompleja1);
				
				eventosConcretos = new ArrayList<EventoDeportivo>();
				
				eventoDeportivo0 = new EventoDeportivo(dummyCasa, deporte, oponente0, oponente1, dummyFecha, dummyLugar);
				eventoDeportivo1 = new EventoDeportivo(dummyCasa,deporte, oponente1, oponente1, dummyFecha, dummyLugar);
				eventoDeportivo2 = new EventoDeportivo(dummyCasa, otroDeporte, oponenteNoJuega, oponente1, fecha, lugar);
				eventoDeportivo3 = new EventoDeportivo(dummyCasa, otroDeporte, oponenteNoJuega, oponente2, fecha, lugar);
				orSUT = new OR(stubExpresionIzq, stubExpresionDer);
				//Caso que se desea testear finalmente: orSUT = new or(expresionLogicaCompleja2, expresionLogicaCompleja3);

				eventosConcretos.add(eventoDeportivo0);
				eventosConcretos.add(eventoDeportivo1);
				eventosConcretos.add(eventoDeportivo2);
				eventosConcretos.add(eventoDeportivo3);
		}
		
			@Test
			public void testAlUnirUnaBusquedaDeEnLaListaDeEventosConcretosCriterioQueNoSeCumpleSeRetornaUnaListaVacia() {
				orSUT.setExpresionIzquierda(expresionLogicaSimple0);
				orSUT.setExpresionDerecha(expresionNoSeCumple);
				resultadoor = orSUT.getValor(eventosConcretos);
				assertEquals(4, resultadoor.size());
				assertTrue(resultadoor.contains(eventoDeportivo0));
				assertTrue(resultadoor.contains(eventoDeportivo1));
				assertTrue(resultadoor.contains(eventoDeportivo2));
				assertTrue(resultadoor.contains(eventoDeportivo3));
			}
		
			@Test
			public void testAlUnirUnaBusquedaDeEnLaListaDeEventosConcretosCriterioPorDeporteYOponenteSeRetornaLaListaConElUnicoEventoQueLoCumple() {
				orSUT.setExpresionIzquierda(expresionLogicaSimple0);
				orSUT.setExpresionDerecha(expresionLogicaSimple1);
				resultadoor = orSUT.getValor(eventosConcretos);
				assertEquals(2, resultadoor.size());
			}
			
			@Test
			public void testAlUnirUnaBusquedaEnLaListaDeEventosConcretosDeCriterioPorDeporteYOponenteSeRetornaSeCompruebaQueSeaElEventoCorrecto() {
				orSUT.setExpresionIzquierda(expresionLogicaSimple0);
				orSUT.setExpresionDerecha(expresionLogicaSimple1);
				resultadoor = orSUT.getValor(eventosConcretos);
				assertTrue(resultadoor.contains(eventoDeportivo0));
			}
			
			@Test
			public void testAlUnirUnaBusquedaDeEnLaListaDeEventosConcretosCriterioPorFechaYLugarSeRetornaLaListaConLosUnicosDosEventosQueLoCumplen() {
				orSUT.setExpresionIzquierda(expresionLogicaSimple2);
				orSUT.setExpresionDerecha(expresionLogicaSimple3);
				resultadoor = orSUT.getValor(eventosConcretos);
				assertEquals(2, resultadoor.size());
			}
			
			@Test
			public void testAlUnirUnaBusquedaEnLaListaDeEventosConcretosDeCriterioPorFechaYLugarSeRetornaSeCompruebaQueSeanLosEventosCorrectos() {
				orSUT.setExpresionIzquierda(expresionLogicaSimple2);
				orSUT.setExpresionDerecha(expresionLogicaSimple3);
				resultadoor = orSUT.getValor(eventosConcretos);
				assertTrue(resultadoor.contains(eventoDeportivo2));
				assertTrue(resultadoor.contains(eventoDeportivo3));
			}
			
			@Test
			public void testAlUnirUNaBusquedaEnLaListaDeEventosConcretosExpresionesComplejasQUeNoSeCumpleSeRetornaUnaListaVacia() {			
				orSUT.setExpresionIzquierda(expresionLogicaCompleja0);
				orSUT.setExpresionDerecha(expresionLogicaCompleja1);
				resultadoor = orSUT.getValor(eventosConcretos);
				
				assertEquals(4, resultadoor.size());				
			}
			
			@Test
			public void testAlUnirUNaBusquedaEnLaListaDeEventosConcretosExpresionesComplejasQUeTerminanCumpliendosePorTodosLosPartidos() {
				EventoDeportivo eventoDeportivo4 = new EventoDeportivo(dummyCasa, deporte, oponente1, oponente0, fecha, lugar); //Unico Evento que cumple todos los criterios.
				orSUT.setExpresionIzquierda(expresionLogicaCompleja0);
				orSUT.setExpresionDerecha(expresionLogicaCompleja1);
				
				eventosConcretos.add(eventoDeportivo4);
				resultadoor = orSUT.getValor(eventosConcretos);
				
				assertEquals(5, resultadoor.size());				
			}
			
			@Test
			public void testAlUnirUNaBusquedaEnLaListaDeEventosConcretosExpresionesComplejasQUeTerminanCumpliendosePorUnDeterminadoPartido() {
				EventoDeportivo eventoDeportivo4 = new EventoDeportivo(dummyCasa, deporte, oponente1, oponente0, fecha, lugar); //Unico Evento que cumple todos los criterios.
				orSUT.setExpresionIzquierda(expresionLogicaCompleja0);
				orSUT.setExpresionDerecha(expresionLogicaCompleja1);
				
				eventosConcretos.add(eventoDeportivo4);
				resultadoor = orSUT.getValor(eventosConcretos);
				
				assertTrue(resultadoor.contains(eventoDeportivo4));				
			}
			
			@Test //Porqué esto no funciona?
			public void testLaExpresionIzquierdaEnLaOperacionEsLaCorrecta() {
				assertEquals(stubExpresionIzq, orSUT.getExpresionIzquierda());
			}
			
			@Test
			public void testLaExpresionDerechaEnLaOperacionEsLaCorrecta() {
				assertEquals(stubExpresionDer, orSUT.getExpresionDerecha());
			}
			
			@Test
			public void testLaExpresionIzquierdaEsCambiada() {
				ExpresionLogica izq = orSUT.getExpresionIzquierda();
				orSUT.setExpresionDerecha(izq);
				ExpresionLogica newIzq = orSUT.getExpresionIzquierda();
				assertEquals(orSUT.getExpresionDerecha(), newIzq);
			}
			
			@Test
			public void testLaExpresionDerechasEsCambiada() {
				ExpresionLogica der = orSUT.getExpresionDerecha();
				orSUT.setExpresionDerecha(der);
				ExpresionLogica newDer = orSUT.getExpresionIzquierda();
				assertEquals(orSUT.getExpresionIzquierda(), newDer);
			}
}
