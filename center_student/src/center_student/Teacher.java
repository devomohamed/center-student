
package center_student;

import DbConnect.ToConnectDb;
import Interface.teacher;
import Interface.user;
import static center_student.Center_student.input;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Teacher extends user implements teacher{
    private String subject=null;
    
    private PreparedStatement state;
    private ResultSet result;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /// to set data
    @Override
    public void setData() throws Exception{
        String query="insert into teacher(id,name,subject,phone) values(?,?,?,?)";
        state=ToConnectDb.connect().prepareStatement(query);
        
        state.setInt(1, this.getId());
        state.setString(2, this.getName());
        state.setString(3, this.getSubject());
        state.setInt(4,this.getPhone());
        
        state.execute();
        
        System.out.println("insert done ");
        
    }
    
    @Override
    public void print(int id ) throws Exception{
        String query="select * from teacher where id =?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        result=state.executeQuery();
        result.next();
        
        this.setId(result.getInt("id"));
        this.setName(result.getString("name"));
        this.setSubject(result.getString("subject"));
        this.setPhone(result.getInt("phone"));
        
        System.out.println("\nId : " + this.getId()+ " --- name : " + this.getName() + 
            " --- subject : " + this.getSubject() + " --- phone : " + this.getPhone()+"\n");
    }
 
    @Override
    public void delete(int id ) throws Exception{
        String query="delete from teacher where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        state.execute();
        
        System.out.println("delete done ");
    }
    
    //**********
    @Override
    public void updateName(int id , String newName ) throws Exception{
   
        String query="update teacher set name=? where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setString(1, newName);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }
    
    @Override
    public void updatePhone(int id , int newPhone ) throws Exception{
        String query="update teacher set phone=? where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, newPhone);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }

    @Override
    public void updateObject(int id , String newSubject ) throws Exception{
        String query="update teacher set subject=? where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setString(1,newSubject);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }
 
    /// personal information
    public static int chooseteacher()  throws Exception{
        System.out.println("\ninsert new teacher --> 1 ");
        System.out.println("delete teacher     --> 2");
        System.out.println("print teacher      --> 3");  
        System.out.println("update teacher name --> 4");
        System.out.println("update teacher phone --> 5");
        System.out.println("update teacher Object --> 6");
        System.out.println("Exit --> 0");
        return input.nextInt();
    }
    
    // course and level
    public static int chooseCourses() throws  Exception{
        System.out.println("insert new course   --> 1 ");
        System.out.println("delete level        --> 2");
        System.out.println("update level salary --> 3");
        System.out.println("update level        --> 4");
        System.out.println("Exit --> 0");
        return input.nextInt();
    }
    
}
