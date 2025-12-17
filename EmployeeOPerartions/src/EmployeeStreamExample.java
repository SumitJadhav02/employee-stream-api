import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExample {

    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee(1, "Rahul", "HR", 42000.0, "male"),
                new Employee(2, "Ganesh", "IT", 32000.0, "male"),
                new Employee(3, "Sonal", "Finance", 23000.0, "female"),
                new Employee(4, "Raju", "IT", 55000.0, "male"),
                new Employee(5, "Pravin", "IT", 42000.0, "male"),
                new Employee(6, "Tanishka", "HR", 20000.0, "female"),
                new Employee(7, "Sunit", "Finance", 20000.0, "male"),
                new Employee(8, "Sohel", "HR", 20000.0, "male")
        );
        System.out.println("=================================================================");

       
        // 2. Count employees by gender
        Map<String, Long> genderCount =
                empList.stream()
                       .collect(Collectors.groupingBy(
                               Employee::getGender,
                               Collectors.counting()
                       ));

        genderCount.forEach((gender, count) ->
                System.out.println(gender + " : " + count)
        );
        System.out.println("=================================================================");
        // 3. Average salary by gender
        Map<String, Double> avgSalaryByGender =
                empList.stream()
                       .collect(Collectors.groupingBy(
                               Employee::getGender,
                               Collectors.averagingDouble(Employee::getSalary)
                       ));

        avgSalaryByGender.forEach((gender, avgSalary) ->
                System.out.println(gender + " : " + avgSalary)
        );
        System.out.println("=================================================================");
        // 4. Employee with the highest salary
        String highestPaidEmployee =
                empList.stream()
                       .max(Comparator.comparingDouble(Employee::getSalary))
                       .map(Employee::getName)
                       .orElse("N/A");

        System.out.println("Highest Paid Employee: " + highestPaidEmployee);
        
        
        
        //Count the number of employees in each department.
        System.out.println("=================================================================");
        
        Map<String , Long> coutOfEmpByDept = empList.stream()
        		                                    .collect(Collectors.groupingBy(
        		                                    		Employee::getDeptName,
        		                                    		Collectors.counting()
        		                                    		));
        
        System.out.println("Count of employees in each department");
        coutOfEmpByDept.forEach((dept, count) -> System.out.println(dept+":"+count));
        
        System.out.println("=================================================================");
        
        
        //Find all employee names whose salary is greater than 30,000.
        System.out.println("Find all employee names whose salary is greater than 30,000");
        
        
        List<String> nameOfEmpMoreSalry = empList.stream()
        		                                 .filter(emp -> emp.getSalary() > 30000)
        		                                 .map(Employee::getName)
        		                                 .collect(Collectors.toList());
        
        System.out.println(nameOfEmpMoreSalry);
        
        System.out.println("=================================================================");
        
        
        //Get a list of employee names in uppercase.
        
        
        System.out.println("Get a list of employee names in uppercase");
        List<String> empNamesInCapital = empList.stream()
        		                                .map(emp -> emp.getName().toUpperCase())
        		                                .collect(Collectors.toList());
        
        System.out.println(empNamesInCapital);
        
        System.out.println("=================================================================");
        
        //Find the total salary paid to all employees.
        
        System.out.println(" Find the total salary paid to all employees ");
        
        Double totalSalary = empList.stream().mapToDouble(Employee::getSalary).sum();
        
        System.out.println(totalSalary);
        
        System.out.println("=================================================================");
        
      //  Find the lowest-paid employee.
        
        System.out.println(" Find the lowest-paid employee. ");
        
        String name = empList.stream().min(Comparator.comparingDouble(Employee::getSalary)).map(Employee::getName).orElse(null);
        
        System.out.println(name);
        
        System.out.println("=================================================================");
        
        //Find the highest-paid employee.
        
        Employee higestPaid = empList.stream()
                                     .reduce((e1,e2)  -> e1.getSalary() > e2.getSalary() ? e1 : e2).orElse(null);      
        System.out.println( higestPaid.getName() +" : "+higestPaid.getSalary());
    }
}
