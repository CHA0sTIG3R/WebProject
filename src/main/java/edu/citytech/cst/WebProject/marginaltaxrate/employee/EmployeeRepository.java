package edu.citytech.cst.WebProject.marginaltaxrate.employee;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.ReadExcelUtility;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeRepository implements IQuery<Employee> {

    private List<Employee> list;

    public EmployeeRepository(){
        list = ReadExcelUtility
                .processFromResource("static/SimpleTaxRate.xlsx",
                        "data", 1, Employee::new);

    }

    @Override
    public Employee findById(Predicate<Employee> predicate) {
        return null;
    }

    @Override
    public List<Employee> findAll(Predicate<Employee> predicate) {
        var currentList = this.list.stream()
                .filter(predicate).toList();
        return currentList;
    }
}
