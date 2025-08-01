package vista;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
	public JTextField txtTamanio;
	public JButton btnCalcular;
	public JTextArea textArea;
	public JPanel pnlGrafica;
	public VentanaPrincipal() {
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("ANALIZADOR DE EFICIENCIA");
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 784, 42);
		getContentPane().add(lblTitulo);
		
		JLabel lblIngreso = new JLabel("Ingrese el tamaño de entrada (n):");
		lblIngreso.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblIngreso.setBounds(37, 106, 255, 20);
		getContentPane().add(lblIngreso);
		
		txtTamanio = new JTextField();
		txtTamanio.setBounds(302, 108, 105, 20);
		getContentPane().add(txtTamanio);
		txtTamanio.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(436, 107, 89, 23);
		getContentPane().add(btnCalcular);
		
		textArea = new JTextArea();
		textArea.setBounds(557, 41, 217, 164);
		getContentPane().add(textArea);
		
		pnlGrafica = new JPanel();
		pnlGrafica.setBounds(26, 229, 737, 371);
		getContentPane().add(pnlGrafica);
	}
}
