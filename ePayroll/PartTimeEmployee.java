// PartTimeEmployee class derived from Employee class
package ePayroll;

public class PartTimeEmployee extends Employee
{
  	// Attributes
   private int hoursWorked;
   private double hourlyRate;
  
  	// Behaviors
  
  	// constructors
   public PartTimeEmployee()
   {
      super();
      hoursWorked = 0;
      hourlyRate = 0;
   }										// default constructor
 	 
   public PartTimeEmployee(int i, String n, double b, int hw, double hr) // parameterised constructor
   { 
      super(i,n,b); 
      hoursWorked = hw;
      hourlyRate = hr;
   }
  
  	// set and get methods
   public void setHoursWorked(int hw) { hoursWorked = hw; }
   public int  getHoursWorked() { return hoursWorked; }
   public void setHourlyRate(double hr) {hourlyRate = hr; }
   public double getHourlyRate() { return hourlyRate; }
   
   public double calculatePay()
   {
      return hoursWorked * hourlyRate;
   }
   
	// toString method
   public String toString()
   {
      return super.toString() + "\tHours Worked:" + hoursWorked + "\tHourly Rate:" + hourlyRate;
   }
}