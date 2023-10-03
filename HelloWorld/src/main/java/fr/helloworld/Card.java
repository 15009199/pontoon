/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.helloworld;

/**
 *
 * @author anonim
 */
public class Card {
    
    private enum Type {
    ACE, // 11 OR 1 POINT
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    KING, // 10 POINTS
    QUEEN, // 10 POINTS
    JACK // 10 POINTS
    }
    
    private Type type;
    private int value;
    
    public Card() {
        getRandomType();
        setValue();
    }
    
    public Card(Type type) {
        this.type = type;
        setValue();
    }
    
    private void getRandomType() {
        this.type = Type.values()[(int)(Math.random()*Type.values().length)]; // random card from enum
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue() {
        switch (getType()) {
        case ACE:
            this.value = 1;
            break;
        case TWO:
            this.value = 2;
            break;
        case THREE:
            this.value = 3;
            break;
        case FOUR:
            this.value = 4;
            break;
        case FIVE:
            this.value = 5;
            break;
        case SIX:
            this.value = 6;
            break;
        case SEVEN:
            this.value = 7;
            break;
        case EIGHT:
            this.value = 8;
            break;
        case NINE:
            this.value = 9;
            break;
        case TEN:
            this.value = 10;
            break;
        case KING:
            this.value = 10;
            break;
        case QUEEN:
            this.value = 10;
            break;
        case JACK:
            this.value = 10;
            break;
        default:
            this.value = 0;
            break;
        }
    } 
}
