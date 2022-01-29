package banan.edu.service;

import banan.edu.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    BoardServiceImpl boardService;

    public static void makeMove(int cardId, List<Card> playerCards, List<Card> playerMoves) {
        Card card = playerCards.stream().filter(el->el.getId()==cardId).findFirst().get();
        playerMoves.add(card);
        playerCards.remove(card);
    }

    @Override
    public Card dealerMove() {
        return null;
    }

    @Override
    public Card myDefence() {
        return null;
    }

    @Override
    public Card dealerDefence() {
        return null;
    }

    public void giveCards() {
        int playerHasCards = boardService.getPlayerCards().size();
        int mustGivetoPlayer = 6 - playerHasCards;
        if(playerHasCards < 7){
            for (int i = 0; i <mustGivetoPlayer ; i++) {
                Card card = boardService.getStack().get(boardService.getStack().size()-1);
                boardService.getStack().remove(card);
                boardService.getPlayerCards().add(card);
            }
        }
    }

    @Override
    public Card rechargeCards() {
        return null;
    }

    @Override
    public List<Card> moveToTrash() {
        return null;
    }

    @Override
    public List<Card> giveUpAndTakeCards() {
        return null;
    }
}
