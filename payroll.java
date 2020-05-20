import ePayroll.Employee;
import ePayroll.SalesEmployee;
import ePayroll.PartTimeEmployee;
import java.util.*; // used for Scanner and ArrayList

public class payroll
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      ArrayList employeeList = new ArrayList();
      initEmployeeList(employeeList);
      int option;
      do
      {
         displayMenu();
         System.out.print("Enter your option : ");
         option = input.nextInt();
         switch (option)
         {
            case 1: listEmployeesAndDetails(employeeList);
               break;
            case 2: listEmployeesAndPay(employeeList);
               break;
            case 3: Employee e = search(employeeList);
               break;
            case 4: updateCommissionRateOrHourlyRate(employeeList);
               break;
            case 5: updateSalesOfSalesEmployee(employeeList);
               break;
            case 0: System.out.println("Exiting programme...");
               break;
            default:System.out.println("Error: Invalid Input");
         }
      }while (option != 0);
   }
   public static void initEmployeeList(ArrayList employeeList)
   {
      Employee e = null;
      e = new SalesEmployee(1001, "Alex", 2000.00, 20000, 8.00);
      employeeList.add(e);
   
      e = new SalesEmployee(1002, "Mark", 1800.00, 22000, 6.00);
      employeeList.add(e);
   
      e = new SalesEmployee(1003, "Fiona", 2500.00, 16000, 5.00);
      employeeList.add(e);
   
      e = new PartTimeEmployee(2001, "Anna", 0.00, 100, 8.00);
      employeeList.add(e);
   
      e = new PartTimeEmployee(2002, "Ben", 0.00, 120, 9.00);
      employeeList.add(e);
   
      e = new PartTimeEmployee(2003, "John", 0.00, 110, 7.00);
      employeeList.add(e);
   }
   public static void displayMenu()
   {
      System.out.println("-------------- Payroll Application ---------------");
      System.out.println("[1] List all employees and their details");
      System.out.println("[2] List all employees and their pay");
      System.out.println("[3] Search employee by name");
      System.out.println("[4] Update commission rate or hourly rate");
      System.out.println("[5] Update sales of a sales employee");
      System.out.println("[0] Exit");
      System.out.println("--------------------------------------------------");
   }
   public static void listEmployeesAndDetails(ArrayList employeeList)
   {
      for (int i=0; i<employeeList.size(); i++)
      {
         Employee e = (Employee) employeeList.get(i);
         System.out.println(e.toString());
      }
   }  
   public static void listEmployeesAndPay(ArrayList employeeList)
   {
      for (int i=0; i<employeeList.size(); i++)
      {
         Employee e = (Employee) employeeList.get(i);
         System.out.println("ID:" + e.getId() + "\tName:" + e.getName() + "\tPay:" + e.calculatePay());
      }
   }
   public static Employee search(ArrayList employeeList)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter employee name: ");
      String n = input.nextLine();
      for (int i=0; i<employeeList.size(); i++)
      {
         Employee e = (Employee) employeeList.get(i);
         if (e.getName().equalsIgnoreCase(n))
         {
            System.out.println("ID:" + e.getId() + "\tName:" + e.getName() + "\tPay:" + e.calculatePay());
            return e;
         }
      }
      System.out.println("No such employee.");
      return null;
   }
   public static void updateCommissionRateOrHourlyRate(ArrayList employeeList)
   {
      Scanner input = new Scanner(System.in);
      for (int i=0; i<employeeList.size(); i++)
      {
         Employee e = (Employee) employeeList.get(i);
         System.out.println(e.toString());
      }
      System.out.print("Enter serial number of the employee: ");
      int s = input.nextInt();
      for (int i=0; i<employeeList.size(); i++)
      {
         Employee e = (Employee) employeeList.get(i);
         if (s == e.getId())
         {
            System.out.print("Enter new rate: ");
            double r = input.nextDouble();
            if (r >= 0 && e instanceof SalesEmployee)
            {
               SalesEmployee e1 = (SalesEmployee)e;
               e1.setCommissionRate(r);
               System.out.println("The commission rate is updated.");
               return;
            }
            else if (r >= 0 && e instanceof PartTimeEmployee)
            {
               PartTimeEmployee e1 = (PartTimeEmployee)e;
               e1.setHourlyRate(r);
               System.out.println("The hourly rate is updated.");
               return;
            }
            System.out.println("Error: Invalid Input");
            return;
         }
      }
      System.out.println("No match found.");
   } 
   public static void updateSalesOfSalesEmployee(ArrayList employeeList)
   {
      Scanner input = new Scanner(System.in);
      Employee e = search(employeeList);
      if (e instanceof SalesEmployee)
      {
         System.out.print("Enter new sales of employee: ");
         int s = input.nextInt();
         if (s >= 0)
         {
            SalesEmployee e1 = (SalesEmployee)e;
            e1.setSales(s);
            System.out.println("The sales is updated.");
         }
         else
            System.out.println("Error: Invalid Input");
      }
      else if (e instanceof PartTimeEmployee)
         System.out.println("Error: Employee is a part time employee");
   }
   
}