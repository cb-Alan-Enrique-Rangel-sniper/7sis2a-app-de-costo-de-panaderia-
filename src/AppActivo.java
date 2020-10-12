import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import com.mysql.jdbc.Statement;

public class AppActivo extends JFrame {

	private JPanel contentPane;
	private JTextField tFA1;
	private JTextField tFA2;
	private JTextField tFA3;
	private JTextField tFA4;
	private JTextField tFAnom5;
	private JTextField tFAu7;
	private JTextField totalA;
	private JTextField tFAu6;
	private JTextField tFA5;
	private JTextField tFfea;

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/panaderia";
	private static final String USUARIO = "root";
	private static final String CLAVE="LikeStone234";
	
	
	PreparedStatement ps;
	ResultSet rs;
	private JTextField textFieldMask;
	
	
	
	public static Connection conectar () {
		Connection conexion = null;
		
		try {
			try{
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
			
		conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
		System.out.println("Conexion Ok");
		
	}catch (SQLException e) {
		System.out.println("Error al generar conexion");
		e.printStackTrace();
	}
	return conexion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppActivo frame = new AppActivo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//----Metodos----//
	
	private void BACK()
	{
		this.setVisible(false);
		AppInterf IS = new AppInterf();
		IS.setVisible(true);
	}
	
	private void Limpiar()
	{
		tFfea.setText(null);
		tFA1.setText(null);
		tFA2.setText(null);
		tFA3.setText(null);
		tFA4.setText(null);
		tFAnom5.setText(null);
		tFA5.setText(null);
		tFAu6.setText(null);
		tFAu7.setText(null);
		totalA.setText(null);
	}
	
//----Metodos----//	
	/**
	 * Create the frame.
	 */
	public AppActivo() {
		setTitle("App Costos - Activo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//----Etiqueta----//
		
		JLabel lblIngresaLaCantidad = new JLabel("Ingresa la cantidad");
		lblIngresaLaCantidad.setBounds(23, 56, 122, 14);
		contentPane.add(lblIngresaLaCantidad);
		
		JLabel lblNewLabel_1 = new JLabel("del socio");
		lblNewLabel_1.setBounds(23, 72, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCuentasConSocio = new JLabel("cuentas con socio");
		lblCuentasConSocio.setBounds(287, 72, 110, 14);
		contentPane.add(lblCuentasConSocio);
		
		JLabel lblNewLabel_2 = new JLabel("Ingreso el prestamo");
		lblNewLabel_2.setBounds(21, 114, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("del banco");
		lblNewLabel_3.setBounds(21, 128, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ingreso el total de");
		lblNewLabel_4.setBounds(23, 171, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("dinero de la caja");
		lblNewLabel_5.setBounds(23, 185, 122, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ingresa el total del costo");
		lblNewLabel_4_1.setBounds(23, 224, 146, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("de los clientes deudores");
		lblNewLabel_5_1.setBounds(23, 238, 146, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Ingresa el nombre");
		lblNewLabel_4_1_1.setBounds(23, 276, 135, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("del moviliario");
		lblNewLabel_5_1_1.setBounds(23, 290, 122, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Selecciona materia");
		lblNewLabel_4_1_1_1.setBounds(23, 395, 135, 14);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("prima vendida");
		lblNewLabel_5_1_1_1.setBounds(23, 409, 122, 14);
		contentPane.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad");
		lblNewLabel_6.setBounds(175, 421, 66, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Unidad");
		lblNewLabel_7.setBounds(269, 421, 66, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(478, 470, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Selecciona el tipo");
		lblNewLabel_4_1_1_1_1.setBounds(23, 315, 135, 14);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("de pan vendido");
		lblNewLabel_5_1_1_1_1.setBounds(23, 329, 122, 14);
		contentPane.add(lblNewLabel_5_1_1_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Cantidad");
		lblNewLabel_6_1.setBounds(169, 329, 66, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(289, 263, 46, 14);
		contentPane.add(lblCosto);
		
		JLabel lblPedistePrestamo = new JLabel("pediste prestamo");
		lblPedistePrestamo.setBounds(287, 122, 110, 14);
		contentPane.add(lblPedistePrestamo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(23, 17, 46, 14);
		contentPane.add(lblFecha);
		
		//----Etiqueta----//
		
		//----CheckBox----//
		
		JCheckBox chckbxPulsaElBoton = new JCheckBox("Pulsa el boton si");
		chckbxPulsaElBoton.setBounds(266, 56, 122, 14);
		contentPane.add(chckbxPulsaElBoton);
		
		JCheckBox chckbxPulsaElBoton_1 = new JCheckBox("Pulsa el boton si");
		chckbxPulsaElBoton_1.setBounds(266, 106, 122, 14);
		contentPane.add(chckbxPulsaElBoton_1);
		
		//----CheckBox----//
		
		//----ComboBox----//
		
		JComboBox comboAU = new JComboBox();
		comboAU.setModel(new DefaultComboBoxModel(new String[] {"__________", "Saco", "Galon", "Caja", "Kilogramo"}));
		comboAU.setBounds(267, 436, 97, 23);
		contentPane.add(comboAU);
		
		JComboBox comboAM = new JComboBox();
		comboAM.setModel(new DefaultComboBoxModel(new String[] {"_____________", "Azucar", "Harina", "Vainilla", "Levadura", "Manteca vegetal", "Sal", "Leche"}));
		comboAM.setBounds(23, 434, 135, 23);
		contentPane.add(comboAM);
		
		JComboBox comboAT = new JComboBox();
		comboAT.setModel(new DefaultComboBoxModel(new String[] {"_______________", "Pan de Dulce", "Pan de muerto", "Pan Blanco"}));
		comboAT.setBounds(23, 349, 135, 23);
		contentPane.add(comboAT);
		
		//----ComboBox----//
		
		//----TextField----//
		
		tFA1 = new JTextField();
		tFA1.setColumns(10);
		tFA1.setBounds(168, 60, 86, 20);
		contentPane.add(tFA1);
		
		tFA2 = new JTextField();
		tFA2.setColumns(10);
		tFA2.setBounds(168, 116, 86, 20);
		contentPane.add(tFA2);
		
		tFA3 = new JTextField();
		tFA3.setColumns(10);
		tFA3.setBounds(168, 173, 86, 20);
		contentPane.add(tFA3);
		
		tFA4 = new JTextField();
		tFA4.setColumns(10);
		tFA4.setBounds(168, 226, 86, 20);
		contentPane.add(tFA4);
		
		tFAnom5 = new JTextField();
		tFAnom5.setColumns(10);
		tFAnom5.setBounds(168, 278, 86, 20);
		contentPane.add(tFAnom5);
		
		tFAu7 = new JTextField();
		tFAu7.setColumns(10);
		tFAu7.setBounds(168, 436, 89, 23);
		contentPane.add(tFAu7);
		
		totalA = new JTextField();
		totalA.setColumns(10);
		totalA.setBounds(422, 495, 152, 20);
		contentPane.add(totalA);
		
		tFAu6 = new JTextField();
		tFAu6.setColumns(10);
		tFAu6.setBounds(162, 350, 89, 23);
		contentPane.add(tFAu6);
		
		tFA5 = new JTextField();
		tFA5.setBounds(287, 278, 86, 20);
		contentPane.add(tFA5);
		tFA5.setColumns(10);

		tFfea = new JTextField();
		tFfea.setColumns(10);
		tFfea.setBounds(79, 14, 97, 20);
		contentPane.add(tFfea);
		
		
		//----TextField----//
		
		//----Botones----//
		
		JButton Regresar = new JButton("Regresar");
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BACK();
				
			}
		});
		Regresar.setBounds(485, 52, 89, 23);
		contentPane.add(Regresar);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBounds(485, 115, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Son los materiales que usas para el desarrollo de producto\n Como El azucar o la Harina");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(139, 393, 46, 23);
		contentPane.add(btnNewButton);
				
		JButton btgua = new JButton("Guardar");
		btgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
try {
					
					conexion = conectar();
					ps = conexion.prepareStatement("INSERT INTO activo(fech_act, cant_soc, cant_bac, tota_caj, cost_deudo, nom_mov, cost_mov, tip_pan, can, mat_act, cant, uni_act, total_act ) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, tFfea.getText());
					ps.setString(2, tFA1.getText());
					ps.setString(3, tFA2.getText());
					ps.setString(4, tFA3.getText());
					ps.setString(5, tFA4.getText());
					ps.setString(6, tFAnom5.getText());
					ps.setString(7, tFA5.getText());
					ps.setString(8, comboAT.getSelectedItem().toString());
					ps.setString(9, tFAu6.getText());
					ps.setString(10, comboAM.getSelectedItem().toString());
					ps.setString(11, tFAu7.getText());
					ps.setString(12, comboAU.getSelectedItem().toString());
					ps.setString(13, totalA.getText());
					
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Se han guardado los datos");
						Limpiar();
					}else {
						JOptionPane.showMessageDialog(null,"Error al guardar los datos");
					}
					conexion.close();
					}catch (Exception r) {
						System.err.println(r);
				}
			}
		});
		btgua.setBounds(380, 379, 89, 23);
		contentPane.add(btgua);
		
		JButton btlim = new JButton("Limpiar");
		btlim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Limpiar();
				
			}
		});
		btlim.setBounds(485, 379, 89, 23);
		contentPane.add(btlim);

		JButton btcal = new JButton("Calcular");
		btcal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Item1, Item2;
				
				Item1 = comboAT.getSelectedItem().toString();
				Item2 = comboAM.getSelectedItem().toString();
				
				int a, b, c, d, e, f, g, numT,numP, total;
			
		if(Item1.equalsIgnoreCase("Pan de Dulce"))
		{
			
			numT = 2;
			
				if(Item2.equalsIgnoreCase("Azucar")) 
				{
					
				numP = 5;
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Harina")) 
				{
					
				numP = 10;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu7.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Vainilla")) 
				{
					
				numP = 15;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Levadura")) 
				{
					
				numP = 20;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Manteca Vegetal")) 
				{
					
				numP = 25;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Sal")) 
				{
					
				numP = 30;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Leche")) 
				{
					
				numP = 35;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
			}
		else if(Item1.equalsIgnoreCase("Pan de Muerto"))
		{
			
			numT = 4;
			
				if(Item2.equalsIgnoreCase("Azucar")) 
				{
					
				numP = 5;
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Harina")) 
				{
					
				numP = 10;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu7.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Vainilla")) 
				{
					
				numP = 15;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Levadura")) 
				{
					
				numP = 20;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Manteca Vegetal")) 
				{
					
				numP = 25;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Sal")) 
				{
					
				numP = 30;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Leche")) 
				{
					
				numP = 35;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
			}
		else if(Item1.equalsIgnoreCase("Pan Blanco"))
		{
			
			numT = 6;
			
				if(Item2.equalsIgnoreCase("Azucar")) 
				{
					
				numP = 5;
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Harina")) 
				{
					
				numP = 10;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu7.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Vainilla")) 
				{
					
				numP = 15;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Levadura")) 
				{
					
				numP = 20;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Manteca Vegetal")) 
				{
					
				numP = 25;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Sal")) 
				{
					
				numP = 30;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
				
				else if(Item2.equalsIgnoreCase("Leche")) 
				{
					
				numP = 35;	
				
				a = Integer.parseInt(tFA1.getText());
				b = Integer.parseInt(tFA2.getText());
				c = Integer.parseInt(tFA3.getText());
				d = Integer.parseInt(tFA4.getText());
				e = Integer.parseInt(tFA5.getText());
				f = Integer.parseInt(tFAu6.getText());
				g = Integer.parseInt(tFAu7.getText());
				
				total = a + b + c + d + e + (numT * f) + (numP * g);
				
				totalA.setText(String.valueOf(total));
				}
			}
		 }
		});
		btcal.setBounds(323, 494, 89, 23);
		contentPane.add(btcal);
		
		textFieldMask = new JTextField();
		textFieldMask.setVisible(false);
		textFieldMask.setBounds(438, 168, 86, 20);
		contentPane.add(textFieldMask);
		textFieldMask.setColumns(10);
		
		//----Botones----//
		
	}
}
