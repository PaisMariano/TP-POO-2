package oponentes;

import java.sql.Date;

public class Deportista extends Oponentes{
	String nombre;
	String apellido;
	Date fechaNacimiento;
	String lugarDeNacimiento;
	
	public Deportista(String nombre,String apellido,Date fechaNacimiento,String  lugarDeNacimiento) {
		
		this.nombre=nombre;
		this.apellido = apellido;
		this.fechaNacimiento=fechaNacimiento;
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
	
}


