package controlador;

import vista.EstadisticaElectoral;

import modelo.DatosConsola;
import modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class Controlador implements ActionListener{

	EstadisticaElectoral vista = new EstadisticaElectoral();
	Modelo modelo = new Modelo();
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
			
	public Controlador(EstadisticaElectoral vista) {
		this.vista = vista;
		this.vista.btnEncender.addActionListener(this);
		this.vista.btnReset.addActionListener(this);
		this.vista.elegirporcomunidad.addActionListener(this);
		this.vista.elegirporedad.addActionListener(this);
		this.vista.btnInforme.addActionListener(this);
		this.vista.btnSalirInforme.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	 
		
		
		if(e.getSource() == vista.btnEncender) {
			
			try {
				
				vista.textArea.setText("");
				vista.lblVotando.setVisible(true);
				vista.lblTitulo.setVisible(true);
				modelo.arrancar(vista.textArea);
				vista.btnReset.setVisible(true);
				vista.btnEncender.setVisible(false); 
				vista.lblPortada1.setVisible(false);
				vista.btnInforme.setVisible(true);
				vista.btnReset.setVisible(true);
				vista.elegirporcomunidad.setVisible(true);
				vista.elegirporedad.setVisible(true);
				vista.btnSalirInforme.setVisible(true);
				vista.lblLogo.setVisible(false);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		} 
	
	
		if(e.getSource() == vista.btnReset) {
			
			try {
				
				vista.visualizargraficas.setVisible(false);
				this.modelo.eliminarDatosTable(sessionFactory);
				this.modelo.resetearIdTable(sessionFactory);
				vista.btnReset.setVisible(false);
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.btnInforme.setVisible(false);
				vista.elegirporcomunidad.setVisible(false);
				vista.elegirporedad.setVisible(false);
				vista.btnSalirInforme.setVisible(false);
				vista.scrollPane.setVisible(false);
				vista.textArea.setVisible(false);
				vista.btnEncender.setVisible(true);
				vista.lblPortada1.setVisible(true);
				vista.lblLogo.setVisible(false);
				
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
	
	
		
		if(e.getSource() == vista.btnInforme) {
			
			try {
				
				vista.visualizargraficas.setVisible(false);
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(false);
				vista.scrollPane.setVisible(true);
				vista.textArea.setVisible(true);
				vista.lblLogo.setVisible(false);
				
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
		
		if(e.getSource() == vista.btnSalirInforme) {
			
			vista.visualizargraficas.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			vista.lblPortada1.setVisible(true);
			vista.lblLogo.setVisible(false);
			
		}
		
		
		vista.visualizargraficas.removeAll();
		
		if(e.getSource() == vista.elegirporedad) {
			
			String rangoSelecionado = (String) vista.elegirporedad.getSelectedItem();
			
			if("Rango 18 - 25".equalsIgnoreCase(rangoSelecionado)) {
				
				vista.visualizargraficas.setVisible(false);
				vista.visualizargraficas.removeAll();
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(false);
				vista.scrollPane.setVisible(false);
				vista.textArea.setVisible(false);
				
				Integer partido1825x = this.modelo.contarByRangoPartido(sessionFactory, 18, 25, "PSOE");
				Integer partido1825y = this.modelo.contarByRangoPartido(sessionFactory, 18, 25, "PP");
				Integer partido1825w = this.modelo.contarByRangoPartido(sessionFactory, 18, 25, "UP");
				Integer partido1825z = this.modelo.contarByRangoPartido(sessionFactory, 18, 25, "VOX");
			 
				String votosrango1825 = "Votos Rango 18 - 25";
				
				ChartPanel panel1 = calcularGraficos(votosrango1825, partido1825x, partido1825y, partido1825w, partido1825z);
				vista.visualizargraficas.add(panel1);
				vista.visualizargraficas.setVisible(true);
				calcularGanador(partido1825x,partido1825y,partido1825w,partido1825z);
				
			} else if ("Rango 26 - 40".equalsIgnoreCase(rangoSelecionado)) {
				
				vista.visualizargraficas.setVisible(false);
				vista.visualizargraficas.removeAll();
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(false);
				vista.scrollPane.setVisible(false);
				vista.textArea.setVisible(false);
				
				
				Integer partido2640x = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "PSOE");
				Integer partido2640y = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "PP");
				Integer partido2640w = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "UP");
				Integer partido2640z = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "VOX");
				
				
				String votosrango2640 = "Votos Rango 26 - 40";
				ChartPanel panel2 = calcularGraficos(votosrango2640,partido2640x, partido2640y, partido2640w, partido2640z);
				vista.visualizargraficas.add(panel2);
				vista.visualizargraficas.setVisible(true);
				calcularGanador(partido2640x,partido2640y,partido2640w,partido2640z);
				
			} else if ("Rango 41 - 65".equalsIgnoreCase(rangoSelecionado)) {
				
				vista.visualizargraficas.setVisible(false);
				vista.visualizargraficas.removeAll();
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(false);
				vista.scrollPane.setVisible(false);
				vista.textArea.setVisible(false);
				
				Integer partido4165x = this.modelo.contarByRangoPartido(sessionFactory, 41, 65, "PSOE");
				Integer partido4165y = this.modelo.contarByRangoPartido(sessionFactory, 41, 65, "PP");
				Integer partido4165w = this.modelo.contarByRangoPartido(sessionFactory, 41, 65, "UP");
				Integer partido4165z = this.modelo.contarByRangoPartido(sessionFactory, 41, 65, "VOX");
			
				String votosrango4165 = "Votos Rango 41 - 65";
				ChartPanel panel3 = calcularGraficos(votosrango4165,partido4165x, partido4165y, partido4165w, partido4165z);
				vista.visualizargraficas.add(panel3);
				vista.visualizargraficas.setVisible(true);
				calcularGanador(partido4165x,partido4165y,partido4165w,partido4165z);
				
			} else if ("Rango mas 65".equalsIgnoreCase(rangoSelecionado)) {
				
				vista.visualizargraficas.setVisible(false);
				vista.visualizargraficas.removeAll();
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(false);
				vista.scrollPane.setVisible(false);
				vista.textArea.setVisible(false);
				
				Integer partidox = this.modelo.contarByRangoPartido(sessionFactory, 65, 100, "PSOE");
				Integer partidoy = this.modelo.contarByRangoPartido(sessionFactory, 65, 100, "PP");
				Integer partidow = this.modelo.contarByRangoPartido(sessionFactory, 65, 100, "UP");
				Integer partidoz = this.modelo.contarByRangoPartido(sessionFactory, 65, 100, "VOX");
			
				String votosrangomas65 = "Votos Rango mas 65";
				ChartPanel panel4 = calcularGraficos(votosrangomas65,partidox, partidoy, partidow, partidoz);
				vista.visualizargraficas.add(panel4);
				vista.visualizargraficas.setVisible(true);
				calcularGanador(partidox,partidoy,partidow,partidoz);
				
			}
		
			
			
		}
		
		if(e.getSource() == vista.elegirporcomunidad) {
		
			String comunidadSelecionado = (String) vista.elegirporcomunidad.getSelectedItem();
			
		if("Andaluc�a".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosAndaluciax = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "PSOE");
			Integer nmvotosAndaluciay = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "PP");
			Integer nmvotosAndaluciaw = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "UP");
			Integer nmvotosAndaluciaz = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "VOX");
		
			String votoscomunidad = "Votos Andalucia";
			ChartPanel panelBar1 = crearGraficosBarras(votoscomunidad,nmvotosAndaluciax,nmvotosAndaluciay,nmvotosAndaluciaw,nmvotosAndaluciaz);
			vista.visualizargraficas.add(panelBar1);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosAndaluciax,nmvotosAndaluciay,nmvotosAndaluciaw,nmvotosAndaluciaz);
			
		} else if("Arag�n".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosAragonx = this.modelo.contarByComunidadPartido(sessionFactory, "Arag�n", "PSOE");
			Integer nmvotosAragony = this.modelo.contarByComunidadPartido(sessionFactory, "Arag�n", "PP");
			Integer nmvotosAragonw = this.modelo.contarByComunidadPartido(sessionFactory, "Arag�n", "UP");
			Integer nmvotosAragonz = this.modelo.contarByComunidadPartido(sessionFactory, "Arag�n", "VOX");
			
			String votoscomunidad = "Votos Arag�n";
			ChartPanel panelBar2 = crearGraficosBarras(votoscomunidad,nmvotosAragonx,nmvotosAragony,nmvotosAragonw,nmvotosAragonz);
			vista.visualizargraficas.add(panelBar2);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosAragonx,nmvotosAragony,nmvotosAragonw,nmvotosAragonz);
			
		}else if("Asturias".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosAsturiasx = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "PSOE");
			Integer nmvotosAsturiasy = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "PP");
			Integer nmvotosAsturiasw = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "UP");
			Integer nmvotosAsturiasz = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "VOX");
			
			String votoscomunidad = "Votos Asturias";
			ChartPanel panelBar3 = crearGraficosBarras(votoscomunidad,nmvotosAsturiasx,nmvotosAsturiasy,nmvotosAsturiasw,nmvotosAsturiasz);
			vista.visualizargraficas.add(panelBar3);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosAsturiasx,nmvotosAsturiasy,nmvotosAsturiasw,nmvotosAsturiasz);
			
		}else if("Islas Baleares".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosBalearesx = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "PSOE");
			Integer nmvotosBalearesy = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "PP");
			Integer nmvotosBalearesw = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "UP");
			Integer nmvotosBalearesz = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "VOX");
			
			String votoscomunidad = "Votos Baleares";
			ChartPanel panelBar4 = crearGraficosBarras(votoscomunidad,nmvotosBalearesx,nmvotosBalearesy,nmvotosBalearesw,nmvotosBalearesz);
			vista.visualizargraficas.add(panelBar4);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosBalearesx,nmvotosBalearesy,nmvotosBalearesw,nmvotosBalearesz);
			
		}else if("Canarias".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCanariasx = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "PSOE");
			Integer nmvotosCanariasy = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "PP");
			Integer nmvotosCanariasw = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "UP");
			Integer nmvotosCanariasz = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "VOX");
			
			String votoscomunidad = "Votos Canarias";
			ChartPanel panelBar5 = crearGraficosBarras(votoscomunidad,nmvotosCanariasx,nmvotosCanariasy,nmvotosCanariasw,nmvotosCanariasz);
			vista.visualizargraficas.add(panelBar5);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosCanariasx,nmvotosCanariasy,nmvotosCanariasw,nmvotosCanariasz);
			
		}else if("Cantabria".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCantabriax = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "PSOE");
			Integer nmvotosCantabriay = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "PP");
			Integer nmvotosCantabriaw = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "UP");
			Integer nmvotosCantabriaz = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "VOX");
			
			String votoscomunidad = "Votos Cantabria";
			ChartPanel panelBar6 = crearGraficosBarras(votoscomunidad,nmvotosCantabriax,nmvotosCantabriaw,nmvotosCantabriay,nmvotosCantabriaz);
			vista.visualizargraficas.add(panelBar6);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosCantabriax,nmvotosCantabriay,nmvotosCantabriaw,nmvotosCantabriaz);
			
		}else if("Castilla La Mancha".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCastillaLaManchax = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "PSOE");
			Integer nmvotosCastillaLaManchay = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "PP");
			Integer nmvotosCastillaLaManchaw = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "UP");
			Integer nmvotosCastillaLaManchaz = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "VOX");
			
			String votoscomunidad = "Votos Castilla-La Mancha";
			ChartPanel panelBar7 = crearGraficosBarras(votoscomunidad,nmvotosCastillaLaManchax,nmvotosCastillaLaManchay,nmvotosCastillaLaManchaw,nmvotosCastillaLaManchaz);
			vista.visualizargraficas.add(panelBar7);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosCastillaLaManchax,nmvotosCastillaLaManchay,nmvotosCastillaLaManchaw,nmvotosCastillaLaManchaz);
					
		}else if("Castilla y Le�n".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCastillayLe�nx = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y Le�n", "PSOE");
			Integer nmvotosCastillayLe�ny = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y Le�n", "PP");
			Integer nmvotosCastillayLe�nw = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y Le�n", "UP");
			Integer nmvotosCastillayLe�nz = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y Le�n", "VOX");
			
			String votoscomunidad = "Votos Castilla y Le�n";
			ChartPanel panelBar8 = crearGraficosBarras(votoscomunidad,nmvotosCastillayLe�nx,nmvotosCastillayLe�ny,nmvotosCastillayLe�nw,nmvotosCastillayLe�nz);
			vista.visualizargraficas.add(panelBar8);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosCastillayLe�nx,nmvotosCastillayLe�ny,nmvotosCastillayLe�nw,nmvotosCastillayLe�nz);
			
			
		}else if("Catalunia".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCatalu�ax = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "PSOE");
			Integer nmvotosCatalu�ay = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "PP");
			Integer nmvotosCatalu�aw = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "UP");
			Integer nmvotosCatalu�az = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "VOX");
			
			String votoscomunidad = "Votos Catalu�a";
			ChartPanel panelBar9 = crearGraficosBarras(votoscomunidad,nmvotosCatalu�ax,nmvotosCatalu�ay,nmvotosCatalu�aw,nmvotosCatalu�az);
			vista.visualizargraficas.add(panelBar9);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosCatalu�ax,nmvotosCatalu�ay,nmvotosCatalu�aw,nmvotosCatalu�az);
			
		}else if("Comunidad Valenciana".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosValencianax = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "PSOE");
			Integer nmvotosValencianay = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "PP");
			Integer nmvotosValencianaw = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "UP");
			Integer nmvotosValencianaz = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "VOX");
			
			String votoscomunidad = "Votos Comunidad Valenciana";
			ChartPanel panelBar10 = crearGraficosBarras(votoscomunidad,nmvotosValencianax,nmvotosValencianay,nmvotosValencianaw,nmvotosValencianaz);
			vista.visualizargraficas.add(panelBar10);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosValencianax,nmvotosValencianay,nmvotosValencianaw,nmvotosValencianaz);
		
			
		}else if("Extremadura".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosExtremadurax = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "PSOE");
			Integer nmvotosExtremaduray = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "PP");
			Integer nmvotosExtremaduraw = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "UP");
			Integer nmvotosExtremaduraz = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "VOX");
			
			String votoscomunidad = "Votos Extremadura";
			ChartPanel panelBar11 = crearGraficosBarras(votoscomunidad,nmvotosExtremadurax,nmvotosExtremaduray,nmvotosExtremaduraw,nmvotosExtremaduraz);
			vista.visualizargraficas.add(panelBar11);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosExtremadurax,nmvotosExtremaduray,nmvotosExtremaduraw,nmvotosExtremaduraz);
			
		}else if("Galicia".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosGaliciax = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "PSOE");
			Integer nmvotosGaliciay = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "PP");
			Integer nmvotosGaliciaw = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "UP");
			Integer nmvotosGaliciaz = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "VOX");
			
			String votoscomunidad = "Votos Galicia";
			ChartPanel panelBar12 = crearGraficosBarras(votoscomunidad,nmvotosGaliciax,nmvotosGaliciay,nmvotosGaliciaw,nmvotosGaliciaz);
			vista.visualizargraficas.add(panelBar12);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosGaliciax,nmvotosGaliciay,nmvotosGaliciaw,nmvotosGaliciaz);
			
		}else if("La Rioja".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosRiojax = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "PSOE");
			Integer nmvotosRiojay = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "PP");
			Integer nmvotosRiojaw = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "UP");
			Integer nmvotosRiojaz = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "VOX");
			
			String votoscomunidad = "Votos La Rioja";
			ChartPanel panelBar13 = crearGraficosBarras(votoscomunidad,nmvotosRiojax,nmvotosRiojay,nmvotosRiojaw,nmvotosRiojaz);
			vista.visualizargraficas.add(panelBar13);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosRiojax,nmvotosRiojay,nmvotosRiojaw,nmvotosRiojaz);
			
			
		}else if("Murcia".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosMurciax = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "PSOE");
			Integer nmvotosMurciay = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "PP");
			Integer nmvotosMurciaw = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "UP");
			Integer nmvotosMurciaz = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "VOX");
			
			String votoscomunidad = "Votos Murcia";
			ChartPanel panelBar14 = crearGraficosBarras(votoscomunidad,nmvotosMurciax,nmvotosMurciay,nmvotosMurciaw,nmvotosMurciaz);
			vista.visualizargraficas.add(panelBar14);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosMurciax,nmvotosMurciay,nmvotosMurciaw,nmvotosMurciaz);
			
			
		}else if("Navarra".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosNavarrax = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "PSOE");
			Integer nmvotosNavarray = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "PP");
			Integer nmvotosNavarraw = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "UP");
			Integer nmvotosNavarraz = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "VOX");
			
			String votoscomunidad = "Votos Navarra";
			ChartPanel panelBar19 = crearGraficosBarras(votoscomunidad,nmvotosNavarrax,nmvotosNavarray,nmvotosNavarraw,nmvotosNavarraz);
			vista.visualizargraficas.add(panelBar19);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosNavarrax,nmvotosNavarray,nmvotosNavarraw,nmvotosNavarraz);
			
		}else if("Pa�s Vasco".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosVascox = this.modelo.contarByComunidadPartido(sessionFactory, "Pa�s Vasco", "PSOE");
			Integer nmvotosVascoy = this.modelo.contarByComunidadPartido(sessionFactory, "Pa�s Vasco", "PP");
			Integer nmvotosVascow = this.modelo.contarByComunidadPartido(sessionFactory, "Pa�s Vasco", "UP");
			Integer nmvotosVascoz = this.modelo.contarByComunidadPartido(sessionFactory, "Pa�s Vasco", "VOX");
			
			String votoscomunidad = "Votos Pa�s Vasco";
			ChartPanel panelBar15 = crearGraficosBarras(votoscomunidad,nmvotosVascox,nmvotosVascoy,nmvotosVascow,nmvotosVascoz);
			vista.visualizargraficas.add(panelBar15);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosVascox,nmvotosVascoy,nmvotosVascow,nmvotosVascoz);
			
			
		}else if("Ceuta".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCeutax = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "PSOE");
			Integer nmvotosCeutay = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "PP");
			Integer nmvotosCeutaw = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "PP");
			Integer nmvotosCeutaz = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "VOX");
			
			String votoscomunidad = "Votos Ceuta";
			ChartPanel panelBar16 = crearGraficosBarras(votoscomunidad,nmvotosCeutax,nmvotosCeutay,nmvotosCeutaw,nmvotosCeutaz);
			vista.visualizargraficas.add(panelBar16);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosCeutax,nmvotosCeutay,nmvotosCeutaw,nmvotosCeutaz);
			
		}else if("Melilla".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosMelillax = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "PSOE");
			Integer nmvotosMelillay = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "PP");
			Integer nmvotosMelillaw = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "UP");
			Integer nmvotosMelillaz = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "VOX");
			
			String votoscomunidad = "Votos Melilla";
			ChartPanel panelBar17 = crearGraficosBarras(votoscomunidad,nmvotosMelillax,nmvotosMelillay,nmvotosMelillaw,nmvotosMelillaz);
			vista.visualizargraficas.add(panelBar17);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosMelillax,nmvotosMelillay,nmvotosMelillaw,nmvotosMelillaz);
			
		}else if("Total Nacional".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.visualizargraficas.setVisible(false);
			vista.visualizargraficas.removeAll();
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosNacionalx = this.modelo.contarByTotalPartido(sessionFactory,"PSOE");
			Integer nmvotosNacionaly = this.modelo.contarByTotalPartido(sessionFactory,"PP");
			Integer nmvotosNacionalw = this.modelo.contarByTotalPartido(sessionFactory,"UP");
			Integer nmvotosNacionalz = this.modelo.contarByTotalPartido(sessionFactory,"VOX");
			
			String votosnacional = "Votos Total Nacional";
			ChartPanel panelBar18 = crearGraficosBarras(votosnacional,nmvotosNacionalx,nmvotosNacionaly,nmvotosNacionalw,nmvotosNacionalz);
			vista.visualizargraficas.add(panelBar18);
			vista.visualizargraficas.setVisible(true);
			calcularGanador(nmvotosNacionalx,nmvotosNacionaly,nmvotosNacionalw,nmvotosNacionalz);
			
		}
		
		}
		
		

		
		
	}

	public ChartPanel calcularGraficos(String votos, Integer partidox, Integer partidoy, Integer partidow, Integer partidoz) {
		
		DefaultPieDataset datos = new DefaultPieDataset();
		
		datos.setValue("PSOE (" + partidox + " Voto(s)) ", partidox);
		datos.setValue("PP (" + partidoy + " Voto(s)) ", partidoy);
		datos.setValue("UP (" + partidow + " Voto(s)) ", partidow);
		datos.setValue("VOX (" + partidoz + " Voto(s)) ", partidoz);
		
		JFreeChart graficocircular = ChartFactory.createPieChart(votos, datos, true, true, false);
		ChartPanel panel = new ChartPanel(graficocircular);
		
		return panel;
	}

	public ChartPanel crearGraficosBarras(String votos, Integer partidox, Integer partidoy, Integer partidow, Integer partidoz) {
		
		final String Partidox = "PSOE";
		final String Partidoy = "PP";
		final String Partidow = "UP";
		final String Partidoz = "VOX";
		
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	    dataset.setValue(partidox, Partidox, "PSOE");
	    dataset.setValue(partidoy, Partidoy, "PP");
	    dataset.setValue(partidow, Partidow, "UP");
	    dataset.setValue(partidoz, Partidoz, "VOX");
		
	    JFreeChart chart = ChartFactory.createBarChart3D(votos, "Partidos Politicos",
	    		   "Votos", dataset, PlotOrientation.VERTICAL, true,
	    		   true, false);
	    ChartPanel panelBar  = new ChartPanel(chart);
	   
		
	    return panelBar;
	}
	
	public void calcularGanador(int x, int y, int w, int z) {
		
		if(x > y && x > w && x > z) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(y > z && y > w && y > z) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/pp_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(w > x && w > y && w > z) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/up_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(z > x && z > y && z > w) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/vox_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((x == y) && (x > z && x > w)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((y == z) && (y > x && y > w)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/pp_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((w == z) && (w > x && w > y)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/up_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((z == x) && (z > y && z > w)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/vox_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((y == w) && (y > z && y > x)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/up_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((x == w) && (x > z && x > y)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((x == y && x == z) && (x > w)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((y == z && y == z) && (y > w)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/pp_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((w == z && w == x) && (w > y)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/up_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((z == x && z == y) && (z > w)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/vox_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((y == w && y == z) && (y > x)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/pp_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if((x == w && x == z) && (x > y)) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(x == y && x == z && x == w) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(y == z && y == z && y == w) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/pp_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(w == z && w == x && w == y) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/up_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(z == x && z == y && z == w) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/vox_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(y == w && y == z && y == x) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/pp_1.png"));
			vista.lblLogo.setVisible(true);
			
		}else if(x == w && x == z && x == y) {
			
			vista.lblLogo.setIcon(new ImageIcon("imagenes/psoe_1.png"));
			vista.lblLogo.setVisible(true);
			
		}
		
		
		
	
	}
	
}
