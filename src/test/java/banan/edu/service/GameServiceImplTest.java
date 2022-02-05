package banan.edu.service;

import banan.edu.model.Card;
import banan.edu.model.Denomination;
import banan.edu.model.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameServiceImplTest {

    BoardServiceImpl boardService = new BoardServiceImpl();
    GameServiceImpl gameService = new GameServiceImpl();

    @org.junit.Test
    public void testTHEFIRSTMOVE() {
//        gameService.giveCards();
        List<Card> playerCards = new ArrayList<>(
                Arrays.asList(
                        new Card (12, Suit.CLUB , Denomination.ACE , 14, "/image/CA.png"),
                        new Card (14,Suit.HEART , Denomination.THREE , 3, "/image/H3.png"),
                        new Card (25,Suit.HEART , Denomination.ACE , 14, "/image/HA.png"),
                        new Card (38,Suit.SPADE , Denomination.ACE , 14, "/image/PA.png"),
                        new Card (47,Suit.DIAMOND , Denomination.TEN , 10, "/image/T10.png"),
                        new Card (5,Suit.CLUB , Denomination.SEVEN , 7, "/image/C7.png")));
        List<Card> playerMoves = new ArrayList<>();
        List<Card> dealerMoves = new ArrayList<>();


        gameService.makeMove(5,playerCards,playerMoves);
        Card card = playerMoves.get(0);
        System.out.println(card);

    }
}