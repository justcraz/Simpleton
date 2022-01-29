package banan.edu.service;

import banan.edu.model.Card;

import java.util.List;

public interface IGameService {
    // void makeMove(int cardId, List<Card> playerCards, List<Card> playerMoves);
    Card dealerMove();
    Card myDefence();
    Card dealerDefence();
    List<Card> giveCards();
    Card rechargeCards();
    List<Card> moveToTrash();
    List<Card> giveUpAndTakeCards();
}
