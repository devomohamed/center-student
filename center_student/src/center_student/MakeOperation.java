package center_student;

import Interface.user;
import static center_student.Center_student.input;

public class MakeOperation {
    /*
     public static void Operartion1( int chooseStudent , user use) throws Exception{
        
        if( use instanceof Student ){
            Student stu=(Student)use;
            operation(chooseStudent ,stu ) ;
        }else if( use instanceof Teacher){
            Teacher tea = (Teacher)use;
            operation(chooseStudent, tea);
        }
    }*/
     
    public static void Operartion(int chooseStudent,user use ) throws Exception{
        if(chooseStudent==1){
            ////polymorphism
            TeaStu.InsertData(use); 
            use.setData(); //// to store it in data base
            use.print(use.getId());/// print after insert
            return;
        }
        int id=holdDataId();
        if(id==0) return;
        use.print(id);
        
        switch (chooseStudent) {
            case 2:// to delete
                if( checkOk()==1)
                    use.delete(id);
                break;
            case 3:///already print
                break;
            case 4:
                /// update name
                String fullName=updateName();
                if( checkOk()==1)
                    use.updateName(id, fullName);
                use.print(use.getId());
                break;
            case 5: /// update phone
                int phone =updatePhone();
                if(checkOk()==1)
                    use.updatePhone(id, phone); 
                use.print(use.getId());/// print after update
                break;
            case 6: ///  update level
                if( use instanceof Student){
                    setLevel(id,(Student)use);
                }else if( use instanceof Teacher){
                    setSubject( id , (Teacher)use);
                }
            default:
                break;
        } 
    }
    
    private static void setLevel(int id ,Student stu) throws Exception{
        System.out.print("enter new level : ");
        int level =input.nextInt();
                
        if(checkOk()==1)
            /// to perform in data base
            stu.updateLevel(id, level); 
        stu.print(stu.getId());/// print after update
    }
    
    private static void setSubject(int id ,Teacher tea) throws Exception{
        System.out.print("enter new subject : ");
        String subject=input.next();
                
        if(checkOk()==1)
            /// to perform in data base
            tea.updateObject(id,subject );
        tea.print(tea.getId());/// print after update
    }
    
    // to confirm in operation or return
    private static int checkOk(){
        System.out.println("to ok enter 1 ");
        return input.nextInt();
    }
    
     /// update name in student
    private static String updateName(){
        System.out.print("new first name : ");
        String fName=input.next();
        System.out.print("new last name  : ");
        String lName=input.next();
        
        return fName.concat(" "+lName);
    }
    
    private static int updatePhone(){
        System.out.print("new phone : ");
        return input.nextInt();
    }
    
    
    private static int holdDataId(){
        System.out.print("enter id to exit enter 0 : ");
        return input.nextInt();
    }
}
