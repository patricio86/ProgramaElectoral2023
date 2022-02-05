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
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		} 
	
	
		if(e.getSource() == vista.btnReset) {
			
			try {
				
				
				
				this.modelo.eliminarDatosTable(sessionFactory);
				this.modelo.resetearIdTable(sessionFactory);
				vista.btnEncender.setVisible(true);
				vista.btnReset.setVisible(false);
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(true);
				vista.btnInforme.setVisible(false);
				vista.elegirporcomunidad.setVisible(false);
				vista.elegirporedad.setVisible(false);
				vista.btnSalirInforme.setVisible(false);
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
	
	
		
		if(e.getSource() == vista.btnInforme) {
			
			try {
				
				vista.lblVotando.setVisible(false);
				vista.lblTitulo.setVisible(false);
				vista.lblPortada1.setVisible(false);
				vista.scrollPane.setVisible(true);
				vista.textArea.setVisible(true);
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
		
		if(e.getSource() == vista.btnSalirInforme) {
			
			vista.lblPortada1.setVisible(true);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			
			
			
		}
		
		String rangoSelecionado = (String) vista.elegirporedad.getSelectedItem();
		String comunidadSelecionado = (String) vista.elegirporcomunidad.getSelectedItem();
		
		if("Rango 18 - 25".equalsIgnoreCase(rangoSelecionado)) {
			
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
			vista.visualizargraficas1.add(panel1);
			vista.visualizargraficas1.setVisible(true);
			vista.visualizargraficas2.setVisible(false);
			vista.visualizargraficas3.setVisible(false);
			vista.visualizargraficas4.setVisible(false);
			
			/*
			if((partido1825x > partido1825y) && (partido1825x > partido1825w) && (partido1825x > partido1825z)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/psoe.png"));
				
			}else if((partido1825y > partido1825x) && (partido1825y > partido1825w) && (partido1825y > partido1825z)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/pp.png"));
				
			}else if((partido1825w > partido1825x) && (partido1825w > partido1825y) && (partido1825w > partido1825z)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/up.png"));
				
			}else if((partido1825z > partido1825x) && (partido1825z > partido1825y) && (partido1825z > partido1825w)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/vox.png"));
				
			}
			*/
			
			
			
			
		} else if ("Rango 26 - 40".equalsIgnoreCase(rangoSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			
			Integer partido2640x = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "PSOE");
			Integer partido2640y = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "PP");
			Integer partido2640w = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "UP");
			Integer partido2640z = this.modelo.contarByRangoPartido(sessionFactory, 26, 40, "VOX");
			
			/*
			if((partido2640x > partido2640y) && (partido2640x > partido2640w) && (partido2640x > partido2640z)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/psoe.png"));
				
			}else if((partido2640y > partido2640x) && (partido2640y > partido2640w) && (partido2640y > partido2640z)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/pp.png"));
				
			}else if((partido2640w > partido2640x) && (partido2640w > partido2640y) && (partido2640w > partido2640z)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/up.png"));
				
			}else if((partido2640z > partido2640x) && (partido2640z > partido2640y) && (partido2640z > partido2640w)) {
				
				vista.lblLogoGanador.setIcon(new ImageIcon("/imagenes/vox.png"));
				
			}
		*/
			String votosrango2640 = "Votos Rango 26 - 40";
			ChartPanel panel2 = calcularGraficos(votosrango2640,partido2640x, partido2640y, partido2640w, partido2640z);
			vista.visualizargraficas2.add(panel2);
			vista.visualizargraficas2.setVisible(true);
			vista.visualizargraficas1.setVisible(false);
			vista.visualizargraficas3.setVisible(false);
			vista.visualizargraficas4.setVisible(false);
			
		} else if ("Rango 41 - 65".equalsIgnoreCase(rangoSelecionado)) {
			
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
			vista.visualizargraficas3.add(panel3);
			vista.visualizargraficas3.setVisible(true);
			vista.visualizargraficas1.setVisible(false);
			vista.visualizargraficas2.setVisible(false);
			vista.visualizargraficas4.setVisible(false);
			
		} else if ("Rango mas 65".equalsIgnoreCase(rangoSelecionado)) {
			
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
			vista.visualizargraficas4.add(panel4);
			vista.visualizargraficas4.setVisible(true);
			vista.visualizargraficas1.setVisible(false);
			vista.visualizargraficas2.setVisible(false);
			vista.visualizargraficas3.setVisible(false);
			
		}
	
		
		
		if("Andalucía".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosAndaluciax = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "PSOE");
			Integer nmvotosAndaluciaw = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "PP");
			Integer nmvotosAndaluciay = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "UP");
			Integer nmvotosAndaluciaz = this.modelo.contarByComunidadPartido(sessionFactory, "Andalucia", "VOX");
		
			String votoscomunidad = "Votos Andalucia";
			ChartPanel panelBar1 = crearGraficosBarras(votoscomunidad,nmvotosAndaluciax,nmvotosAndaluciaw,nmvotosAndaluciay,nmvotosAndaluciaz);
			vista.panelAndalucia.add(panelBar1);
			vista.panelAndalucia.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
		} else if("Aragón".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosAragónx = this.modelo.contarByComunidadPartido(sessionFactory, "Aragón", "PSOE");
			Integer nmvotosAragónw = this.modelo.contarByComunidadPartido(sessionFactory, "Aragón", "PP");
			Integer nmvotosAragóny = this.modelo.contarByComunidadPartido(sessionFactory, "Aragón", "UP");
			Integer nmvotosAragónz = this.modelo.contarByComunidadPartido(sessionFactory, "Aragón", "VOX");
			
			String votoscomunidad = "Votos Aragón";
			ChartPanel panelBar2 = crearGraficosBarras(votoscomunidad,nmvotosAragónx,nmvotosAragónw,nmvotosAragóny,nmvotosAragónz);
			vista.panelAragon.add(panelBar2);
			vista.panelAragon.setVisible(true);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Asturias".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosAsturiasx = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "PSOE");
			Integer nmvotosAsturiasw = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "PP");
			Integer nmvotosAsturiasy = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "UP");
			Integer nmvotosAsturiasz = this.modelo.contarByComunidadPartido(sessionFactory, "Asturias", "VOX");
			
			String votoscomunidad = "Votos Asturias";
			ChartPanel panelBar3 = crearGraficosBarras(votoscomunidad,nmvotosAsturiasx,nmvotosAsturiasw,nmvotosAsturiasy,nmvotosAsturiasz);
			vista.panelAsturias.add(panelBar3);
			vista.panelAsturias.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
		}else if("Islas Baleares".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosBalearesx = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "PSOE");
			Integer nmvotosBalearesw = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "PP");
			Integer nmvotosBalearesy = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "UP");
			Integer nmvotosBalearesz = this.modelo.contarByComunidadPartido(sessionFactory, "Baleares", "VOX");
			
			String votoscomunidad = "Votos Baleares";
			ChartPanel panelBar4 = crearGraficosBarras(votoscomunidad,nmvotosBalearesx,nmvotosBalearesw,nmvotosBalearesy,nmvotosBalearesz);
			vista.panelBaleares.add(panelBar4);
			vista.panelBaleares.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
		}else if("Canarias".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosBalearesx = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "PSOE");
			Integer nmvotosBalearesw = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "PP");
			Integer nmvotosBalearesy = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "UP");
			Integer nmvotosBalearesz = this.modelo.contarByComunidadPartido(sessionFactory, "Canarias", "VOX");
			
			String votoscomunidad = "Votos Canarias";
			ChartPanel panelBar5 = crearGraficosBarras(votoscomunidad,nmvotosBalearesx,nmvotosBalearesw,nmvotosBalearesy,nmvotosBalearesz);
			vista.panelCanarias.add(panelBar5);
			vista.panelCanarias.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
		}else if("Cantabria".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCantabriax = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "PSOE");
			Integer nmvotosCantabriaw = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "PP");
			Integer nmvotosCantabriay = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "UP");
			Integer nmvotosCantabriaz = this.modelo.contarByComunidadPartido(sessionFactory, "Cantabria", "VOX");
			
			String votoscomunidad = "Votos Cantabria";
			ChartPanel panelBar6 = crearGraficosBarras(votoscomunidad,nmvotosCantabriax,nmvotosCantabriaw,nmvotosCantabriay,nmvotosCantabriaz);
			vista.panelCantabria.add(panelBar6);
			vista.panelCantabria.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Castilla La Mancha".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCastillaLaManchax = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "PSOE");
			Integer nmvotosCastillaLaManchaw = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "PP");
			Integer nmvotosCastillaLaManchay = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "UP");
			Integer nmvotosCastillaLaManchaz = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla La Mancha", "VOX");
			
			String votoscomunidad = "Votos Castilla-La Mancha";
			ChartPanel panelBar7 = crearGraficosBarras(votoscomunidad,nmvotosCastillaLaManchax,nmvotosCastillaLaManchaw,nmvotosCastillaLaManchay,nmvotosCastillaLaManchaz);
			vista.panelCastillaLaMancha.add(panelBar7);
			vista.panelCastillaLaMancha.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Castilla y León".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCastillayLeónx = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y León", "PSOE");
			Integer nmvotosCastillayLeónw = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y León", "PP");
			Integer nmvotosCastillayLeóny = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y León", "UP");
			Integer nmvotosCastillayLeónz = this.modelo.contarByComunidadPartido(sessionFactory, "Castilla y León", "VOX");
			
			String votoscomunidad = "Votos Castilla y León";
			ChartPanel panelBar8 = crearGraficosBarras(votoscomunidad,nmvotosCastillayLeónx,nmvotosCastillayLeónw,nmvotosCastillayLeóny,nmvotosCastillayLeónz);
			vista.panelCastillaLeon.add(panelBar8);
			vista.panelCastillaLeon.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Catalunia".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCataluñax = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "PSOE");
			Integer nmvotosCataluñaw = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "PP");
			Integer nmvotosCataluñay = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "UP");
			Integer nmvotosCataluñaz = this.modelo.contarByComunidadPartido(sessionFactory, "Catalunia", "VOX");
			
			String votoscomunidad = "Votos Cataluña";
			ChartPanel panelBar9 = crearGraficosBarras(votoscomunidad,nmvotosCataluñax,nmvotosCataluñaw,nmvotosCataluñay,nmvotosCataluñaz);
			vista.panelCataluña.add(panelBar9);
			vista.panelCataluña.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Comunidad Valenciana".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosValencianax = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "PSOE");
			Integer nmvotosValencianaw = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "PP");
			Integer nmvotosValencianay = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "UP");
			Integer nmvotosValencianaz = this.modelo.contarByComunidadPartido(sessionFactory, "Comunidad Valenciana", "VOX");
			
			String votoscomunidad = "Votos Comunidad Valenciana";
			ChartPanel panelBar10 = crearGraficosBarras(votoscomunidad,nmvotosValencianax,nmvotosValencianaw,nmvotosValencianay,nmvotosValencianaz);
			vista.panelComunidadValenciana.add(panelBar10);
			vista.panelComunidadValenciana.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
		
			
		}else if("Extremadura".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosExtremadurax = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "PSOE");
			Integer nmvotosExtremaduraw = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "PP");
			Integer nmvotosExtremaduray = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "UP");
			Integer nmvotosExtremaduraz = this.modelo.contarByComunidadPartido(sessionFactory, "Extremadura", "VOX");
			
			String votoscomunidad = "Votos Extremadura";
			ChartPanel panelBar11 = crearGraficosBarras(votoscomunidad,nmvotosExtremadurax,nmvotosExtremaduraw,nmvotosExtremaduray,nmvotosExtremaduraz);
			vista.panelExtremadura.add(panelBar11);
			vista.panelExtremadura.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Galicia".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosGaliciax = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "PSOE");
			Integer nmvotosGaliciaw = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "PP");
			Integer nmvotosGaliciay = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "UP");
			Integer nmvotosGaliciaz = this.modelo.contarByComunidadPartido(sessionFactory, "Galicia", "VOX");
			
			String votoscomunidad = "Votos Galicia";
			ChartPanel panelBar12 = crearGraficosBarras(votoscomunidad,nmvotosGaliciax,nmvotosGaliciaw,nmvotosGaliciay,nmvotosGaliciaz);
			vista.panelGalicia.add(panelBar12);
			vista.panelGalicia.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("La Rioja".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosRiojax = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "PSOE");
			Integer nmvotosRiojaw = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "PP");
			Integer nmvotosRiojay = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "UP");
			Integer nmvotosRiojaz = this.modelo.contarByComunidadPartido(sessionFactory, "La Rioja", "VOX");
			
			String votoscomunidad = "Votos La Rioja";
			ChartPanel panelBar13 = crearGraficosBarras(votoscomunidad,nmvotosRiojax,nmvotosRiojaw,nmvotosRiojay,nmvotosRiojaz);
			vista.panelLaRioja.add(panelBar13);
			vista.panelLaRioja.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Murcia".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosMurciax = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "PSOE");
			Integer nmvotosMurciaw = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "PP");
			Integer nmvotosMurciay = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "UP");
			Integer nmvotosMurciaz = this.modelo.contarByComunidadPartido(sessionFactory, "Murcia", "VOX");
			
			String votoscomunidad = "Votos Murcia";
			ChartPanel panelBar14 = crearGraficosBarras(votoscomunidad,nmvotosMurciax,nmvotosMurciaw,nmvotosMurciay,nmvotosMurciaz);
			vista.panelMurcia.add(panelBar14);
			vista.panelMurcia.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
			
		}else if("Navarra".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosNavarrax = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "PSOE");
			Integer nmvotosNavarraw = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "PP");
			Integer nmvotosNavarray = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "UP");
			Integer nmvotosNavarraz = this.modelo.contarByComunidadPartido(sessionFactory, "Navarra", "VOX");
			
			String votoscomunidad = "Votos Navarra";
			ChartPanel panelBar14 = crearGraficosBarras(votoscomunidad,nmvotosNavarrax,nmvotosNavarraw,nmvotosNavarray,nmvotosNavarraz);
			vista.panelNavarra.add(panelBar14);
			vista.panelNavarra.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
		
			
		}else if("País Vasco".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosVascox = this.modelo.contarByComunidadPartido(sessionFactory, "País Vasco", "PSOE");
			Integer nmvotosVascow = this.modelo.contarByComunidadPartido(sessionFactory, "País Vasco", "PP");
			Integer nmvotosVascoy = this.modelo.contarByComunidadPartido(sessionFactory, "País Vasco", "UP");
			Integer nmvotosVascoz = this.modelo.contarByComunidadPartido(sessionFactory, "País Vasco", "VOX");
			
			String votoscomunidad = "Votos País Vasco";
			ChartPanel panelBar15 = crearGraficosBarras(votoscomunidad,nmvotosVascox,nmvotosVascow,nmvotosVascoy,nmvotosVascoz);
			vista.panelPaisVasco.add(panelBar15);
			vista.panelPaisVasco.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			
			
		}else if("Ceuta".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosCeutax = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "PSOE");
			Integer nmvotosCeutaw = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "PP");
			Integer nmvotosCeutay = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "PP");
			Integer nmvotosCeutaz = this.modelo.contarByComunidadPartido(sessionFactory, "Ceuta", "VOX");
			
			String votoscomunidad = "Votos Ceuta";
			ChartPanel panelBar16 = crearGraficosBarras(votoscomunidad,nmvotosCeutax,nmvotosCeutaw,nmvotosCeutay,nmvotosCeutaz);
			vista.panelCeuta.add(panelBar16);
			vista.panelCeuta.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNacional.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			vista.panelMelilla.setVisible(false);
			
		}else if("Melilla".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosMelillax = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "PSOE");
			Integer nmvotosMelillaw = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "PP");
			Integer nmvotosMelillay = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "UP");
			Integer nmvotosMelillaz = this.modelo.contarByComunidadPartido(sessionFactory, "Melilla", "VOX");
			
			String votoscomunidad = "Votos Melilla";
			ChartPanel panelBar17 = crearGraficosBarras(votoscomunidad,nmvotosMelillax,nmvotosMelillaw,nmvotosMelillay,nmvotosMelillaz);
			vista.panelMelilla.add(panelBar17);
			vista.panelMelilla.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMurcia.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
			
		}else if("Total Nacional".equalsIgnoreCase(comunidadSelecionado)) {
			
			vista.lblVotando.setVisible(false);
			vista.lblTitulo.setVisible(false);
			vista.lblPortada1.setVisible(false);
			vista.scrollPane.setVisible(false);
			vista.textArea.setVisible(false);
			
			Integer nmvotosNacionalx = this.modelo.contarByTotalPartido(sessionFactory,"PSOE");
			Integer nmvotosNacionalw = this.modelo.contarByTotalPartido(sessionFactory,"PP");
			Integer nmvotosNacionaly = this.modelo.contarByTotalPartido(sessionFactory,"UP");
			Integer nmvotosNacionalz = this.modelo.contarByTotalPartido(sessionFactory,"VOX");
			
			String votosnacional = "Votos Total Nacional";
			ChartPanel panelBar18 = crearGraficosBarras(votosnacional,nmvotosNacionalx,nmvotosNacionalw,nmvotosNacionaly,nmvotosNacionalz);
			vista.panelNacional.add(panelBar18);
			vista.panelNacional.setVisible(true);
			vista.panelAragon.setVisible(false);
			vista.panelAndalucia.setVisible(false);
			vista.panelAsturias.setVisible(false);
			vista.panelBaleares.setVisible(false);
			vista.panelCanarias.setVisible(false);
			vista.panelCantabria.setVisible(false);
			vista.panelCastillaLaMancha.setVisible(false);
			vista.panelCastillaLeon.setVisible(false);
			vista.panelCataluña.setVisible(false);
			vista.panelCeuta.setVisible(false);
			vista.panelComunidadValenciana.setVisible(false);
			vista.panelExtremadura.setVisible(false);
			vista.panelGalicia.setVisible(false);
			vista.panelLaRioja.setVisible(false);
			vista.panelMadrid.setVisible(false); 
			vista.panelMelilla.setVisible(false);
			vista.panelMurcia.setVisible(false);
			vista.panelNavarra.setVisible(false);
			vista.panelPaisVasco.setVisible(false);
		}
		
		
		
		

		
		
	}

	public ChartPanel calcularGraficos(String votos, Integer partidox, Integer partidoy, Integer partidow, Integer partidoz) {
		
		DefaultPieDataset datos = new DefaultPieDataset();
		
		datos.setValue("PSOE", partidox);
		datos.setValue("PP", partidoy);
		datos.setValue("UP", partidow);
		datos.setValue("VOX", partidoz);
		
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
	
}
