
package DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ToConnectDb {
    
    private static final String pass="jdbc:mysql://localhost/center_student";
    private static final String name="root";
    private static final String password="";
    
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(pass, name, password);
    }
    
}
