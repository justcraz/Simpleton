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
        List<Card> playerCards = new ArrayList<>();
        for (int i = 1; i < boardService.getStack().size(); i++) {
                deck2.add(new Card(i,boardService.getStack().get(i).getImage(),i*20));
        }
        model.addAttribute("deck",deck2);
        model.addAttribute("trumpCard",deck.get(0));
        model.addAttribute("playerCards",playerCards);
        return "board";
    }

    @GetMapping("/give/cards/to/player")
    String givePlayerCards(Model model){
        List<Card> deck = boardService.getStack();
        List<Card> deck2 = new ArrayList<>();
        List<Card> playerCards = boardService.getPlayerCards();
        for (int i = 1; i < boardService.getStack().size(); i++) {
            deck2.add(new Card(i,boardService.getStack().get(i).getImage(),i*20));
        }
        model.addAttribute("deck",deck2);
        model.addAttribute("trumpCard",deck.get(0));
        model.addAttribute("playerCards",playerCards);
        return "board";
    }

    @GetMapping("/shuffle")
    String getShuffle(Model model){
        List<Card> deck = boardService.getStack();
        boardService.shuffleDeck(deck);
        List<Card> deck2 = new ArrayList<>();
        List<Card> playerCards = new ArrayList<>();
        for (int i = 1; i < boardService.getStack().size(); i++) {
            deck2.add(new Card(i,boardService.getStack().get(i).getImage(),i*20));
        }
        model.addAttribute("deck",deck2);
        model.addAttribute("trumpCard",deck.get(0));
        model.addAttribute("playerCards",playerCards);
        return "board";
    }


}
