package banan.edu.service;

import banan.edu.model.Card;
import banan.edu.model.Denomination;
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
        if(boardService.getPlayerMoves().size() == 0) {
            playerMoves.add(card);
            playerCards.remove(card);
        }else {
            List<Card> cardsInAction = new ArrayList<>();
            cardsInAction.addAll(boardService.getPlayerMoves());
            cardsInAction.addAll(boardService.getDealerMoves());
            List<Denomination> denominationsInAction =
                    cardsInAction.stream()
                            .map(el -> el.getDenomination())
                            .collect(Collectors.toList());
            Denomination cardDenomination = card.getDenomination();
            if (denominationsInAction.contains(cardDenomination)) {
                playerMoves.add(card);
                playerCards.remove(card);
            }
        }
    }

    @Override
    public Card dealerMove() {
        Card dealerAttack = boardService.getDealerCards().stream().min(Comparator.comparing(Card::getValue)).get();
        boardService.getDealerCards().remove(dealerAttack);
        boardService.getDealerMoves().add(dealerAttack);
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

        if (playerMoves.size() == boardService.getDealerMoves().size()){
            return;
        }

        List<Card> trumps = boardService.getDealerCards().stream()
                .filter(el->el.getSuit().equals(boardService.getTrump()))
                .filter(el->el.getValue()>cardAttack.getValue())
                .collect(Collectors.toList());
        List<Card> suits = boardService.getDealerCards().stream()
                .filter(el->el.getSuit().equals(cardAttack.getSuit()))
                .filter(el->el.getValue()>cardAttack.getValue()).collect(Collectors.toList());

        List<Card> listDeffence = new ArrayList<>();
        listDeffence.addAll(trumps);
        listDeffence.addAll(suits);
        Card cardAsDeffence;
        if(listDeffence.isEmpty()){
            cardAsDeffence = null;
        }else{
            cardAsDeffence = listDeffence.stream().min(Comparator.comparing(Card::getValue)).get();
        }
        if(cardAsDeffence != null && cardAsDeffence.getValue() > cardAttack.getValue()){
            boardService.getDealerCards().remove(cardAsDeffence);
            boardService.getDealerMoves().add(cardAsDeffence);
        }else{
            boardService.getDealerCards().addAll(playerMoves);
            boardService.getDealerCards().addAll(boardService.getDealerMoves());
            boardService.getDealerMoves().removeAll(boardService.getDealerMoves());
            boardService.getPlayerMoves().removeAll(boardService.getPlayerMoves());
        }
    }

    public void giveCards() {
        int playerHasCards = boardService.getPlayerCards().size();
        int mustGivetoPlayer = 6 - playerHasCards;
        if(playerHasCards < 7 && !boardService.getStack().isEmpty()){
            for (int i = 0; i <mustGivetoPlayer ; i++) {
                Card card = boardService.getStack().get(boardService.getStack().size()-1);
                if(card.getSuit().equals(boardService.getTrump())){
                    card.setValue(card.getValue()+13);
                }
                boardService.getStack().remove(card);
                boardService.getPlayerCards().add(card);
            }
            boardService.getPlayerCards().sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue));
        }
    }

    public void giveCardsToDealer() {
        int dealerHasCards = boardService.getDealerCards().size();
        int mustGivetoDealer = 6 - dealerHasCards;
        if(dealerHasCards < 7 && !boardService.getStack().isEmpty()){
            for (int i = 0; i <mustGivetoDealer ; i++) {
                Card card = boardService.getStack().get(boardService.getStack().size()-1);
                if(card.getSuit().equals(boardService.getTrump())){
                    card.setValue(card.getValue()+13);
                }
                boardService.getStack().remove(card);
                boardService.getDealerCards().add(card);
            }
            boardService.getDealerCards().sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue));
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
