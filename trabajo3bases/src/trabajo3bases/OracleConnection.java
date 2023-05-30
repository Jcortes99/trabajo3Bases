package trabajo3bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnection {
	
	public void oracleConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "jairo";
		String password = "hotmail";

		try {
		    // Cargar el controlador JDBC
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    
		    // Establecer la conexión
		    Connection connection = DriverManager.getConnection(url, user, password);
		    
		    // Trabajar con la conexión...
		    System.out.println("=========================== Conexion realizada ===============================");
		    
		    // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            String query = "SELECT * FROM sucursal";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Retrieve column values for each row
                int id = resultSet.getInt("CODIGO_SUC");
                String name = resultSet.getString("NOM_SUCURSAL");
                String city = resultSet.getString("NOM_CIUDAD");
                // Retrieve other columns as needed

                // Process the data or perform desired o perations
                System.out.println("ID: " + id + ", Name: " + name + ", City: " + city);
            }

            // Close the resources
            resultSet.close();
            statement.close();
		    // Cerrar la conexión
		    connection.close();
		    System.out.println("=========================== Conexion Finalizada ===============================");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
}
