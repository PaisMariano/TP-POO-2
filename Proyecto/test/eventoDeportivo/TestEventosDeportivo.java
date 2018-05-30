package eventoDeportivo;



import static org.junit.Assert.assertEquals;
import apuesta.Apuesta;
import eventoDeportivo.EventoDeportivo;
import eventoDeportivo.Deporte;
import org.junit.Before;
import org.junit.Test;
import estado.EstadoEventoDeportivo;
import static org.mockito.Mockito.*;

public class TestEventosDeportivo {

	private Deporte unDeporte;
	private EventoDeportivo unEventoDeportivo;
	
	@Before
	public void setUp(){
		
		unDeporte = new Deporte("Boxeo");
	}
	

	@Test
	public void unNuevoDeporteCuentaConUnNombre() {

		unDeporte = new Deporte("Boxeo");
		assertEquals((unDeporte.getNombre()),"Boxeo");	
		
	}
	

	@Test
	public void testAnteDosOponentesMedianteResulatadoHistorico (){
		
		
		
	
}
	
	
	@Test
	public void testAnteDosOponentesMedianteResulatadoNoHistorico(){
		
	}
	
	
	
	@Test
	public void testErrorAlIngresarUnSoloOponente(){
}
	
	
	@Test
	public void testErrorAnIngresarMasDeDosOponentes() {
		
		
	}
}
