package com.yang.warrior.com.yang.warrior.poker;

import java.util.*;

/**
 * Created by richardyang on 3/25/12.
 */
public class Deck {

    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>(13);

        for (int cardIndex = 0; cardIndex < 13; cardIndex++) {
            CardNumber cardNumber = CardNumber.values()[cardIndex];

            for (int suitIndex = 0; suitIndex < 4; suitIndex++) {
                Suit suit = Suit.values()[suitIndex];
                Card card = new Card(cardNumber, suit);
                this.deck.add(card);
            }
        }

        System.out.println("************* Before Collections.shuffle()");
        displayCard();

        Collections.shuffle(deck);
        System.out.println("************* After Collections.shuffle()");
        displayCard();

    }

    private void displayCard() {


        deck.forEach(card -> System.out.println("Card Number: " + card.getCardNumber() + " Suit: " + card.getSuit()));

        /*
        for (Card card : deck) {
            System.out.println("Card Number: " + card.getCardNumber() + " Suit: " + card.getSuit());
        }
        */
    }

    public Card draw(int randomCardIndex) {
        if ((randomCardIndex >= 0) && (randomCardIndex <= 12)) {
          //  return deck.get(randomCardIndex);
            return deck.remove(randomCardIndex);
        }

        System.out.println("Card index is out of range: " + randomCardIndex);
        return null; //TODO  implement me later
    }

    public Card draw() {
        return deck.remove(0); // remove the top card!
    }

}
