// Employee class
package ePayroll;

public abstract class Employee 
{
   // attributes
   private int id;
   private String name; 
   protected double basicSalary; 
   
   // behaviors
   
   // constructors
   public Employee()									// default constructor
   {
       // attributes will be initialized to their default values
   }

   public Employee(int i, String n, double b)	// parameterised constructor
   {
      id = i;
      name = n;
      basicSalary = b;
   }
   
   // set and get methods
   public void   setId(int i) { id = i; }
   public int    getId() { return id; }  
   public void   setName(String n) { name = n; }
   public String getName() { return name; }
   public void   setBasicSalary(double b) { basicSalary = b; }
   public double getBasicSalary(){ return basicSalary; }

   public abstract double calculatePay();

   // toString method
   public String toString()
   { 
      return "ID:" + id + "\tName:" + name + "\tBasic Salary:" + basicSalary;
   }

}