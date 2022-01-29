package banan.edu.service;

import banan.edu.model.Card;

import java.util.List;

public interface IGameService {
    Card dealerMove();
    Card myDefence();
    Card dealerDefence();
    Card rechargeCards();
    List<Card> moveToTrash();
    List<Card> giveUpAndTakeCards();
}
