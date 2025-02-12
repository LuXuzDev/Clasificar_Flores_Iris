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
    

    public static boolean isCorrectInputOnlyNumbers(String input)
    {
        boolean correct=true;
        if(isEmptyInput(input) || containsLetter(input))
            correct=false;
        else
        {
            double num = Double.parseDouble(input);
            if(num<=0 || num>=10)
                correct=false;
        }
        return correct;
    }
    
    
    public static boolean isEmptyInput(String input){return input.trim().isEmpty();}
    
    
    private static boolean containsLetter(String input)
    {
        boolean letter = false;
        
        try
        {
            Double.parseDouble(input);
        }catch(Exception e)
        {
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
}
