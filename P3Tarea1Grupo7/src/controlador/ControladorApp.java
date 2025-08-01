package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JOptionPane;

import modelo.Complejidad;
import modelo.ListaEnlazada;
import modelo.Nodo;
import vista.VentanaPrincipal;

public class ControladorApp {
	private VentanaPrincipal vista;
	private ListaEnlazada listaComplejidades;
	
	public ControladorApp(VentanaPrincipal vista) {
		this.vista = vista;
		this.listaComplejidades = new ListaEnlazada();
		
		//Asociar evento al boton calcular
		this.vista.btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calcularComplejidades();
				// solo mostrar gráfico si NO hay valores infinitos
				if (!tieneValoresInfinitos(listaComplejidades)) {
				    mostrarGrafico(listaComplejidades);
				} else {
				    JOptionPane.showMessageDialog(vista, "Valor muy grande, no se puede graficar O(2^n)", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
	private void calcularComplejidades() {
		String txttamanio = vista.txtTamanio.getText().trim();
		if(txttamanio.isEmpty()) {
			JOptionPane.showMessageDialog(vista, "Ingrese un valor para n", "Error", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int n;
		try {
			n = Integer.parseInt(txttamanio);
			if(n<1) {
				JOptionPane.showMessageDialog(vista, "Ingrese un numero entero", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(vista, "Ingrese un numero valido",
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//limpiar lista antes de calcular
		listaComplejidades = new ListaEnlazada();
		//calcular las complejidades
		Complejidad c1 = new Complejidad("O(1)", 1);
		double logn = (n > 0) ? Math.log(n)/Math.log(2) :0;
		Complejidad cLogN = new Complejidad("O(log n)", logn);
		Complejidad cN = new Complejidad ("O(n)", n);
		Complejidad cN2 = new Complejidad("O(n²)", Math.pow(n, 2));
		double c2N;
		if(n <= 30) {
			c2N = Math.pow(2, n);
		}else {
			c2N = Double.POSITIVE_INFINITY;
		}
		Complejidad c2PowN = new Complejidad("O(2^n)", c2N);
		listaComplejidades.agregar(c1);
		listaComplejidades.agregar(cLogN);
		listaComplejidades.agregar(cN);
		listaComplejidades.agregar(cN2);
		listaComplejidades.agregar(c2PowN);
		//llamada del metodo para mostrar los resultados en la interfaz
		mostrarResultados();
	}
	
	private void mostrarResultados() {
		StringBuilder sb = new StringBuilder();
		Nodo nodo = listaComplejidades.getCabeza();
		while (nodo != null) {
			Complejidad c = (Complejidad) nodo.getDato();
			if(Double.isInfinite(c.getValor())) {
				sb.append(c.getNombre()).append(" = ").append("Valor muy grande\n");
			}else {
				sb.append(String.format("%s = %.4f\n", c.getNombre(), c.getValor()));
			}
			nodo = nodo.getSiguiente();
		}
		vista.textArea.setText(sb.toString());
	}
	
	public void mostrarGrafico(ListaEnlazada lista) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Nodo actual = lista.getCabeza();
		while(actual != null) {
			Object dato = actual.getDato();
			if(dato instanceof Complejidad) {
				Complejidad comp = (Complejidad) dato;
				dataset.addValue(comp.getValor(), "Eficiencia", comp.getNombre());
			}
			actual = actual.getSiguiente();
		}
		JFreeChart chart = ChartFactory.createBarChart(
			"Comparacion de Complejidades",
			"Tipo de Complejidad",
			"Valor",
			dataset,
			PlotOrientation.VERTICAL,
			true, true, false
		);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(vista.pnlGrafica.getSize());
		
		vista.pnlGrafica.removeAll();
		vista.pnlGrafica.setLayout(new java.awt.BorderLayout());;
		vista.pnlGrafica.add(chartPanel, java.awt.BorderLayout.CENTER);
		vista.pnlGrafica.validate();
		vista.pnlGrafica.repaint();
				
	}
	
	private boolean tieneValoresInfinitos(ListaEnlazada lista) {
		Nodo actual = lista.getCabeza();
		while (actual != null) {
			Complejidad c = (Complejidad) actual.getDato();
			if (Double.isInfinite(c.getValor())) {
				return true;
			}
			actual = actual.getSiguiente();
		}
		return false;
	}

}
