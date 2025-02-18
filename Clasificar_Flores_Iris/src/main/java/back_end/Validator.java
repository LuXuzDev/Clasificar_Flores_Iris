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
    
    //Atributos
    private static String password = "admin";
    private static int maxRegisterInFile =160;
    

    //Metodo que revisa que la entrada solo sea numeros
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
    
    
    //Metodo que revisa que la entrada solo sea letras
    public static boolean isCorrectInputOnlyLetter(String input)
    {
        boolean correct=true;
        if(isEmptyInput(input) || containsNumber(input) || containsEspecialCharacters(input))
            correct=false;

        return correct;
    }
    
    
    //Metodo que devuelve si la entrada esta vacia o solo compuesta por espacios
    public static boolean isEmptyInput(String input){return input.trim().isEmpty();}
    
    
    //Metodo que revisa si la entrada contiene letras
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
    
    
    //Metodo que revisa si la entrada contiene caracteres especiales
    private static boolean containsEspecialCharacters(String input) {
        String regex = ".*[^a-zA-Z0-9].*";
        return input.matches(regex);
    }

    
    //Metodo que revisa que el model de un jlist sea instancia de defautlJlistmodel
    public static boolean ListInstanceOf(JList list)
    {
        boolean check=false;
        if(list.getModel() instanceof DefaultListModel)
        {
            check=true;
        }
        return check;
    }
    
    
    //Metodo para validar que el usuario eligio un archivo
    public static boolean aprooveJfilechooser(int option)
    {
        boolean check=false;
        if(option == JFileChooser.APPROVE_OPTION)
        {
            check=true;
        }
        return check;
    }
    
    
    //Metodo para validar el maximo de archivos modificados en el dataset
    public static void MaxTam(ArrayList<String> array) throws Exception
    {
        if((array.size()+1)>=maxRegisterInFile)
            throw new Exception("Alcanzo el limite de modificaciones");
    }
    
    
    //Metodo para revisar en un joption pane el usuario selecciono si
    public static boolean YesOptionJOption(int result)
    {
        boolean check=false;
        if(result == JOptionPane.YES_OPTION)
        {
            check=true;
        }
        return check;
    }
    
    
    //Metodo para revisar si la entrada contiene numeros
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
    
    
    //Metodo que revisa si la lista en databasemenu tiene seleccionado algun valor
    public static boolean checkList(JList list)
    {
        boolean retorno=false;
        if(list.getSelectedValue()!=null)
        {
            retorno=true;
        }
        
        return retorno;
    }
    
    
    //Metodo que revisa si la contraseña es correcta
    public static boolean checkPassword(String input)
    {
        boolean isCorrect = true;
        if(!input.equals(password))
            isCorrect=false;
        return isCorrect;
    }
    
    
    //Metodo que revisa si existe el fichero
    public static File existFile(File file) throws Exception
    {
        if(file==null)
            throw new Exception("El archivo no existe");
        return file;
    }
    
    
    //Metodo para validar que halla dataset cargados
    public static void loadedDataSet() throws Exception
    {
        if(Controller.getInstance().getDataSetLoaded()==null)
            throw new Exception("No hay dataset cargado");
    }
    
    
    //Metodo para validar que halla un entrenamiento cargado
    public static void loadedTrainner() throws Exception
    {
        if(!Controller.getInstance().isLoadedTrain())
            throw new Exception("No hay entrenamiento cargado");
    }
}
