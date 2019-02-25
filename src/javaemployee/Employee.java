

package javaemployee;


public class Employee {
   private int id;  
  private String department;  
  private String name;
  private double salary;
  private double  bonus=0;
  
    public Employee(int id) {
     this.id=id;
        
    }

    public int getId() {
        return id;
    }

    public Employee(String department, String name, double salary, double bonus,int id) {
        this.department = department;
        this.name = name;
        this.salary = salary;
        this.bonus=bonus;
       this.id=id;
    }

   
    public double getBonus() {
        double x=this.salary*this.bonus/100;
        return x;
       
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
       
    }
   
    



    @Override
    public String toString() {
        return getId() + "      " + getDepartment() + "                  " + getName() + "                         " + getSalary() + "                   " + getBonus()+"\n" ;
    }

    


}

