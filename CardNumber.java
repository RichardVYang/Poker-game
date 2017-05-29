package com.yang.warrior.com.yang.warrior.poker;

/**
 * Created by richardyang on 3/25/12.
 */
public enum CardNumber {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int cardNumber;

     CardNumber(int cardNumber) { // Need to have default (no access provided) or private (is redundant) constructor to compile successfully.
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

}
