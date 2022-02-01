package vista;

import java.awt.BorderLayout;


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

public class EstadisticaElectoral extends JFrame {

	public JPanel contentPane;
	public JTextField info;
	public JTextField ganador;
	public JComboBox elegirporedad;
	public JComboBox elegirporcomunidad;
	public JButton btnEncender;
	public JButton btnReset;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadisticaElectoral frame = new EstadisticaElectoral();
					frame.setVisible(true);
					Controlador controlador = new Controlador(frame);
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
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		elegirporedad = new JComboBox();
		elegirporedad.setBounds(528, 59, 126, 22);
		contentPane.add(elegirporedad);
		
		elegirporcomunidad = new JComboBox();
		elegirporcomunidad.setBounds(528, 109, 126, 22);
		contentPane.add(elegirporcomunidad);
		
		info = new JTextField();
		info.setEditable(false);
		info.setBounds(33, 373, 449, 28);
		contentPane.add(info);
		info.setColumns(10);
		
		ganador = new JTextField();
		ganador.setEditable(false);
		ganador.setBounds(511, 355, 143, 46);
		contentPane.add(ganador);
		ganador.setColumns(10);
		
		btnEncender = new JButton("Encender");
		btnEncender.setBounds(489, 11, 89, 23);
		contentPane.add(btnEncender);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(588, 11, 89, 23);
		contentPane.add(btnReset);
	}
}
