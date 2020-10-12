import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class BDSQLPanaderia 
{
	Connection CONECTT;
	
	public  Connection CONECTAR()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			CONECTT = DriverManager.getConnection("jdbc:mysql://localhost:3306/panaderia?useTimezone=true&serverTimezone=UTC","root","LikeStone234");
			
			System.out.println("Conexión exitosa a la base de datos.");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos.");
			System.out.print(e);
		}
		
		return CONECTT;
	}

}