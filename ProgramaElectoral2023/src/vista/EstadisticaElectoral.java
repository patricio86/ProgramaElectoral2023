package vista;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import modelo.Modelo;
import controlador.Controlador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;

public class EstadisticaElectoral extends JFrame {

	public JPanel contentPane;
	public JComboBox elegirporedad;
	public JComboBox elegirporcomunidad;
	public JButton btnEncender;
	public JButton btnReset;
	public JPanel visualizargraficas;
	public JButton btnInforme;
	public JTextArea textArea;
	public JScrollPane scrollPane;
	public JLabel lblVotando;
	public JLabel lblTitulo;
	public JLabel lblPortada1;
	public JLabel lblLogo;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 676);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblVotando = new JLabel("");
		lblVotando.setVisible(false);
		
		lblPortada1 = new JLabel("");
		lblPortada1.setIcon(new ImageIcon("C:\\Users\\Patricio\\git\\ProgramaElectoral2023\\ProgramaElectoral2023\\imagenes\\logopor.png"));
		lblPortada1.setBounds(48, 152, 540, 420);
		contentPane.add(lblPortada1);
		lblVotando.setIcon(new ImageIcon("C:\\Users\\Patricio\\git\\ProgramaElectoral2023\\ProgramaElectoral2023\\imagenes\\hilosvotando.png"));
		lblVotando.setBounds(68, 48, 480, 450);
		contentPane.add(lblVotando);
		
		elegirporedad = new JComboBox();
		elegirporedad.setVisible(false);
		elegirporedad.setModel(new DefaultComboBoxModel(new String[] {"Rango de edad", "Rango 18 - 25", "Rango 26 - 40", "Rango 41 - 65", "Rango mas 65"}));
		elegirporedad.setBounds(732, 152, 126, 22);
		contentPane.add(elegirporedad);
		
		elegirporcomunidad = new JComboBox();
		elegirporcomunidad.setVisible(false);
		elegirporcomunidad.setModel(new DefaultComboBoxModel(new String[] {"Territorios", "Andaluc\u00EDa", "Arag\u00F3n", "Asturias", "Islas Baleares", "Canarias", "Cantabria", "Castilla La Mancha", "Castilla y Le\u00F3n", "Catalunia", "Comunidad Valenciana", "Extremadura", "Galicia", "La Rioja", "Murcia", "Navarra", "Pa\u00EDs Vasco", "Ceuta", "Melilla", "Total Nacional"}));
		elegirporcomunidad.setBounds(732, 196, 126, 22);
		contentPane.add(elegirporcomunidad);
		
		btnEncender = new JButton("Encender");
		btnEncender.setBorderPainted(false);
		btnEncender.setIcon(new ImageIcon("C:\\Users\\Patricio\\git\\ProgramaElectoral2023\\ProgramaElectoral2023\\imagenes\\power1.png"));
		btnEncender.setBounds(691, 16, 115, 111);
		contentPane.add(btnEncender);
		
		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Patricio\\git\\ProgramaElectoral2023\\ProgramaElectoral2023\\imagenes\\reset1.png"));
		btnReset.setBorderPainted(false);
		btnReset.setVisible(false);
		btnReset.setBounds(816, 19, 105, 104);
		contentPane.add(btnReset);
		
		btnInforme = new JButton("Informe Votantes");
		btnInforme.setBorderPainted(false);
		btnInforme.setIcon(new ImageIcon("C:\\Users\\Patricio\\git\\ProgramaElectoral2023\\ProgramaElectoral2023\\imagenes\\informe1.png"));
		btnInforme.setVisible(false);
		btnInforme.setBounds(771, 430, 126, 142);
		contentPane.add(btnInforme);
		
		visualizargraficas = new JPanel();
		visualizargraficas.setVisible(false);
		visualizargraficas.setBackground(Color.WHITE);
		visualizargraficas.setBounds(15, 11, 657, 431);
		contentPane.add(visualizargraficas);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(15, 11, 533, 450);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblTitulo = new JLabel("Votos Generados");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTitulo.setVisible(false);
		lblTitulo.setBounds(248, 520, 126, 22);
		contentPane.add(lblTitulo);
		
		btnSalirInforme = new JButton("Cerrar Informe");
		btnSalirInforme.setForeground(Color.WHITE);
		btnSalirInforme.setBackground(Color.GRAY);
		btnSalirInforme.setBorderPainted(false);
		btnSalirInforme.setVisible(false);
		btnSalirInforme.setBounds(759, 583, 133, 23);
		contentPane.add(btnSalirInforme);
		
		lblLogo = new JLabel("");
		lblLogo.setVisible(false);
		lblLogo.setBounds(682, 229, 239, 213);
		contentPane.add(lblLogo);
		
		
		
	}
	
	public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y - 18);
    }
}
