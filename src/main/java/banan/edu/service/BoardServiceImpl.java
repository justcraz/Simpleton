package banan.edu.service;

import banan.edu.model.Board;
import banan.edu.model.Card;
import banan.edu.model.Deck;
import banan.edu.model.Suit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {
    private Deck deck;
    private Board board;

    public BoardServiceImpl() {
        deck = new Deck();
        List<Card> deckCopy = new ArrayList<>(deck.getDeck());
        board = new Board();
        shuffleDeck(deckCopy);
        board.getStack().addAll(deckCopy);
    }

    @Override
    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    @Override
    public List<Card> getStack() {
        List<Card> cards = board.getStack();
        return cards;
    }

    @Override
    public List<Card> getPlayerCards() {
        int playerHasCards = board.getPlayerCards().size();
        int mustGivetoPlayer = 6 - playerHasCards;
        if(playerHasCards < 6){
            for (int i = 0; i <mustGivetoPlayer ; i++) {
                Card card = board.getStack().pop();
                board.getPlayerCards().add(card);
            }
        }
        return board.getPlayerCards();
    }

    @Override
    public List<Card> getDealerCards() {
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
