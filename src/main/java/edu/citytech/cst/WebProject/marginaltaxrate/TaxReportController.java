package edu.citytech.cst.WebProject.marginaltaxrate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaxReportController {
    @RequestMapping("/taxreport")
    public String helloWorld(){

        return "table-design.jsp";
    }
}
