package banan.edu.service;

import banan.edu.model.Card;
import banan.edu.model.Denomination;
import banan.edu.model.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameServiceImplTest {

    BoardServiceImpl boardService = new BoardServiceImpl();
    GameServiceImpl gameService = new GameServiceImpl();
    List<Card> cards = new ArrayList<>(
            Arrays.asList(
                    new Card (5,Suit.CLUB , Denomination.SEVEN , 7, "/image/C7.png"),
                    new Card (9,Suit.CLUB , Denomination.JACK , 11, "/image/CJ.png"),
                    new Card (10,Suit.CLUB , Denomination.QUEEN , 12, "/image/CQ.png"),
                    new Card (11,Suit.CLUB , Denomination.KING , 13, "/image/CK.png"),
                    new Card (12,Suit.CLUB , Denomination.ACE , 14, "/image/CA.png")));

    @Test
    public void WhenListThenLastCardAceClub() {
        Assert.assertEquals(gameService.takeLastCard(cards),cards.get(4));

    }

    @Test
    public void isItPosible() {
        int cardId = 5;
        Suit trump = Suit.HEART;
        List<Card> dealerMoves = new ArrayList<>(Arrays.asList(new Card (24,Suit.HEART , Denomination.KING , 13, "/image/HK.png")));
        Assert.assertFalse(gameService.isItPosible(cardId,cards,dealerMoves,trump));

    }
}