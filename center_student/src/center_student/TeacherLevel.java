package center_student;

import DbConnect.ToConnectDb;
import Interface.teacherLevel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherLevel implements teacherLevel{
    
    private int id;
    private int level;
    private float price;

    private static PreparedStatement state;
    private static ResultSet result;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    //// to set data level and price in data base
    public  void setData() throws SQLException{
        String query="insert into teacher_level(id,level,price) values(?,?,?)";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, this.id);
        state.setInt(2, this.level);
        state.setFloat(3, this.price);
        state.execute();
        
        System.out.println("insert done ");
    }
    
    
    @Override
    public void print(int id ) throws SQLException{
        String query="select * from teacher_level where id=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1,id);
        result=state.executeQuery();
        boolean flag=true;
        
        while(result.next()){
            if( flag){
                System.out.println("ID : " + result.getInt("id") + " -*- level : " +result.getInt("level")
                + " -*- price : " + result.getFloat("price"));
            }else{
                System.out.println("      " + " -*- level : " +result.getInt("level")
                + " -*- price : " + result.getFloat("price"));
            }
            flag=false;
        }
         if(flag){
            System.out.println("|----------------------------------------------|");
            System.out.println("|           you have no course teacher         |");
            System.out.println("|----------------------------------------------|\n");
        }
    }
    
    /// to delete level from one teacher
    @Override
    public void delete(int id , int level) throws Exception{
        String query="delete from teacher_level where id=? and level=?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        state.setInt(2, level);
        state.execute();
        System.out.println("delete done ");
    }
    
    @Override
    public void updateprice(int id , float newprice , int level) throws SQLException{
        String query="update teacher_level set price=? where id=? and level =?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setFloat(1, newprice);
        state.setInt(2, id);
        state.setInt(3, level);
        state.execute();
        
        System.out.println("update done");
    }
    
    @Override
    public void updateLevel( int id ,int oldLevel, int newLevel ) throws SQLException{
        String query="update teacher_level set level =?  where id=? and level =?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, newLevel);
        state.setInt(2, id);
        state.setInt(3, oldLevel);
        state.execute();
        
        System.out.println("update done");
    }
    
    /// to get price course salary
    public static int printPrice(int id , int level ) throws SQLException{
        String query="select price from teacher_level where id=? and level =?";
        state=ToConnectDb.connect().prepareStatement(query);
        state.setInt(1, id);
        state.setInt(2, level);
        result=state.executeQuery();
        
        if(result.next())
            return result.getInt("price");
        else
            return -1;
    }
    
  
}
