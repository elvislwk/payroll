// SalesEmployee class derived from Employee class
package ePayroll;

public class SalesEmployee extends Employee
{
  	// Attributes
   private int sales;
   private double commissionRate;
  
  	// Behaviors
  
  	// constructors
   public SalesEmployee()
   {
      super();
      sales = 0;
      commissionRate = 0;
   }										// default constructor
 	 
   public SalesEmployee(int i, String n, double b, int s, double c) // parameterised constructor
   { 
      super(i,n,b); 
      sales = s;
      commissionRate = c;
   }
  
  	// set and get methods
   public void setSales(int s) { sales = s; }
   public int  getSales() { return sales; }
   public void setCommissionRate(double c) {commissionRate = c; }
   public double getCommissionRate() { return commissionRate; }
   
   public double calculatePay()
   {
      return super.getBasicSalary() + sales * (commissionRate / 100);
   }
   
	// toString method
   public String toString()
   {
      return super.toString() + "\tSales:" + sales + "\t\tCommission Rate:" + commissionRate;
   }
}