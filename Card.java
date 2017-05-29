package com.yang.warrior.com.yang.warrior.poker;

/**
 * Created by richardyang on 3/25/12.
 */
public class Card {

    private Suit suit;
    private CardNumber cardNumber;


    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card(CardNumber cardNumber, Suit suit) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

}
