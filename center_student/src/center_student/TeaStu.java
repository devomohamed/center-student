package center_student;

import Interface.user;
import static center_student.Center_student.input;

public class TeaStu {
    
    //// take student or teacher
    public static void InsertData(user us ) throws Exception{
        
        System.out.print("enter id   : ");
        us.setId(input.nextInt());

        if(us.getId()==0)
            throw new Exception("exit");
        
        System.out.print("first name : ");
        String fName=input.next();

        System.out.print("last name  : ");
        String lName=input.next();

        String fullName=fName.concat(" "+lName);
        us.setName(fullName);

         if( us instanceof Teacher){
            System.out.print("enter object : ");
            ((Teacher)us).setSubject(input.next());
        }else if( us instanceof Student){
            System.out.print("enter level : ");
            ((Student)us).setLevel(input.nextInt());
        }
         
        System.out.print("enter phone  : ");
        us.setPhone(input.nextInt());  
    }
    
}
