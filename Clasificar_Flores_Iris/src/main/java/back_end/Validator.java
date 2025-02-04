/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;

/**
 *
 * @author Angel Hernandez
 */
public class Validator {
    
    private String password;
    
    public Validator(String password)
    {
        this.password = password;
    }
    
    public boolean isCorrectInput(String input)
    {
        boolean correct=true;
        if(input.trim().isEmpty() || isLetter(input))
            correct=false;
        return correct;
    }
    
    
    private boolean isLetter(String input)
    {
        boolean letter = true;
        char[] array = input.toCharArray();
        for(int i=0;i<input.length();i++)
        {
            if(Character.isDigit(array[i]))
                letter=false;
        }
        return letter;
    }
    
    
    private boolean isNumber(String input)
    {
        boolean number = true;
        char[] array = input.toCharArray();
        for(int i=0;i<input.length();i++)
        {
            if(Character.isAlphabetic(array[i]))
                number=false;
        }
        return number;
    }
    
    
    public boolean checkPassword(String input)
    {
        boolean isCorrect = true;
        if(!input.equals(password))
            isCorrect=false;
        return isCorrect;
    }
    
}
