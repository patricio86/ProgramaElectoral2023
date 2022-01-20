package modelo;

public class Votacion {

	private int edad;
	private String comunidad;
	private String partidovotado;
	
	public Votacion() {
		this.edad = edad;
		this.comunidad = comunidad;
		this.partidovotado = partidovotado;
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

	public String getPartidovotado() {
		return partidovotado;
	}

	public void setPartidovotado(String partidovotado) {
		this.partidovotado = partidovotado;
	}

	@Override
	public String toString() {
		return "Votacion [edad=" + edad + ", comunidad=" + comunidad + ", partidovotado=" + partidovotado + "]";
	}

	

	
	
	
	
}
