import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppInterf extends JFrame 
{
	BDSQLPanaderia CONECTT = new BDSQLPanaderia(); 

	private JPanel contentPane;
	private JPasswordField PASSWORD;


	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AppInterf frame = new AppInterf();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String Tipo, LOGIN, Tipo1="Pasivo", Tipo2="Activo";
	
	private void LOGIN()
	{
		
			if(Tipo.equals(Tipo1))
			{
				this.setVisible(false);
				AppPasivo r = new AppPasivo();
				r.setVisible(true);
				}
			else if (Tipo.contentEquals(Tipo2))
			{
				this.setVisible(false);
				AppActivo s = new AppActivo();
				s.setVisible(true);
				}
			}	
	
	public AppInterf() {
		setTitle("App Costos - Interfaz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaActivoO = new JLabel("Selecciona Activo o Pasivo");
		lblSeleccionaActivoO.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeleccionaActivoO.setBounds(111, 49, 201, 34);
		contentPane.add(lblSeleccionaActivoO);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"___________________", "Pasivo", "Activo"}));
		comboBox.setBounds(106, 94, 206, 34);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Tipo = comboBox.getSelectedItem().toString();	
				
				System.out.println(Tipo);
				
				if(Tipo.equals("Pasivo"))
				{
					
					LOGIN();

				}
				else if(Tipo.equals("Activo"))
				{
					
					LOGIN();

				}
			}
		});
		btnAceptar.setBounds(164, 139, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setBounds(164, 181, 89, 23);
		contentPane.add(btnSalir);
	}
}
