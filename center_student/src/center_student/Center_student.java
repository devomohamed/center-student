package center_student;

import java.util.Scanner;

public class Center_student {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        boolean flag=true;
        while(flag){
            try {    
                /// chosse student or teacher
                int choose =start();
            
                if(choose==1){
                    boolean flagStudent=true;
                    while(flagStudent){
                        flagStudent=false;
                        
                        System.out.println("personal information --> 1 ");
                        System.out.println("course --> 2 ");
                        int n=input.nextInt();

                        // student
                        if(n==1){
                            Student stu = new Student();
                            int choseOp=Student.chooseStudent();

                            if(choseOp<0||choseOp>6){
                                System.out.println("please enter rigth value ");
                                continue;
                            }
                            MakeOperation.Operartion(choseOp, stu);
                            /// student and course
                        }else if( n==2){
                            
                            Student stu = new Student();
                            studentTeacher stte= new studentTeacher();
                            
                            /// print perdonal data about student
                            stu.setId(dataId());
                            stu.print(stu.getId());
                            
                            // print student course with teacher
                            stte.print(stu.getId(),stu.getLevel());
                            
                            switch(chooseStuCourse()){
                                case 1:
                                    System.out.println("enter id teacher : ");
                                    int idT=input.nextInt();
                                    Teacher tea = new Teacher();
                                    
                                    tea.print(idT);
                                    
                                    if(checkOk()==1)
                                        stte.insert(stu.getId(), idT);
                                    break;
                                case 2 :
                                        System.out.println("enter id teacher : ");
                                        int idtea=input.nextInt();
                                    
                                        if(checkOk()==1)
                                            studentTeacher.delete(stu.getId(), idtea);
                                        break;
                            }
                            
                        }
                        System.out.println("to continue enter 1 to exit from it inter 0 ");
                        if( input.nextInt()==1)
                            flagStudent=true;
                        
                    }
                }
                ///////######################### end Student
                ////// ******************************teacher
                else if( choose ==2){ 
                    
                    boolean flagteacher=true;
                    while(flagteacher){
                        flagteacher=false;
                        
                        System.out.println("personal information --> 1 ");
                        System.out.println("course --> 2 ");
                        int n=input.nextInt();
                        
                        if(n==1){
                        Teacher tea = new Teacher();
                        
                        /// to choose insert or delete or up .. from teacher
                        int chooseteacher=Teacher.chooseteacher();
                        if(chooseteacher<1||chooseteacher>6){
                            System.out.println("not valid operation");
                            continue;
                        }
                        /// to perform the operation
                        MakeOperation.Operartion(chooseteacher, tea);
                        }else if(n==2){
                            ///at first print data and course
                            Teacher tea = new Teacher();
                            TeacherLevel tele= new TeacherLevel();
                            int id=dataId();
                            
                            if(id==0) return;
                            tea.print(id); //// print and get data --> one one name one id one subject
                            tele.print(id);
                            
                            switch(Teacher.chooseCourses()){
                                case 1 :  
                                    while(setTeaLev(tele , id )){
                                        if(checkOk()==1)
                                            tele.setData();
                                    }
                                    break;
                                case 2 : 
                                    System.out.println("enter level to delet it");
                                    int levelDelete=input.nextInt();
                                    if(checkOk()==1)
                                        tele.delete(id,levelDelete );
                                    break;
                                case 3 :
                                    System.out.println("enter level : ");
                                    int level =input.nextInt();
                                    System.out.println("new price ");
                                    float price = input.nextFloat();
                                    if(checkOk()==1)
                                        tele.updateprice(id, price, level);
                                    break;
                                case 4 : 
                                    System.out.println("enter old level : ");
                                    int oldLevel =input.nextInt();
                                    System.out.println("enter new level : ");
                                    int newLevel =input.nextInt();
                                    if(checkOk()==1)
                                        tele.updateLevel(id, oldLevel, newLevel);
                                    break;
                            }
                          
                        }
                        System.out.println("\nto continue enter 1 to exit from it inter 0 ");
                        if( input.nextInt()==1)
                            flagteacher=true;
                    }
                   
                        
               }   
            }catch (Exception e) {
                System.out.println(e.getMessage());
                flag=false;
            }
         
            /// to void Exception
            if(flag){
                System.out.println("\nto go main menu enter 1 to exit enter 0");
                flag=input.nextInt()==1;   
            }
           
        }
    }//////################################################ end main
    
    /// to show the list
    private static int start() throws Exception{
        System.out.println("Student --> 1 ");
        System.out.println("teacher --> 2 ");
        System.out.println("Exit --> 0");
        return input.nextInt();
    }
         
    private static int dataId(){
        System.out.print("enter id to exit enter 0 : ");
        return input.nextInt();
    }
    
    private static boolean setTeaLev(TeacherLevel tl , int id ) throws Exception{
        tl.setId(id);
        
        System.out.println("\nto exit enter 0");
        System.out.println("add level :");
        int level = input.nextInt();
        if( level<=0)
            return false;    
        tl.setLevel(level);

        System.out.println("enter salary : ");
        tl.setPrice(input.nextFloat());
        
        return true;
    }
    
     // to confirm in operation or return
    private static int checkOk(){
        System.out.print("to ok enter 1 :  ");
        return input.nextInt();
    }
    
    public static int chooseStuCourse(){
        System.out.println("to insert course ---> 1 ");
        System.out.println("to delete course ---> 2 ");
        return input.nextInt();
    }
}
