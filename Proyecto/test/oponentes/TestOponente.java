package oponentes;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;
import usuarios.*;


public class TestOponente {
	Oponente oponente;
	Deportista deportista1;
	Date fNac= new Date(1,2,88);
	Deportista deportista2;
	Deportista deportistaDummy;
	Deportista otroDeportistaDummy;
	Equipo unEquipo;
	
	@Before
	public void setUp() throws Exception {
		deportista1 = new Deportista("Juan","Perez",fNac,"Adrogue");
		deportista2=new Deportista("Pepe","Carajo",fNac,"Lomas");
		oponente = new Deportista( "Maria Marta","SerraLima",fNac,"Adrogue");
		deportistaDummy= mock(Deportista.class);
		otroDeportistaDummy= mock(Deportista.class);
		List<Deportista> depos= new ArrayList <Deportista>();
		unEquipo = new Equipo(depos, "Equipo1");
	
	}
	

	@Test
	public void testUnNuevoDeportistaCuentaConNombreFNacYDireccion() {
		assertEquals(deportista1.nombre(),(String)"Juan Perez");		
		assertEquals( deportista1.getLugarDeNacimiento(),"Adrogue");		
		assertEquals(new Date(1,2,88), deportista1.getFnacimiento());
		assertEquals(oponente.nombre(), "Maria Marta SerraLima");
	
		}
	
	@Test 
	public void testSeAgreganJugadoresAlPlantel() {
		List<Deportista> spyDeports= spy(new ArrayList <Deportista>());
		Equipo eq1=new Equipo(spyDeports,"feo");		
		eq1.agregarDeportista(deportistaDummy);
		assertEquals("feo",eq1.nombre());
		assertEquals((Integer)1, eq1.cantidadDeDeportistas());
		verify (spyDeports).add(deportistaDummy);
	
		
	}
	
	
	@Test 
	public void testSeIntecambiaUnDeportistaPorOtro(){
		//Faltaria ver que pasa cuando queres intercambiar a un jugador por otro, pero no esta en el plantel. 
		List<Deportista> spyDeports= spy(new ArrayList <Deportista>());
		Equipo otroEquipo=	new Equipo(spyDeports,"AverSiEstoAnda");
		
		otroEquipo.agregarDeportista(deportista1);
		otroEquipo.cambiarDeportista(deportista1, deportista2);
		verify(spyDeports).remove(deportista1);
		verify(spyDeports).add(deportista2);
		
	}
	
	@Test 
	public void testSeQuitaUnDeportistaDelPlantel(){
		List<Deportista> spyDeports= spy(new ArrayList <Deportista>());
		Equipo otroEquipo=	new Equipo(spyDeports,"AverSiEstoAnda");
		
		otroEquipo.agregarDeportista(deportista1);
		otroEquipo.agregarDeportista(deportista2);
		otroEquipo.sacarDeportista(deportista1);
		
		verify(spyDeports).remove(deportista1);
		
	}
	
}
