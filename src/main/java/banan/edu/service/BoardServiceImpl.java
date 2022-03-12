package banan.edu.service;

import banan.edu.model.Board;
import banan.edu.model.Card;
import banan.edu.model.Deck;
import banan.edu.model.Suit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements IBoardService {
    private Deck deck;
    private Board board;

    public BoardServiceImpl() {
        deck = new Deck();
        List<Card> deckCopy = new ArrayList<>(deck.getDeck());
        board = new Board();
        board.setMessage("");
        shuffleDeck(deckCopy);
        board.getStack().addAll(deckCopy);

    }
// привіт світ
    @Override
    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
        board.setTrump(deck.get(0).getSuit());
        board.setTrumpCard(deck.get(0)); //
    }

    @Override
    public List<Card> getStack() {
        List<Card> cards = board.getStack();
        return cards;
    }

    @Override
    public List<Card> getPlayerCards() {
        return board.getPlayerCards();
    }

    @Override
    public List<Card> getDealerCards() {
        return board.getDealerCards();
    }

    @Override
    public List<Card> getPlayerMoves() {
        return board.getPlayerMoves();
    }

    @Override
    public List<Card> getDealerMoves() {
        return board.getDealerMoves();
    }

    @Override
    public List<Card> getTrash() {
        return null;
    }

    @Override
    public String getMessage() {
        return board.getMessage();
    }

    @Override
    public boolean getTurn() {
        if(getStack().size()==40 && getPlayerCards().size()==6 && getDealerCards().size()==6){
            Card dealercard = getDealerCards().stream().filter(el->el.getSuit().equals(getTrump()))
                    .min(Comparator.comparing(Card::getValue)).orElse(null);
            Card playercard = getPlayerCards().stream().filter(el->el.getSuit().equals(getTrump()))
                    .min(Comparator.comparing(Card::getValue)).orElse(null);
            if(dealercard == null && playercard == null){
                board.setTurn(true);
                return board.isTurn();

            }
            if(dealercard == null && playercard != null){
                board.setTurn(true);
                return board.isTurn();

            }
            if(dealercard != null && playercard == null){
                board.setTurn(false);
                return board.isTurn();

            }
            if(playercard.getValue() > dealercard.getValue()){
               board.setTurn(false);
            }else{
               board.setTurn(true);
            }

        }
        return board.isTurn();
    }
    void setTurn(boolean turn){
        board.setTurn(turn);
    }

    @Override
    public Suit getTrump() {
        return board.getTrump();
    }
    public Card getTrumpCard() {
        return board.getTrumpCard();
    }

    public void rechargeCards() {
        board = new Board();
        board.setMessage("");
        List<Card> deckCopy = new ArrayList<>();
        deckCopy.addAll(deck.getDeck());
        shuffleDeck(deckCopy);
        board.getStack().addAll(deckCopy);
        }

    public void setMessage(String text){
        board.setMessage(text);
    }

}
