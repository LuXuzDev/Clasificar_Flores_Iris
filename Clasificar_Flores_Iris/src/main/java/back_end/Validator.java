/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.ArrayList;

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
    
    //funcion q valida q el model de un jlist sea instancia de defautlJlistmodel
    public static boolean ListInstanceOf(JList list)
    {
        boolean check=false;
        if(list.getModel() instanceof DefaultListModel)
        {
            check=true;
        }
        return check;
    }
    
    //funcion para validar q el usuario eligio un archivo
    public static boolean aprooveJfilechooser(int option)
    {
        boolean check=false;
        if(option == JFileChooser.APPROVE_OPTION)
        {
            check=true;
        }
        return check;
    }
    
    
    //validar el maximo de archivos modificados en el dataset
    public static void MaxTam(ArrayList<String> array) throws Exception
    {
        
        if((array.size()+1)>=160)
            throw new Exception("Alcanzo el limite de modificaciones");
    }
    
    
    //validar en un joption pane q el usuario selecciono si
    public static boolean YesOptionJOption(int result)
    {
        boolean check=false;
        if(result == JOptionPane.YES_OPTION)
        {
            check=true;
        }
        return check;
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
    
    public static File existFile(File file) throws Exception
    {
        if(file==null)
            throw new Exception("El archivo no existe");
        return file;
    }
}
