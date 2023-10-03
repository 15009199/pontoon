/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.helloworld;

import java.util.ArrayList;

/**
 *
 * @author anonim
 */
public class Hand {
    
    ArrayList<Card> cards;
    int value;
    
    public Hand() {
        cards = new ArrayList<>();
        value = 0;
    }
    
    public void generateCard() {
        Card card = new Card();
        addCard(card);
    }
    
    public void addCard(Card card) {
        setValue(getValue() + card.getValue()); // add hand total and new card together
        cards.add(card); // store the new card in the list
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    
    
    
}
