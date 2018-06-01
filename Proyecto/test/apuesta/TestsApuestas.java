package apuesta;

import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;


public class TestsApuestas {

	@Before
	public void setUp() throws Exception {
	}

	@Test //se tiene que impactar que se descuentan 200 pe de multa
	public void testUnaApuestaSeguraSeCancelaAntesDeEmpezar() {
		
	}
	
	@Test//tiene que calcular lo que se descuenta y los saldos que quedan
	public void testUnaApuestaSeguraSeCancelaAntesDeTerminar() {
		
	}
	@Test //se tiene que ver el cambio de estado en la apuesta, tiene que volver a ser activada , y cobrar la penalidad
	public void testUnaApuestaSeguraSeReactivaAntesDeComenzar() {
		
	}
	@Test //ver que tiene que pasar, tiene que cambiar el estado de la apuesta?
	public void testUnaApuestaNoSeguraSeCancela() {
		
	}
	

}
