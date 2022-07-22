package edu.citytech.cst.WebProject.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "/home", "/index",  "/" })
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping({ "NA" })
	public String na() {
		return "NA.jsp";
	}

}