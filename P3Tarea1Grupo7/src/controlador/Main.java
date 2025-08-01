package controlador;

import javax.swing.SwingUtilities;

import vista.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			  @Override
	            public void run() {
				  VentanaPrincipal vista = new VentanaPrincipal();
	                ControladorApp controlador = new ControladorApp(vista);
	                vista.setTitle("Analizador de Eficiencia Algorítmica");
	                vista.setSize(800, 650); // o el tamaño que definiste
	                vista.setLocationRelativeTo(null); // para centrar
	                vista.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	                vista.setVisible(true);
			  }
		 });
		
	}

}
