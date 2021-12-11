package banan.edu.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class BoardUIController {

    @GetMapping("/board")
    String getBoard(){
        return "board";
    }
}
