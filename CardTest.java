package com.yang.warrior.com.yang.warrior.poker;

import java.util.*;

/**
 * Created by richardyang on 3/25/12.
 */


public class CardTest {

    public static void main(String... args) {

        CardTest ct = new CardTest();

        int numberOfPlayer = 3;
        int numberOfDraw = 5;
        ct.play(numberOfPlayer, numberOfDraw);
    }

    private void play(int numberOfPlayer, int numberOfDraw) {
        int maxCard = 13;
        int min = 0;

        Deck deck = new Deck();

        Map<Integer, List<Card>> players = new HashMap<>(numberOfPlayer);

        for (int cardRoundNumber = 0; cardRoundNumber < numberOfDraw; cardRoundNumber++) {

            for (int playerNumber = 0; playerNumber < numberOfPlayer; playerNumber++) {

             //   int randomCardNumber = (int) (Math.random() * (maxCard - min)) + min;
             //   Card card = deck.draw(randomCardNumber);
                Card card = deck.draw();

                List<Card> cards = players.get(playerNumber) == null ?  new ArrayList<>() : players.get(playerNumber);

                cards.add(card);
                players.put(playerNumber, cards);

            }
        }

        displayAllPlayersWithTheirCards(players);

    }

    private void displayAllPlayersWithTheirCards(Map<Integer, List<Card>> players) {

        players.forEach((key, cards) -> {

            for (Card card : cards) {
                System.out.println("Person number: " + key + " Card number: " + card.getCardNumber() + " Suit: " + card.getSuit());
            }

        });

        /*
        for (Map.Entry<Integer, List<Card>> player : players.entrySet()) {
            List<Card> cards = player.getValue();

            for (Card card : cards) {
                System.out.println("Person number: " + player.getKey() + " Card number: " + card.getCardNumber() + " Suit: " + card.getSuit());
            }
        }

        */
    }


}
