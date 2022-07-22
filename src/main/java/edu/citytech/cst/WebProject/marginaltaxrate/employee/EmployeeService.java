package edu.citytech.cst.WebProject.marginaltaxrate.employee;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EmployeeService {

    private EmployeeRepository repo = new EmployeeRepository();

    private static Predicate<Employee> allEmployees = e -> true;
    private static Predicate<Employee> maleEmployees = e -> e.getGender().equals("M");
    private static Predicate<Employee> femaleEmployees = e -> e.getGender().equals("F");
    private static Predicate<Employee> employeesGT100k = e -> e.getSalary()>100_000;
    private static Predicate<Employee> employeesGT200k = e -> e.getSalary()>200_000;
    private static Predicate<Employee> employeesGT300k = e -> e.getSalary()>300_000;
    private static Predicate<Employee> employeesGT600k = e -> e.getSalary()>600_000;
    private static Predicate<Employee> employeesTriState = e -> e.getState().equals("NY")||e.getState().equals("NJ")||e.getState().equals("CT");

    public List<Employee> getAllEmployees(){
        return repo.findAll(allEmployees);
    }

    public List<Employee> getAllMales(){
        return repo.findAll(maleEmployees);
    }

    public List<Employee> getAllFemales(){
        return repo.findAll(femaleEmployees);
    }

    public List<Employee> getEmployeesGT100k(){
        return repo.findAll(employeesGT100k);
    }
    public List<Employee> getEmployeesGT200k(){
        return repo.findAll(employeesGT200k);
    }
    public List<Employee> getEmployeesGT300k(){
        return repo.findAll(employeesGT300k);
    }
    public List<Employee> getEmployeesGT600k(){
        return repo.findAll(employeesGT600k);
    }
    public List<Employee> getEmployeesTriState(){
        return repo.findAll(employeesTriState);
    }

    public static void main(String[] args) {
        new EmployeeService().getEmployeesGT100k()
                .forEach(System.out::println);
        System.out.println("Olowu, Hamza " + new Date());
    }

}
