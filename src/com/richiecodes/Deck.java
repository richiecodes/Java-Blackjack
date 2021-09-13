package com.richiecodes;

import java.util.*;

public class Deck {
    public final String[] VALID_VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
    public final String[] VALID_SUITS = {"Diamonds", "Hearts", "Spades", "Clubs"};
    private List<Card> deck;
    Random rand;

    public Deck() {
        rand = new Random();
        deck = new ArrayList<>();
        buildDeck();
    }

    public void buildDeck() {
        for (String suit : VALID_SUITS) {
            for (String value : VALID_VALUES) {
                deck.add(new Card(value, suit));
            }
        }

        Collections.shuffle(deck);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void printDeck() {
        System.out.println(deck);
    }

    public void drawFiveRandomCards() {
        List<Card> fiveCards = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            fiveCards.add(getRandomCard());
            deck.remove(fiveCards.get(i));
            System.out.println("Removed " + fiveCards.get(i) + " from deck");
            System.out.println(fiveCards.get(i));
        }

    }

    private Card getRandomCard() {
        return deck.get(rand.nextInt(deck.size()));
    }
}
