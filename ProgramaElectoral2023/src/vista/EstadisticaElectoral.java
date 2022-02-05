package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import modelo.Modelo;
import controlador.Controlador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class EstadisticaElectoral extends JFrame {

	public JPanel contentPane;
	public JComboBox elegirporedad;
	public JComboBox elegirporcomunidad;
	public JButton btnEncender;
	public JButton btnReset;
	public JPanel visualizargraficas1;
	public JButton btnInforme;
	public JTextArea textArea;
	public JScrollPane scrollPane;
	public JLabel lblVotando;
	public JLabel lblTitulo;
	public JLabel lblPortada1;
	public JPanel visualizargraficas2;
	public JPanel visualizargraficas3;
	public JPanel visualizargraficas4;
	public JPanel panelAndalucia;
	public JPanel panelAragon;
	public JPanel panelAsturias;
	public JPanel panelBaleares;
	public JPanel panelCanarias;
	public JPanel panelCantabria;
	public JPanel panelCastillaLaMancha;
	public JPanel panelCastillaLeon;
	public JPanel panelCataluña;
	public JPanel panelComunidadValenciana;
	public JPanel panelExtremadura;
	public JPanel panelGalicia;
	public JPanel panelMadrid;
	public JPanel panelMurcia;
	public JPanel panelNavarra;
	public JPanel panelPaisVasco;
	public JPanel panelLaRioja;
	public JPanel panelCeuta;
	public JPanel panelMelilla;
	public JPanel panelNacional;
	public JLabel lblLogoGanador;
	public JButton btnSalirInforme;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadisticaElectoral frame = new EstadisticaElectoral();
					Controlador controlador = new Controlador(frame);
					frame.setVisible(true);
					centreWindow(frame);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EstadisticaElectoral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 584);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblVotando = new JLabel("");
		lblVotando.setVisible(false);
		
		lblPortada1 = new JLabel("");
		lblPortada1.setIcon(new ImageIcon("C:\\Users\\Patricio\\Desktop\\portada.png"));
		lblPortada1.setBounds(90, 11, 528, 455);
		contentPane.add(lblPortada1);
		lblVotando.setIcon(new ImageIcon("C:\\Users\\Patricio\\Desktop\\hilosvotando~2.png"));
		lblVotando.setBounds(67, 11, 558, 450);
		contentPane.add(lblVotando);
		
		elegirporedad = new JComboBox();
		elegirporedad.setVisible(false);
		elegirporedad.setModel(new DefaultComboBoxModel(new String[] {"Rangos por Edad", "Rango 18 - 25", "Rango 26 - 40", "Rango 41 - 65", "Rango mas 65"}));
		elegirporedad.setBounds(673, 58, 126, 22);
		contentPane.add(elegirporedad);
		
		elegirporcomunidad = new JComboBox();
		elegirporcomunidad.setVisible(false);
		elegirporcomunidad.setModel(new DefaultComboBoxModel(new String[] {"Territorios", "Andaluc\u00EDa", "Arag\u00F3n", "Asturias", "Islas Baleares", "Canarias", "Cantabria", "Castilla La Mancha", "Castilla y Le\u00F3n", "Catalunia", "Comunidad Valenciana", "Extremadura", "Galicia", "La Rioja", "Murcia", "Navarra", "Pa\u00EDs Vasco", "Ceuta", "Melilla", "Total Nacional"}));
		elegirporcomunidad.setBounds(673, 106, 126, 22);
		contentPane.add(elegirporcomunidad);
		
		btnEncender = new JButton("Encender");
		btnEncender.setBounds(637, 11, 89, 23);
		contentPane.add(btnEncender);
		
		btnReset = new JButton("Reset");
		btnReset.setVisible(false);
		btnReset.setBounds(736, 11, 89, 23);
		contentPane.add(btnReset);
		
		btnInforme = new JButton("Informe Votantes");
		btnInforme.setVisible(false);
		btnInforme.setBounds(637, 496, 162, 23);
		contentPane.add(btnInforme);
		
		visualizargraficas1 = new JPanel();
		visualizargraficas1.setVisible(false);
		visualizargraficas1.setBackground(Color.WHITE);
		visualizargraficas1.setBounds(15, 11, 608, 455);
		contentPane.add(visualizargraficas1);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(15, 11, 601, 450);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblTitulo = new JLabel("Votos Generados");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTitulo.setVisible(false);
		lblTitulo.setBounds(252, 472, 126, 22);
		contentPane.add(lblTitulo);
		
		visualizargraficas2 = new JPanel();
		visualizargraficas2.setVisible(false);
		visualizargraficas2.setBounds(15, 11, 608, 409);
		contentPane.add(visualizargraficas2);
		
		visualizargraficas3 = new JPanel();
		visualizargraficas3.setVisible(false);
		visualizargraficas3.setBounds(15, 11, 608, 409);
		contentPane.add(visualizargraficas3);
		
		visualizargraficas4 = new JPanel();
		visualizargraficas4.setVisible(false);
		visualizargraficas4.setBounds(15, 11, 608, 409);
		contentPane.add(visualizargraficas4);
		
		panelAndalucia = new JPanel();
		panelAndalucia.setVisible(false);
		panelAndalucia.setBounds(15, 11, 608, 455);
		contentPane.add(panelAndalucia);
		
		panelAragon = new JPanel();
		panelAragon.setVisible(false);
		panelAragon.setBounds(15, 11, 610, 455);
		contentPane.add(panelAragon);
		
		panelAsturias = new JPanel();
		panelAsturias.setVisible(false);
		panelAsturias.setBounds(15, 11, 603, 450);
		contentPane.add(panelAsturias);
		
		panelBaleares = new JPanel();
		panelBaleares.setVisible(false);
		panelBaleares.setBounds(15, 11, 608, 455);
		contentPane.add(panelBaleares);
		
		panelCanarias = new JPanel();
		panelCanarias.setVisible(false);
		panelCanarias.setBounds(15, 11, 610, 455);
		contentPane.add(panelCanarias);
		
		panelCantabria = new JPanel();
		panelCantabria.setVisible(false);
		panelCantabria.setBounds(15, 11, 608, 455);
		contentPane.add(panelCantabria);
		
		panelCastillaLaMancha = new JPanel();
		panelCastillaLaMancha.setVisible(false);
		panelCastillaLaMancha.setBounds(15, 11, 610, 455);
		contentPane.add(panelCastillaLaMancha);
		
		panelCastillaLeon = new JPanel();
		panelCastillaLeon.setVisible(false);
		panelCastillaLeon.setBounds(15, 11, 608, 455);
		contentPane.add(panelCastillaLeon);
		
		panelCataluña = new JPanel();
		panelCataluña.setVisible(false);
		panelCataluña.setBounds(15, 11, 608, 455);
		contentPane.add(panelCataluña);
		
		panelComunidadValenciana = new JPanel();
		panelComunidadValenciana.setVisible(false);
		panelComunidadValenciana.setBounds(15, 11, 610, 455);
		contentPane.add(panelComunidadValenciana);
		
		panelExtremadura = new JPanel();
		panelExtremadura.setVisible(false);
		panelExtremadura.setBounds(15, 11, 610, 455);
		contentPane.add(panelExtremadura);
		
		panelGalicia = new JPanel();
		panelGalicia.setVisible(false);
		panelGalicia.setBounds(15, 11, 608, 455);
		contentPane.add(panelGalicia);
		
		panelMadrid = new JPanel();
		panelMadrid.setVisible(false);
		panelMadrid.setBounds(15, 11, 608, 455);
		contentPane.add(panelMadrid);
		
		panelMurcia = new JPanel();
		panelMurcia.setVisible(false);
		panelMurcia.setBounds(15, 11, 610, 455);
		contentPane.add(panelMurcia);
		
		panelNavarra = new JPanel();
		panelNavarra.setVisible(false);
		panelNavarra.setBounds(15, 11, 610, 455);
		contentPane.add(panelNavarra);
		
		panelPaisVasco = new JPanel();
		panelPaisVasco.setVisible(false);
		panelPaisVasco.setBounds(15, 11, 610, 455);
		contentPane.add(panelPaisVasco);
		
		panelLaRioja = new JPanel();
		panelLaRioja.setVisible(false);
		panelLaRioja.setBounds(15, 11, 608, 455);
		contentPane.add(panelLaRioja);
		
		panelCeuta = new JPanel();
		panelCeuta.setVisible(false);
		panelCeuta.setBounds(15, 11, 608, 455);
		contentPane.add(panelCeuta);
		
		panelMelilla = new JPanel();
		panelMelilla.setVisible(false);
		panelMelilla.setBounds(15, 11, 608, 455);
		contentPane.add(panelMelilla);
		
		lblLogoGanador = new JLabel("");
		lblLogoGanador.setBounds(673, 170, 126, 143);
		contentPane.add(lblLogoGanador);
		
		panelNacional = new JPanel();
		panelNacional.setVisible(false);
		panelNacional.setBounds(15, 11, 608, 455);
		contentPane.add(panelNacional);
		
		btnSalirInforme = new JButton("Cerrar Informe");
		btnSalirInforme.setVisible(false);
		btnSalirInforme.setBounds(468, 496, 133, 23);
		contentPane.add(btnSalirInforme);
		
		
		
	}
	
	public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y - 18);
    }
}
