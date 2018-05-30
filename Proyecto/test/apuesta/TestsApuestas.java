package apuesta;

import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;


class TestsApuestas {

	@Before
	void setUp() throws Exception {
	}

	@Test //se tiene que impactar que se descuentan 200 pe de multa
	void testUnaApuestaSeguraSeCancelaAntesDeEmpezar() {
		
	}
	
	@Test//tiene que calcular lo que se descuenta y los saldos que quedan
	void testUnaApuestaSeguraSeCancelaAntesDeTerminar() {
		
	}
	@Test //se tiene que ver el cambio de estado en la apuesta, tiene que volver a ser activada , y cobrar la penalidad
	void testUnaApuestaSeguraSeReactivaAntesDeComenzar() {
		
	}
	@Test //ver que tiene que pasar, tiene que cambiar el estado de la apuesta?
	void testUnaApuestaNoSeguraSeCancela() {
		
	}
	

}
