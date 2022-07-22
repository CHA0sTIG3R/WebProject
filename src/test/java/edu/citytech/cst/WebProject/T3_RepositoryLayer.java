package edu.citytech.cst.WebProject;

import edu.citytech.cst.WebProject.marginaltaxrate.employee.Employee;
import edu.citytech.cst.WebProject.marginaltaxrate.employee.EmployeeRepository;
import edu.citytech.cst.helper.dao.IQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3_RepositoryLayer {

    IQuery<Employee> query = new EmployeeRepository();

    @Test
    @DisplayName("Read Count")
    void t1(){
        List<Employee> list = query.findAll(e -> true);
        var actual = list.size();
        var expected = 400;

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Employees from CT")
    void t2(){
        List<Employee> list = query.findAll(e -> e.getState().equals("CT"));
        var actual = list.size();
        var expected = 44;
        list.forEach(System.out::println);
        System.out.println("Hamza, Olowu " + new Date());
        assertEquals(expected,actual);
    }

}
