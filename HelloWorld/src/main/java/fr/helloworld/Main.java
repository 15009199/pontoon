/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.helloworld;

import java.util.*;
import java.io.*;

/**
 *
 * @author anonim
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
        Keyboard kb = new Keyboard();
        
        String name = kb.getString("Enter your name: ");
        System.out.println("Hello "+name);
        
        int age = kb.getInt("Enter your age: ");
        System.out.println("You are "+age+" years old.");
        
        boolean isStudent = kb.getBool("Are you a student? (true/false): ");
        System.out.println("Student: "+isStudent);
        
        Scanner kboard = new Scanner(System.in);
        int number = 0;
        
        try {
            System.out.println("Enter an int:");
            number = kboard.nextInt();
            
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter an integer.");
        } finally {
            kboard.close();
        }
        
        
        
        String choice = "";
        
        Player local = new Player();
        Dealer house = new Dealer();
        
        for (int i = 0; i < 2; i++) { // create starting cards for both players
            local.getHand().generateCard();
            house.getHand().generateCard();
            
            System.out.println("Player draws: ["+local.getHand().cards.get(i).getValue()+"]");
            System.out.println("House draws: ["+house.getHand().cards.get(i).getValue()+"]");
        }
        
        System.out.println("TOTAL: Player ["+local.getHand().getValue()+"] : ["+house.getHand().getValue()+"] House");
        
        System.out.println("Do you wish to draw a card (y/n)?");
        choice = kboard.next();
        
        while (choice.equalsIgnoreCase("y")) {
            local.getHand().generateCard();
            house.getHand().generateCard();
            
            // get the newest card in player's hand
            // https://stackoverflow.com/questions/687833/how-to-get-the-last-value-of-an-arraylist
            if (local.getHand().cards != null && !local.getHand().cards.isEmpty()) {
                System.out.println("Player draws: ["+local.getHand().cards.get(local.getHand().cards.size()-1).getValue()+"]");
            }
            
            if (house.getHand().cards != null && !house.getHand().cards.isEmpty()) {
                System.out.println("House draws: ["+house.getHand().cards.get(local.getHand().cards.size()-1).getValue()+"]");
            }
            
            System.out.println("TOTAL: Player ["+local.getHand().getValue()+"] : ["+house.getHand().getValue()+"] House");
            
            // end the game when a player goes bust
            if (bustedCheck(local, house)) {
                break;
            }
            
            System.out.println("Do you wish to draw a card (y/n)?");
            choice = kboard.next();
            
        }
        
        if (!bustedCheck(local, house)) { // if not ended in a bust
            resultCheck(local, house); // get the winner
        }
    }
    
    
    
    public static boolean bustedCheck(Player local, Player house) {
        if (local.getHand().getValue() > 21) {
            System.out.println("You went over the limit (21)");
            System.out.println("You lost");
            return true;
        } else if (house.getHand().getValue() > 21) {
            System.out.println("House went over the limit (21)");
            System.out.println("You won!");
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean resultCheck(Player local, Player house) {
        if (local.getHand().getValue() >= 19) {
            if (house.getHand().getValue() > local.getHand().getValue()) {
                System.out.println("House has better score");
                System.out.println("You lost");
                return false;
            } else if (house.getHand().getValue() == local.getHand().getValue()) {
                System.out.println("You and the house have the same score");
                System.out.println("You lost");
                return false;
            } else {
                System.out.println("You won!");
                return true;
            }
        } else {
            System.out.println("Your score is below 19");
            System.out.println("You lost");
            return false;
        }   
    }
}
