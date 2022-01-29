package banan.edu.service;

import banan.edu.model.Card;
import banan.edu.model.Suit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    BoardServiceImpl boardService;

    public void makeMove(int cardId, List<Card> playerCards, List<Card> playerMoves) {
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
    public void dealerDefence() {
        List<Card> playerMoves = boardService.getPlayerMoves();
        Card cardAttack = playerMoves.get(playerMoves.size()-1);

        List<Card> trumps = boardService.getDealerCards().stream()
                .filter(el->el.getSuit().equals(boardService.getTrump())).collect(Collectors.toList());

        trumps.forEach(el->el.setValue(el.getValue()+13));

        List<Card> suits = boardService.getDealerCards().stream()
                .filter(el->el.getSuit().equals(cardAttack.getSuit()))
                .filter(el->el.getValue()>cardAttack.getValue()).collect(Collectors.toList());

        List<Card> listDeffence = new ArrayList<>();
        listDeffence.addAll(trumps);
        listDeffence.addAll(suits);

        Card cardAsDeffence = listDeffence.stream().min(Comparator.comparing(Card::getValue)).get();
        if(cardAsDeffence != null){
            boardService.getDealerCards().remove(cardAsDeffence);
            boardService.getDealerMoves().add(cardAsDeffence);
        }
        System.out.println(trumps);
        System.out.println("__________");
        System.out.println(listDeffence);
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
        boardService.getDealerMoves().removeAll(boardService.getDealerMoves());
        boardService.getPlayerMoves().removeAll(boardService.getPlayerMoves());
        return null;
    }

    @Override
    public List<Card> giveUpAndTakeCards() {
        return null;
    }
}
