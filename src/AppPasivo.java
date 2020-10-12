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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import com.mysql.jdbc.Statement;

public class AppPasivo extends JFrame {

	private JPanel contentPane;
	private JTextField totalP;
	private JTextField tFP1;
	private JTextField tFP2;
	private JTextField tFP3;
	private JTextField tFPnom4;
	private JTextField tFPnom5;
	private JTextField tFPcan6;
	private JTextField tFfep;
	private JTextField tFP4;
	private JTextField tFP5;
	
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
					AppPasivo frame = new AppPasivo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void BACK()
	{
		this.setVisible(false);
		AppInterf IS = new AppInterf();
		IS.setVisible(true);
	}
	
	private void Limpiar()
	{
		tFfep.setText(null);
		tFP1.setText(null);
		tFP2.setText(null);
		tFP3.setText(null);
		tFPnom4.setText(null);
		tFP4.setText(null);
		tFPnom5.setText(null);
		tFP5.setText(null);
		tFPcan6.setText(null);
		totalP.setText(null);
	}
	
	/**
	 * Create the frame.
	 */
	public AppPasivo() {
		setTitle("App de Costos - Pasivo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//----Etiquetas----//
		
		JLabel lblSiPagasRenta = new JLabel("si pagas renta");
		lblSiPagasRenta.setBounds(285, 72, 89, 14);
		contentPane.add(lblSiPagasRenta);
		
		JLabel lblNewLabel = new JLabel("Ingresa el costo de");
		lblNewLabel.setBounds(23, 56, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("la renta del lugar");
		lblNewLabel_1.setBounds(23, 72, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingreso el costo de");
		lblNewLabel_2.setBounds(21, 114, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("la luz");
		lblNewLabel_3.setBounds(21, 128, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ingreso el costo de");
		lblNewLabel_4.setBounds(23, 171, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("gas");
		lblNewLabel_5.setBounds(23, 185, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ingresa el nombre del");
		lblNewLabel_4_1.setBounds(23, 224, 135, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("moviliario");
		lblNewLabel_5_1.setBounds(23, 238, 66, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Ingresa el nombre de");
		lblNewLabel_4_1_1.setBounds(23, 276, 135, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("las herramientas");
		lblNewLabel_5_1_1.setBounds(23, 290, 122, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Selecciona la");
		lblNewLabel_4_1_1_1.setBounds(23, 336, 135, 14);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("materia prima");
		lblNewLabel_5_1_1_1.setBounds(23, 350, 122, 14);
		contentPane.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad");
		lblNewLabel_6.setBounds(169, 350, 66, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Unidad");
		lblNewLabel_7.setBounds(263, 350, 66, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(467, 432, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblCostoTotal = new JLabel("Costo total");
		lblCostoTotal.setBounds(272, 205, 86, 14);
		contentPane.add(lblCostoTotal);
		
		JLabel lblCostoTotal_1 = new JLabel("Costo total");
		lblCostoTotal_1.setBounds(272, 259, 86, 14);
		contentPane.add(lblCostoTotal_1);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(21, 15, 46, 14);
		contentPane.add(lblFecha);
		
		//----Etiquetas----//
		
		//----ComboBox----//
		
		JComboBox comboMP = new JComboBox();
		comboMP.setModel(new DefaultComboBoxModel(new String[] {"_____________", "Azucar", "Harina", "Vainilla", "Levadura", "Manteca vegetal", "Sal", "Leche"}));
		comboMP.setBounds(23, 376, 135, 23);
		contentPane.add(comboMP);
		
		JComboBox comboMU = new JComboBox();
		comboMU.setModel(new DefaultComboBoxModel(new String[] {"__________", "Saco", "Galon", "Caja", "Kilogramo"}));
		comboMU.setBounds(261, 377, 97, 23);
		contentPane.add(comboMU);
		
		//----ComboBox----//
		
		
		//----TextFields----//
		
		totalP = new JTextField();
		totalP.setBounds(411, 457, 152, 20);
		contentPane.add(totalP);
		totalP.setColumns(10);
		
		tFP1 = new JTextField();
		tFP1.setBounds(162, 56, 86, 20);
		contentPane.add(tFP1);
		tFP1.setColumns(10);
		
		tFP2 = new JTextField();
		tFP2.setColumns(10);
		tFP2.setBounds(162, 112, 86, 20);
		contentPane.add(tFP2);
		
		tFP3 = new JTextField();
		tFP3.setColumns(10);
		tFP3.setBounds(162, 169, 86, 20);
		contentPane.add(tFP3);
		
		tFPnom4 = new JTextField();
		tFPnom4.setColumns(10);
		tFPnom4.setBounds(162, 222, 86, 20);
		contentPane.add(tFPnom4);
		
		tFPnom5 = new JTextField();
		tFPnom5.setColumns(10);
		tFPnom5.setBounds(162, 274, 86, 20);
		contentPane.add(tFPnom5);
		
		tFPcan6 = new JTextField();
		tFPcan6.setBounds(162, 377, 89, 23);
		contentPane.add(tFPcan6);
		tFPcan6.setColumns(10);
		
		tFfep = new JTextField();
		tFfep.setBounds(77, 12, 97, 20);
		contentPane.add(tFfep);
		tFfep.setColumns(10);
		
		tFP4 = new JTextField();
		tFP4.setBounds(272, 221, 86, 20);
		contentPane.add(tFP4);
		tFP4.setColumns(10);
		
		tFP5 = new JTextField();
		tFP5.setBounds(272, 273, 86, 20);
		contentPane.add(tFP5);
		tFP5.setColumns(10);
		
		//----TextFields----//
		
		//----CheckBox----//
		
				JCheckBox check = new JCheckBox("Pulsa el boton");
				check.setBounds(260, 52, 114, 23);
				contentPane.add(check);
				
				if(check.isSelected()) {
					tFP1.isEnabled();
				}
				
				//----CheckBox----//
		
		//----Botones----//
		
		JButton btnNewButton = new JButton("?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Son los materiales que usas para el desarrollo de producto\n Como El azucar o la Harina");
			}
		});
		btnNewButton.setBounds(116, 336, 42, 23);
		contentPane.add(btnNewButton);
		
		JButton Regresa = new JButton("Regresar");
		Regresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BACK();
			}
		});
		Regresa.setBounds(485, 52, 89, 23);
		contentPane.add(Regresa);
		
		JButton btgua = new JButton("Guardar");
		btgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					
					conexion = conectar();
					ps = conexion.prepareStatement("INSERT INTO pasivo(fech_pas, ren_pas, luz_pas, cos_gas, mov_pas, cos_mov, nom_her, cos_her, mat_pas, cant_pas, uni_pas, tota_pas ) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, tFfep.getText());
					ps.setString(2, tFP1.getText());
					ps.setString(3, tFP2.getText());
					ps.setString(4, tFP3.getText());
					ps.setString(5, tFPnom4.getText());
					ps.setString(6, tFP4.getText());
					ps.setString(7, tFPnom5.getText());
					ps.setString(8, tFP5.getText());
					ps.setString(9, comboMP.getSelectedItem().toString());
					ps.setString(10, tFPcan6.getText());
					ps.setString(11, comboMU.getSelectedItem().toString());
					ps.setString(12, totalP.getText());
					
					
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
		btgua.setBounds(380, 333, 89, 23);
		contentPane.add(btgua);
		
		JButton btlim = new JButton("Limpiar");
		btlim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Limpiar();
				
			}
		});
		btlim.setBounds(485, 333, 89, 23);
		contentPane.add(btlim);
		
		JButton btcal = new JButton("Calcular");
		btcal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Item;
				
				Item = comboMP.getSelectedItem().toString();
				
				int a, b, c, d, ee, f, numP, total;
				
				if(Item.equalsIgnoreCase("Azucar")) 
				{
					
				numP = 5;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
				
				else if(Item.equalsIgnoreCase("Harina")) 
				{
					
				numP = 10;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
				
				else if(Item.equalsIgnoreCase("Vainilla")) 
				{
					
				numP = 15;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
				
				else if(Item.equalsIgnoreCase("Levadura")) 
				{
					
				numP = 20;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
				
				else if(Item.equalsIgnoreCase("Manteca Vegetal")) 
				{
					
				numP = 25;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
				
				else if(Item.equalsIgnoreCase("Sal")) 
				{
					
				numP = 30;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
				
				else if(Item.equalsIgnoreCase("Leche")) 
				{
					
				numP = 35;	
				
				a = Integer.parseInt(tFP1.getText());
				b = Integer.parseInt(tFP2.getText());
				c = Integer.parseInt(tFP3.getText());
				d = Integer.parseInt(tFP4.getText());
				ee = Integer.parseInt(tFP5.getText());
				f = Integer.parseInt(tFPcan6.getText());
				
				total = a + b + c + d + ee + (numP * f);
				
				totalP.setText(String.valueOf(total));
				}
			}
		});
		btcal.setBounds(312, 456, 89, 23);
		contentPane.add(btcal);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBounds(240, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textFieldMask = new JTextField();
		textFieldMask.setBounds(370, 12, 86, 20);
		contentPane.add(textFieldMask);
		textFieldMask.setColumns(10);
		
		//----Botones----//
		
		
	}
}
