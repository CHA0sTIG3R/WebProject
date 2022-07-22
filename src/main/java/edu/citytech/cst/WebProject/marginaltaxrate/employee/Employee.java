package edu.citytech.cst.WebProject.marginaltaxrate.employee;

import org.apache.poi.ss.usermodel.Row;

import static edu.citytech.cst.WebProject.utility.FormatDataUtility.format;

public class Employee {

    private String employeeId, state, gender;
    private float salary;
    private String status;
    private String formattedSalary;

    public String getFormattedSalary() {
        return formattedSalary;
    }

    public Employee() {

    }
    public Employee(Row row) {
        this.employeeId = row.getCell(0).getStringCellValue();
        this.state = row.getCell(1).getStringCellValue();
        this.gender = row.getCell(2).getStringCellValue();
        this.salary = (float) row.getCell(3).getNumericCellValue();
        this.status = row.getCell(4).getStringCellValue();
        this.formattedSalary = format(salary);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getState() {
        return state;
    }

    public String getGender() {
        return gender;
    }

    public float getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", state='" + state + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", status='" + status + '\'' +
                ", formattedSalary='" + formattedSalary + '\'' +
                '}';
    }
}
