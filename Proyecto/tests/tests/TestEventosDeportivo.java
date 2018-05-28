package tests;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.Before;


import eventoDeportivo.Deporte;
import eventoDeportivo.EventoDeportivo;





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