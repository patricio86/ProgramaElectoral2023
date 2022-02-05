package modelo;

public class DatosConsola {

	private int edad;
	private String comunidad;
	
	

	public DatosConsola(int edad, String comunidad) {
		this.edad = edad;
		this.comunidad = comunidad;
	}

	
	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	@Override
	public String toString() {
		return "DatosConsola [edad=" + edad + ", comunidad=" + comunidad + "]";
	}
	
	
}
