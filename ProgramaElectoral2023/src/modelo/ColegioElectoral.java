package modelo;

public class ColegioElectoral {

	private static Object object = new Object();
	private boolean comprobarpartido = false;
	private static ColegioElectoral instance;
		
		public ColegioElectoral() {
			
		}
		
		private synchronized static void createInstance() {
			if (null == instance) {
				instance = new ColegioElectoral();
			}
		}
		
		public static ColegioElectoral getInstance() {
			if(null == instance) {
				createInstance();
			}
			return instance;
		}

		public Boolean votar(int edad, int voto) {
		
			synchronized(object) {
				
				if(18 <= edad && edad <= 25 ) {
					
					if(0 <= voto && voto <= 30) {
						
						comprobarpartido = true;
						
					} else if(31 <= voto && voto <= 50) {
								
						comprobarpartido = true;
						
					} else if(51 <= voto && voto <= 70) {
						
						comprobarpartido = true;
						
					} else if(71 <= voto && voto <= 100) {
						
						comprobarpartido = true;
						
					}
					
				} else if(26 <= edad && edad <= 40) {
					
					if(0 < voto && voto < 20) {
						
					
						comprobarpartido = true;
						
					} else if(21 <= voto && voto <= 55) {
								
						
						comprobarpartido = true;
						
					} else if(56 <= voto && voto <= 85) {
						
						
						comprobarpartido = true;
						
					} else if(86 <= voto && voto <= 100) {
						
						
						comprobarpartido = true;
						
					}
					
					
				} else if(41 <= edad && edad <= 65 ) {
					
					if(0 <= voto && voto <= 10) {
						
						
						comprobarpartido = true;
						
					} else if(11 <= voto && voto <= 55) {
								
						
						comprobarpartido = true;
						
					} else if(56 <= voto && voto <= 90) {
						
						
						comprobarpartido = true;
						
					} else if(91 <= voto && voto <= 100) {
						
						
						comprobarpartido = true;
						
					}
					
					
				} else if(66 <= edad ) {
					
					if(0 <= voto && voto <= 25) {
						
						
						comprobarpartido = true;
						
					} else if(26 <= voto && voto <= 60) {
								
						
						comprobarpartido = true;
						
					} else if(61 <= voto && voto <= 95) {
						
						
						comprobarpartido = true;
						
					} else if(96 <= voto && voto <= 100) {
						
						
						comprobarpartido = true;
						
					}
					
					
				}
			}
			return comprobarpartido;
			
			
		}
		
}
