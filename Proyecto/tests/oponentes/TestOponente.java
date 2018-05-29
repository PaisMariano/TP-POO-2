package oponentes;

import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import usuarios.*;


class TestOponente {
	Oponente oponente;
	Deportista deportista1;
	Date fNac= new Date(1,2,88);
	Deportista deportista2;
	Deportista deportistaDummy;
	Deportista otroDeportistaDummy;
	Equipo unEquipo;
	
	@BeforeEach
	void setUp() throws Exception {
		deportista1 = new Deportista("Juan","Perez",fNac,"Adrogue");
		deportista2=new Deportista("Pepe","Carajo",fNac,"Lomas");
		oponente = new Deportista( "Maria Marta","SerraLima",fNac,"Adrogue");
		deportistaDummy= mock(Deportista.class);
		otroDeportistaDummy= mock(Deportista.class);
		List<Deportista> depos= new ArrayList <Deportista>();
		unEquipo = new Equipo(depos, "Equipo1");
	
	}
	

	@Test
	void testUnNuevoDeportistaCuentaConNombreFNacYDireccion() {
		assertEquals(deportista1.nombre(),(String)"Juan Perez");		
		assertEquals( deportista1.getLugarDeNacimiento(),"Adrogue");		
		assertEquals(new Date(1,2,88), deportista1.getFnacimiento());
		assertEquals(oponente.nombre(), "Maria Marta SerraLima");
		/*equals(oponente.es(new Deportista( "Maria Marta","SerraLima",fNac,"Adrogue")));*/
		
		}
	
	@Test 
	void testSeAgreganJugadoresAlPlantel() {
		List<Deportista> spyDeports= spy(new ArrayList <Deportista>());
		Equipo eq1=	new Equipo(spyDeports,"equipoLaConchaDeTuMAdre");
		eq1.agregarDeportista(deportistaDummy);
		eq1.agregarDeportista(otroDeportistaDummy);
		
		/*assertEquals((Integer)2),eq1.cantidadDeDeportistas());*/
		verify(spyDeports).size();
		doReturn((Integer)2).when(eq1).cantidadDeDeportistas();
		
	}
	
	
	@Test 
	
	void testSeIntecambiaUnDeportistaPorOtro(){
			
		List<Deportista> spyDeports= spy(new ArrayList <Deportista>());
		Equipo otroEquipo=	new Equipo(spyDeports,"AverSiEstoAnda");
		
		otroEquipo.agregarDeportista(deportista1);
		otroEquipo.cambiarDeportista(deportista1, deportista2);
		verify(spyDeports.remove(deportista1));
		verify(spyDeports.add(deportista2));
		
	}
	
	@Test 
	
	void testSeQuitaUnDeportistaDelPlantel(){
		List<Deportista> spyDeports= spy(new ArrayList <Deportista>());
		Equipo otroEquipo=	new Equipo(spyDeports,"AverSiEstoAnda");
		
		otroEquipo.agregarDeportista(deportista1);
		otroEquipo.agregarDeportista(deportista2);
		otroEquipo.sacarDeportista(deportista1);
		
		verify(spyDeports.remove(deportista1));
		
	}
	
	
	

}
