package edu.citytech.cst.WebProject.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicTacToeController {
    @RequestMapping("/tictactoe")
    public String ticTacToe(){
        return "TicTacToe.html";
    }
}
