
package javaemployee;

import java.util.*;
import javax.swing.*;

public class JavaEmployee {
    static int serilNumber=1001;
static  Employee  [] arrayEmployee=new Employee [10];
  public static int count(){
      int size=0;
      for (int i = 0; i < arrayEmployee.length; i++) {
          if (arrayEmployee[i]!=null) {
             size=size+1; 
          }
      }
      return size;
  } 
    static  Scanner in =new Scanner(System.in);
     
    //  قائمة عرض رئيسبة لاختيار العمليةالمراد فعلها
    
   public static void  JOptionPaneInput(){
      
       String a="1- Create Employee.\n"
               +"2- Modify employee data.\n"
               +"3- Delete Acount Employee. \n"
               +"4-View employee data.\n"
               +"5-View all employee data.\n"
               +"6-Exit.\n";
       
        //تم عمل لووب  وسويتش ليدور حول العمليات
     while(true){
          switch(JOptionPane.showInputDialog(null,a)){
             case "1":{
               createEmployee();
            
             }
             break;
             case "2":{
                ModifyEmployee();
             }
             break;
             case "4":{
               ViewEmployee();  
             }
             break;
             case "5":{
                 ViewAllEmployee();
             }
             break;
             case "3":{
                 
               DeleteEmployee();  
             }
             break;
             case "6":{
                 
                 System.exit(0);
             }
             
         }
         
     }
   }
   
    //مثود تقوم بانشاء موظف
   
    private static void createEmployee() {
        //عملية test
      
        if (count()<10) {
            
        

       Employee employee=new Employee(serilNumber);
      
    employee.setName(JOptionPane.showInputDialog(null,"Enter Youer Name?"));   
    employee.setDepartment(JOptionPane.showInputDialog(null,"Enter Youer Department? ")); 
    employee.setSalary(Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Youer Salary? "))); 
    employee.setBonus(Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Youer Bonus? "))); 
   
          for (int i =0 ; i < arrayEmployee.length; i++) {
              if (arrayEmployee[i]==null) {
                  arrayEmployee[i]=employee;
                  JOptionPane.showMessageDialog(null,"Nmber ID :"+arrayEmployee[i].getId());
                  serilNumber=serilNumber+1;
                 break;
              }
              
          }
    }
    }
    
    //مثود تقوم بالتعديل على البيانات
    
    private static void ModifyEmployee() {
        while(true){
            int x=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID Employee"));
            for (int i = 0; i < arrayEmployee.length; i++) {
              if(arrayEmployee[i].getId()==x){
                 String text="1-Modify Employee Salary\n" +"2-Modify Employee Bouns";
                 boolean test=true;
                 while(test){
                     switch(JOptionPane.showInputDialog(null, text)){
                         case "1" :{
                            test=false;
                           arrayEmployee[i].setSalary(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Salary")));
                            
                         }
                         break;
                          case "2" :{
                              test=false;
                           arrayEmployee[i].setBonus(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Bouns")));
                           
                         }
                       
                     }
                     
                 }
                 break;
              }
             
                }
            break;
                }
    }
    
    //مثود تقوم بعرض بيانات الموظف 
    
    private static void ViewEmployee() {
             String text="ID"+"      " + "         " + "Name" + "                   " + "Department"+ "                         " + "Salary" + "                          " + "Bonus\n" ;
            int x=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID Employee"));
            for (int i = 0; i < arrayEmployee.length; i++) {
              if(arrayEmployee[i].getId()==x){
                  
        JOptionPane.showMessageDialog(null, text+arrayEmployee[i].toString());
        break;
             }
            }
           }
    //مثود تقوم بعرض جميع بيانات الموظفين
    /*
    1-حسب الاسم 
    2-حسب الراتب
    */

    private static void ViewAllEmployee() {
         String text="                                    Data Employee\n";
       text+="ID"+ "     " + "Name" + "      " + "Department"+ "      " + "Salary" + "      " + "Bonus\n" ;
           String data=" ";
           String datashow="1-Display data by name\n 2-Display data by salary\n\n";
           
           
          
           
           while(true){
               
         String test=JOptionPane.showInputDialog(null, datashow);
         
         if("1".equals(test) || "2".equals(test)){
           switch(test){
               //الترتيب حسب الاسم
               case "2" :{
                   for (int i = 0; i < arrayEmployee.length-1; i++) {
                       if(arrayEmployee[i]!=null){
                       for (int j =i+1; j <arrayEmployee.length; j++) {
                           Employee swamp=null;
                           if (arrayEmployee[j]!=null) {
                               if (arrayEmployee[j].getSalary()>arrayEmployee[i].getSalary()) {
                                   swamp=arrayEmployee[i];
                                  arrayEmployee[i]=arrayEmployee[j];
                                  arrayEmployee[j]=swamp;
                               }
 
                           }
                       }
                       }
                   }
               } 
               break;
               //الترتيب حسب الراتب
               case "1":{
                   //(compareTo) عن طريق (Array)تم ترتيب 
                  /* for (int i = 0; i < arrayEmployee.length-1; i++) {
                       if(arrayEmployee[i]!=null){
                       for (int j =i+1; j <arrayEmployee.length; j++) {
                           Employee swamp=null;
                           if (arrayEmployee[j]!=null) {
                               if (arrayEmployee[j].getName().compareTo(arrayEmployee[i].getName())<0) {
                                   swamp=arrayEmployee[i];
                                  arrayEmployee[i]=arrayEmployee[j];
                                  arrayEmployee[j]=swamp;
                               }
 
                           }
                       }
                       }
                   } */
                  // مرتبة(Array)التي ترجع(methods sortName(Employee [] employee)) عن طريق (تم ترتيب 
          arrayEmployee=sortName(arrayEmployee);
               } 
         break;
             
        
            
           }
             for (int i = 0; i <arrayEmployee.length; i++) {
                       if (arrayEmployee[i]!=null) {
                           data+=arrayEmployee[i].toString();
                           
                       }
                   }
 
               JOptionPane.showMessageDialog(null, text+data);

         break;}
           
           
           }
    }
    //مثود تقوم بحذف بيانات موظف
      
       private static void DeleteEmployee() {

        if (count()>0) {
            
        boolean test=true;
        while(test){
      
            int x=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID Acount Delete Employee?"));
            
          for (int i = 0; i < arrayEmployee.length; i++) {
            
            if (arrayEmployee[i].getId()==x) {
              
                try{ 
                arrayEmployee[i]=null;
                }catch(Exception e){
                System.out.println("error delete!!!!!!!!!!!!!!!!!!!");
                break;
             }
               JOptionPane.showMessageDialog(null,"Count Employee is \n"+count());
                test=false;
                break;
            }
        
        
          
            
                  }
    }
    }
    }
   
    public static void main(String[] args) {
     
      String test="1-Enter System input JOptionPane.\n 2-Enter System input Scanner.  \n 3-Exit.";
     
    while(true){
         String input=JOptionPane.showInputDialog(null, test);
         if ("1".equals(input)||"2".equals(input)||"3".equals(input)) {
            
        
     switch(input){
         case "2":{
         scannerInput();
         }
         break;
         case "1":{
      JOptionPaneInput();
         }
         break;
         case "3":{
             System.exit(0);
         }
     }
     break;
         }
        System.out.println("Error in System ........!!!!!!!!");
      
    }}    
    // ( input Scanner)ادخال البيانات عن طريق
 private static void scannerInput() {
        
       
        //تم عمل لووب  وسويتش ليدور حول العمليات
     while(true){
         System.out.print("1- Create Employee.\n"
               +"2- Modify employee data.\n"
               +"3- Delete Acount Employee. \n"
               +"4-View employee data.\n"
               +"5-View all employee data.\n"
               +"6-Exit.\n");
          System.out.println("Enter Number:");
         String s=in.next();
          switch(s){
             case "1":{
               createEmployee1();
           
             }
             break;
             case "2":{
                ModifyEmployee1();
             }
             break;
             case "4":{
               ViewEmployee1();  
             }
             break;
             case "5":{
              ViewAllEmployee1();
             }
             break;
             case "3":{
                 
               DeleteEmployee1();  
             }
             break;
             case "6":{
                 
                 System.exit(0);
             }
             
         }
         
     }
   }
 //انشاء موظف عن طريق سكنر
     private static void createEmployee1(){
        //عملية test
      
        if (count()<10) {
            
        
       Employee employee=new Employee(serilNumber);
      
            System.out.println("Enter Youer Name?");   
            employee.setName(in.next());
            System.out.println("Enter Youer Department? ");
            employee.setDepartment(in.next());
            System.out.println("Enter Youer Salary ");
            employee.setSalary(in.nextDouble());
             System.out.println("Enter Youer Bonus");
            employee.setBonus(in.nextDouble());
          for (int i =0 ; i < arrayEmployee.length; i++) {
              if (arrayEmployee[i]==null) {
                  arrayEmployee[i]=employee;
                  
                  System.out.println("Number ID :"+arrayEmployee[i].getId());
                  serilNumber=serilNumber+1;
                 break;
              }
              
          }
    }
        
    }
     //تعديل بيانات موظف عبن طريق سكنر
      private static void ModifyEmployee1() {
        while(true){
            System.out.println("Enter ID Employee ?");
            int x=in.nextInt();
                    
            for (int i = 0; i < arrayEmployee.length; i++) {
              if(arrayEmployee[i].getId()==x){
                 String text="1-Modify Employee Salary\n" +"2-Modify Employee Bouns";
                 boolean test=true;
                 while(test){
                     System.out.println(text);
                     String n=in.next();
                     switch(n){
                         case "1" :{
                            test=false;
                             System.out.println("Enter Salary ?");
                            double salary=in.nextDouble();
                           arrayEmployee[i].setSalary(salary);
                            
                         }
                         break;
                          case "2" :{
                              test=false;
                               System.out.println("Enter Bouns ?");
                            double Bouns=in.nextDouble();
                           arrayEmployee[i].setBonus(Bouns);
                           
                         }
                       
                     }
                     
                 }
                 break;
              }
             
                }
            break;
                }
    }
      //عرض بيانات موظف عن طريق سكنر
        private static void ViewEmployee1() {
             String text="ID"+"      " + "         " + "Name" + "                   " + "Department"+ "                         " + "Salary" + "                          " + "Bonus\n" ;
            System.out.println("Enter ID Employee");
            int x=in.nextInt();
            
            for (int i = 0; i < arrayEmployee.length; i++) {
              if(arrayEmployee[i].getId()==x){
                  System.out.println(text);
                  System.out.println(arrayEmployee[i].toString());
        break;
             }
            }
           }
        //حذف موظف 
         private static void DeleteEmployee1() {

        if (count()>0) {
            
        boolean test=true;
        while(test){
            System.out.println("Enter ID Acount Delete Employee?");
            int x=in.nextInt();
            
          for (int i = 0; i < arrayEmployee.length; i++) {
            
            if (arrayEmployee[i].getId()==x) {
              
                try{ 
                arrayEmployee[i]=null;
                }catch(Exception e){
                System.out.println("error delete!!!!!!!!!!!!!!!!!!!");
                break;
             }
                System.out.println("Count Employee is \n"+count());
                test=false;
                break;
            }
        
        
          
            
                  }
    }
    }
    }
         //مثود تقوم بعرض البيانات وترتيبها حسب الاسم أو حسب الراتب
           private static void ViewAllEmployee1() {
         String text="                                    Data Employee\n";
       text+="ID"+ "     " + "Name" + "      " + "Department"+ "      " + "Salary" + "      " + "Bonus\n" ;
           String data=" ";
           String datashow="1-Display data by name\n 2-Display data by salary\n\n";
           
           
          
           
           while(true){
               
               System.out.println(datashow);
               System.out.println("Enter Number :");
               String test=in.nextLine();
         
         if("1".equals(test) || "2".equals(test)){
           switch(test){
               //الترتيب حسب الاسم
               case "2" :{
                   for (int i = 0; i < arrayEmployee.length-1; i++) {
                       if(arrayEmployee[i]!=null){
                       for (int j =i+1; j <arrayEmployee.length; j++) {
                           Employee swamp=null;
                           if (arrayEmployee[j]!=null) {
                               if (arrayEmployee[j].getSalary()>arrayEmployee[i].getSalary()) {
                                   swamp=arrayEmployee[i];
                                  arrayEmployee[i]=arrayEmployee[j];
                                  arrayEmployee[j]=swamp;
                               }
 
                           }
                       }
                       }
                   }
               } 
               break;
               //الترتيب حسب الراتب
               case "1":{
                   //(compareTo) عن طريق (Array)تم ترتيب 
                  /* for (int i = 0; i < arrayEmployee.length-1; i++) {
                       if(arrayEmployee[i]!=null){
                       for (int j =i+1; j <arrayEmployee.length; j++) {
                           Employee swamp=null;
                           if (arrayEmployee[j]!=null) {
                               if (arrayEmployee[j].getName().compareTo(arrayEmployee[i].getName())<0) {
                                   swamp=arrayEmployee[i];
                                  arrayEmployee[i]=arrayEmployee[j];
                                  arrayEmployee[j]=swamp;
                               }
 
                           }
                       }
                       }
                   } */
                  // مرتبة(Array)التي ترجع(methods sortName(Employee [] employee)) عن طريق (تم ترتيب 
          arrayEmployee=sortName(arrayEmployee);
               } 
         break;
             
        
            
           }
             System.out.println(text);
             for (int i = 0; i <arrayEmployee.length; i++) {
                       if (arrayEmployee[i]!=null) {
                           System.out.println(arrayEmployee[i].toString());
                           
                       }
                   }
 
            

         break;}
           
           
           }
    }
           //مثود تقوم بترتيب أسماء الموظفيين
         private static Employee[] sortName(Employee[] employee){
             
             for (int i = 0; i <employee.length-1; i++) {
                 if(employee[i]!=null){
                 for (int j =i+1; j <employee.length; j++) {
                     if (employee[j]!=null) {
                         int i1=0;
                         int j2=0;
                         for (int k = 0; k <employee[i].getName().length(); k++) {
                             i1=i1+employee[i].getName().charAt(k);
                            
                         }
                          for (int k = 0; k <employee[j].getName().length(); k++) {
                             j2=j2+employee[j].getName().charAt(k);
                         }
                          Employee swamp=null;
                          if (j2<i1) {
                             swamp=employee[i];
                             employee[i]=employee[j];
                             employee[j]=swamp;
                         }
                     }
                 }
                 }
                 
             }
            return employee; 
         }
    }


