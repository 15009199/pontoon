/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.helloworld;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author 15009199
 */
public class Keyboard {
    
    Scanner keyboard;
    private String inputString;
    private char character;
    private int number;
    private double doubleNumber;
    private boolean bool;
    
    public Keyboard() {
        keyboard = new Scanner(System.in);
    }
    
    public void enterToContinue() {
        this.getString();
    }

    public Scanner getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Scanner keyboard) {
        this.keyboard = keyboard;
    }
    
    public String getString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        
        try {
            inputString = reader.readLine();
        } catch(IOException e) {
            System.out.println(e);
        }
        
        return inputString;
    }

    public String getString(String prompt) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        
        try {
            inputString = reader.readLine();
        } catch(IOException e) {
            System.out.println(e);
        }
        
        return inputString;
    }

    public void setString(String inputString) {
        this.inputString = inputString;
    }

    public char getCharacter(String prompt) {
        String input = "";
        char temp_char = ' ';
        System.out.println(prompt);
        input = keyboard.next();
        temp_char = input.charAt(0);
        return temp_char;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getInt(String prompt) {
        int temp_int = 0;
        System.out.println(prompt);
        temp_int = keyboard.nextInt();
        return temp_int;
    }

    public void setInt(int number) {
        this.number = number;
    }

    public double getDoubleNumber() {
        return doubleNumber;
    }

    public void setDoubleNumber(double doubleNumber) {
        this.doubleNumber = doubleNumber;
    }

    public boolean getBool(String prompt) {
        boolean temp_bool = false;
        System.out.println(prompt);
        String temp = getString();
        temp_bool = (temp.equals("true"));
        return temp_bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
    
    
    
    
    
    
    
}
