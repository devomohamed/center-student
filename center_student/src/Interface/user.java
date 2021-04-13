
package Interface;


public abstract class user {

    private int id=-1;
    
    private String name="no name";
    private int phone;
    
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    /// to set data in data base
    public abstract void setData() throws Exception;
    
    public abstract void delete(int id) throws Exception;
    
    public abstract void updateName(int id , String newName ) throws Exception;
    
    public abstract void updatePhone(int id ,int newPhone ) throws Exception; 
    
    public abstract void print(int id) throws Exception;
    
}
