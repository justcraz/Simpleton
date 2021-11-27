package banan.edu.service;

import banan.edu.model.Card;
import banan.edu.model.Suit;

import java.util.List;

public interface IBoardService {
    Card shuffleDeck();
    List<Card> getStack();
    List<Card> getPlayerCard();
    List<Card> getDealerCard();
    List<Card> getPlayerMoves();
    List<Card> getDealerMoves();
    List<Card> getTrash();
    String getMessage();
    boolean getTurn();
    Suit getTrump();
}
