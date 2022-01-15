package banan.edu.controlers;

import banan.edu.model.Card;
import banan.edu.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui")
public class BoardUIController {

    @Autowired
    BoardServiceImpl boardService;

    @GetMapping("/board")
    String getBoard(Model model){
        List<Card> deck = boardService.getStack();
        List<Card> deck2 = new ArrayList<>();
        for (int i = 0; i <deck.size()-1 ; i++) {
                deck2.add(new Card(i,"/image/back.png",i*4));
        }

        model.addAttribute("deck",deck2);
        model.addAttribute("trumpCard",deck.get(deck.size()-1));
        return "board";
    }

}
