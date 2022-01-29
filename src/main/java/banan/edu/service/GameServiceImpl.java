package banan.edu.service;

import banan.edu.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements IGameService {

    public static void makeMove(int cardId, List<Card> playerCards, List<Card> playerMoves) {
        Card card = playerCards.get(cardId);
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

    @Override
    public List<Card> giveCards() {
        return null;
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
