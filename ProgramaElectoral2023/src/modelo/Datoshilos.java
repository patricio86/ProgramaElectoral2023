package modelo;

public class Datoshilos {

	private String nombreComunidad;
	private int rango1825;
	private int rango2640;
	private int rango4165;
	private int rango66;
	
	public Datoshilos(String nombreComunidad, int rango1825, int rango2640, int rango4165, int rango66) {
		this.nombreComunidad = nombreComunidad;
		this.rango1825 = rango1825;
		this.rango2640 = rango2640;
		this.rango4165 = rango4165;
		this.rango66 = rango66;
	}

	
	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public int getRango1825() {
		return rango1825;
	}

	public void setRango1825(int rango1825) {
		this.rango1825 = rango1825;
	}

	public int getRango2640() {
		return rango2640;
	}

	public void setRango2640(int rango2640) {
		this.rango2640 = rango2640;
	}

	public int getRango4165() {
		return rango4165;
	}

	public void setRango4165(int rango4165) {
		this.rango4165 = rango4165;
	}

	public int getRango66() {
		return rango66;
	}

	public void setRango66(int rango66) {
		this.rango66 = rango66;
	}

	@Override
	public String toString() {
		return "Datoshilos [nombreComunidad=" + nombreComunidad + ", rango1825=" + rango1825 + ", rango2640="
				+ rango2640 + ", rango4165=" + rango4165 + ", rango66=" + rango66 + "]";
	}

	
	
	
}
