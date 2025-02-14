/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;

import javax.swing.JList;

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
    
    
    public static boolean containsNumber(String input)
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
    
    //validacion que revisa si el contador de ficheros sea menor que 0
    public static boolean checkNumber(int check)
    {
        boolean retorno=false;
        if(check<=0)
        {
            retorno = true;
        }
        return retorno;
    }
    //validacion que revisa si la lista en databasemenu tiene seleccionado algun valor
    public static boolean checkList(JList list)
    {
        boolean retorno=false;
        if(list.getSelectedValue()!=null)
        {
            retorno=true;
        }
        
        return retorno;
    }
    
    public static boolean checkPassword(String input)
    {
        boolean isCorrect = true;
        if(!input.equals(password))
            isCorrect=false;
        return isCorrect;
    }
}
