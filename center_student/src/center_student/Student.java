package center_student;

import DbConnect.ToConnectDb;
import Interface.student;
import Interface.user;
import static center_student.Center_student.input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student extends user implements student{
    private int level;
    
    private PreparedStatement state;
    private ResultSet result;

    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    /// to set  data in student table --> student
    @Override
    public void setData() throws SQLException{
        String query="insert into student(id,name,phone,level) values(?,?,?,?)";
        
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, this.getId());
        state.setString(2, this.getName());
        state.setInt(3, this.getPhone());
        state.setInt(4, getLevel());
        state.execute();
        
        System.out.println("insert done ");
    }
    
    
    // print and hold data
    @Override
    public void print(int id ) throws Exception{
        String query="select * from student where id =?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        result=state.executeQuery();
        result.next();
        
        this.setId(result.getInt("id"));
        this.setName(result.getString("name"));
        this.setPhone(result.getInt("phone"));
        this.setLevel(result.getInt("level"));
        
        System.out.println("\nId : " + this.getId()+ " -*- name : " + this.getName()
            +" -*- phone : " + this.getPhone() + " -*- level " + this.getLevel()+"\n");
    }
            
    
    // to delete student
    @Override
    public void delete(int id ) throws Exception{
        String query="delete from student where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        state.execute();
        
        System.out.println("delete done ");
    }
    
    //**********
    @Override
    public void updateName(int id , String newName ) throws Exception{
   
        String query="update student set name=? where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setString(1, newName);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }
    
    @Override
    public void updatePhone(int id , int newPhone ) throws Exception{
        String query="update student set phone=? where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, newPhone);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }
    
    @Override
    public void updateLevel(int id , int newLevel) throws Exception{
        String query="update student set level=? where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, newLevel);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }

    
    public static int chooseStudent() throws Exception{
        System.out.println("\ninsert new student --> 1 ");
        System.out.println("delete student     --> 2");
        System.out.println("print student      --> 3");
        System.out.println("update student name --> 4");
        System.out.println("update student phone --> 5");
        System.out.println("update student level --> 6");
        System.out.println("Exit --> 0");
        return input.nextInt();
    }
    
}
