package Interface;

import java.sql.SQLException;

public interface teacherStudent {
    
    // to print course and who teacher of student
    public void print(int id , int level) throws SQLException, Exception;
    
    public void insert(int idS,int idT ) throws SQLException;
    
}
