package oponentes;

import java.util.Date;

public class Deportista implements Oponente{
	String nombre;
	String apellido;
	Date fechaNacimiento;
	String lugarDeNacimiento;
	
	public Deportista(String nombre,String apellido,Date fNac,String  lugarDeNacimiento) {
		
		this.nombre=nombre;
		this.apellido = apellido;
		this.fechaNacimiento=fNac;
		this.lugarDeNacimiento=lugarDeNacimiento;
		
	}


	
	@Override
	public String nombre() {
		return this.getNombre() + " " + this.getApellido();
	}

	private String getNombre() {
		return nombre;
	}
	
	private String getApellido() {
		return apellido;
	}
	
	public Date getFnacimiento() {
		
		return this.fechaNacimiento;		
	}
	
	public String getLugarDeNacimiento() {
		
		return this.lugarDeNacimiento;
	}
	
	
}


