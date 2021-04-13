
package Interface;

import java.sql.SQLException;

public interface teacherLevel {
    
    public void print(int id ) throws SQLException;
    
    /// to delete level from one teacher
    public void delete(int id , int level) throws Exception;
    
    public void updateprice(int id , float newprice , int level) throws SQLException;
    
    public void updateLevel( int id ,int oldLevel, int newLevel ) throws SQLException;
    
}
