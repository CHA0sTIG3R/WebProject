package edu.citytech.cst.WebProject.marginaltaxrate.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.function.Supplier;

@Controller
public class EmployeeReportController {

    @Autowired
    EmployeeService service;

    Map<String, Supplier<List<Employee>>> map = new HashMap<>();
    public void initialize(){
        map.put("ALL", service::getAllEmployees);
        map.put("F", service::getAllFemales);
        map.put("M", service::getAllMales);
        map.put("GT100K", service::getEmployeesGT100k);
        map.put("GT200K", service::getEmployeesGT200k);
        map.put("GT300K", service::getEmployeesGT300k);
        map.put("GT600K", service::getEmployeesGT600k);
        map.put("TriState", service::getEmployeesTriState);
    }

    @RequestMapping("/employeeReport")
    public String findEmployees(@ModelAttribute EmployeeInput formInput, Model model){

        if (map.isEmpty()) initialize();
        var code = formInput.getCode();
        var filteredList =map.getOrDefault(code, () -> new ArrayList<>()).get();
        model.addAttribute("employees", filteredList);
        model.addAttribute("size", filteredList.size());
        model.addAttribute("input", formInput);

        return "employeeReport.jsp";
    }
}
