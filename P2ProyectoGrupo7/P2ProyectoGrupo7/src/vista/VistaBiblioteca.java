package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VistaBiblioteca extends JFrame {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtAnio;
	private JTable table;
	public VistaBiblioteca() {
		getContentPane().setBackground(new Color(207, 243, 245));
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("GESTOR DE BIBLIOTECA");
		lblTitle.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(199, 11, 480, 100);
		getContentPane().add(lblTitle);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon(VistaBiblioteca.class.getResource("/imagenes/biblioteca2.png")));
		lblImagen.setBounds(731, 0, 153, 111);
		getContentPane().add(lblImagen);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(101, 115, 66, 20);
		getContentPane().add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(177, 112, 225, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(472, 115, 46, 17);
		getContentPane().add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(560, 112, 205, 20);
		getContentPane().add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblAño = new JLabel("Año:");
		lblAño.setBounds(101, 171, 46, 14);
		getContentPane().add(lblAño);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(177, 168, 225, 20);
		getContentPane().add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(472, 171, 66, 18);
		getContentPane().add(lblCategoria);
		
		JComboBox cboCategoria = new JComboBox();
		cboCategoria.setBounds(562, 167, 203, 22);
		getContentPane().add(cboCategoria);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(676, 200, 89, 23);
		getContentPane().add(btnAgregar);
		
		table = new JTable();
		table.setBounds(101, 234, 664, 142);
		getContentPane().add(table);
		
		JButton btnInorden = new JButton("Inorden");
		btnInorden.setBounds(101, 397, 89, 23);
		getContentPane().add(btnInorden);
		
		JButton btnPreorden = new JButton("Preorden");
		btnPreorden.setBounds(212, 397, 89, 23);
		getContentPane().add(btnPreorden);
		
		JButton btnPostorden = new JButton("Postorden");
		btnPostorden.setBounds(313, 397, 89, 23);
		getContentPane().add(btnPostorden);
		
		JButton btnOrdenar = new JButton("Ordenar por Autor");
		btnOrdenar.setBounds(427, 397, 128, 23);
		getContentPane().add(btnOrdenar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(576, 397, 89, 23);
		getContentPane().add(btnConsultar);
		
		JButton btnGenerar = new JButton("PDF");
		btnGenerar.setBounds(676, 397, 89, 23);
		getContentPane().add(btnGenerar);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(101, 426, 664, 111);
		getContentPane().add(textArea);
	}
}
