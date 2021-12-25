package banan.edu.service;

import banan.edu.model.Card;
import banan.edu.model.Deck;
import banan.edu.model.Suit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {
    private Deck deck = new Deck();

    @Override
    public Card shuffleDeck() {
        return null;
    }

    @Override
    public List<Card> getStack() {
        List<Card> cards = deck.getDeck();
        return cards;
    }

    @Override
    public List<Card> getPlayerCard() {
        return null;
    }

    @Override
    public List<Card> getDealerCard() {
        return null;
    }

    @Override
    public List<Card> getPlayerMoves() {
        return null;
    }

    @Override
    public List<Card> getDealerMoves() {
        return null;
    }

    @Override
    public List<Card> getTrash() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean getTurn() {
        return false;
    }

    @Override
    public Suit getTrump() {
        return null;
    }
}
