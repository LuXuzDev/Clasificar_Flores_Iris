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
    
    private static String password = "admin";
    

    public static boolean isCorrectInput(String input)
    {
        boolean correct=true;
        if(input.trim().isEmpty() || containsLetter(input))
            correct=false;
        else
        {
            double num = Double.parseDouble(input);
            if(num<=0 || num>=10)
                correct=false;
        }
        return correct;
    }
    
    
    private static boolean containsLetter(String input)
    {
        boolean letter = false;
        char[] array = input.toCharArray();
        for(int i=0;i<input.length();i++)
        {
            if(Character.isAlphabetic(array[i]))
                letter=true;
        }
        return letter;
    }
    
    
    private static boolean containsNumber(String input)
    {
        boolean number = false;
        char[] array = input.toCharArray();
        for(int i=0;i<input.length();i++)
        {
            if(Character.isDigit(array[i]))
                number=true;
        }
        return number;
    }
    
    
    public static boolean checkPassword(String input)
    {
        boolean isCorrect = true;
        if(!input.equals(password))
            isCorrect=false;
        return isCorrect;
    }
    
    
    public static boolean isCorrectFile(String file){
        
        boolean isCorrect = true;
        if(file.trim().isEmpty() || file == null)
            isCorrect=false;
        return isCorrect;
    }
    
}
