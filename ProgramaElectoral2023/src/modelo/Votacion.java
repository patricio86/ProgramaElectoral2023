package modelo;
// Generated 20 ene 2022 20:40:18 by Hibernate Tools 5.4.32.Final

/**
 * Votacion generated by hbm2java
 */
public class Votacion implements java.io.Serializable {

	private int idVotacion;
	private int edad;
	private String comunidad;
	private String partidoVotado;

	public Votacion() {
	}

	public Votacion(int idVotacion, int edad, String comunidad, String partidoVotado) {
		this.idVotacion = idVotacion;
		this.edad = edad;
		this.comunidad = comunidad;
		this.partidoVotado = partidoVotado;
	}

	public int getIdVotacion() {
		return this.idVotacion;
	}

	public void setIdVotacion(int idVotacion) {
		this.idVotacion = idVotacion;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getComunidad() {
		return this.comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public String getPartidoVotado() {
		return this.partidoVotado;
	}

	public void setPartidoVotado(String partidoVotado) {
		this.partidoVotado = partidoVotado;
	}

}
