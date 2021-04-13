package center_student;

import DbConnect.ToConnectDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class studentTeacher {
 
    private int idTeacher;
    private int idstudent;

    private static PreparedStatement state;
    private static ResultSet result;
    
    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }
    
    public void insert(int idS,int idT ) throws SQLException{
        String query="insert into student_teacher values(?,?)";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, idS);
        state.setInt(2, idT);
        state.execute();
        
        System.out.println("insert done");
    }
    
    public void print(int id , int level) throws SQLException, Exception{
        String query="select * from student_teacher where id_student=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        result=state.executeQuery();
        
        boolean flag=true;
        
        while(result.next()){
            
            
            Teacher tea = new Teacher();
            if(flag)
                System.out.println("id student : "+ result.getInt("id_student"));
            
            System.out.print("-------------------******** teacher data **********-----------------------");
            //// get daata about teacher
            tea.print( result.getInt("id_teacher"));
            System.out.println("price course : " +TeacherLevel.printPrice(id, level));
            flag=false;
            
            System.out.println("------------------#################################------------------------");
        }
        
        if(flag){
            System.out.println("|----------------------------------------------|");
            System.out.println("|                No course                     |");
            System.out.println("|----------------------------------------------|\n");
        }
        
        System.out.println("");
    }
    
    public static void delete(int idS , int idT) throws Exception{
        String query="delete from student_teacher  where id_student=? and id_teacher=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, idS);
        state.setInt(2,idT );
        state.execute();
        System.out.println("delete done ");
    }
    
}
