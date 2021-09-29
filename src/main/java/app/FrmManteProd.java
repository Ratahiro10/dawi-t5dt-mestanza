package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	private JTextField txtDescripcion;
	JComboBox cboCategorias;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(115, 25, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id. Producto :");
		lblNewLabel.setBounds(10, 25, 102, 14);
		contentPane.add(lblNewLabel);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(115, 53, 86, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("Descripcion :");
		lblNewLabel1.setBounds(10, 55, 102, 14);
		contentPane.add(lblNewLabel1);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(115, 108, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 112, 102, 14);
		contentPane.add(lblCategora);
		llenarCombo();
	}
	
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	EntityManager em = fabrica.createEntityManager();
	
	void listado() {	
		List<Producto> lstProductos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
		
		for(Producto p : lstProductos) {
			txtSalida.append(p.getIdprod()+ " "+ p.getDescripcion()+ "\n");
		}
		txtSalida.append("---------------------------------------");
	}
	
	void llenarCombo() {
		// Listado de los tipos de categoria
		List<Categoria> lstCategorias = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
		
		cboCategorias.addItem("Seleccione");
		for(Categoria c : lstCategorias) {
			cboCategorias.addItem(c.getDescripcion());
		}
		txtSalida.append("---------------------------------------");
	}
	
	void registrar() {
		String codigo = txtCódigo.getText(); // leerCodigo();
		String descripcion = txtDescripcion.getText();
		int stock = 100;
		double precio = 0.99;
		int categoria = cboCategorias.getSelectedIndex(); // leerCategoria();
		int estado = 1;
		
		// proceso ---> registrar, actualizar, eliminar.. usuario ,producto
		Producto p = new Producto();
		p.setIdprod(codigo);
		p.setDescripcion(descripcion);
		p.setIdcategoria(categoria);
		p.setEstado(estado);
		p.setStock(stock);
		p.setPrecio(precio);
		
		
		em.getTransaction().begin();
		
		em.persist(p);  // <---- automaticamente registra
		
		em.getTransaction().commit();
		
		listado();
		
		em.close();
	}
}
