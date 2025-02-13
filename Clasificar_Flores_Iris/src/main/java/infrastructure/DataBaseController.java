/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 *
 * @author Angel Hernandez
 */
public class DataBaseController {
    private ArrayList<File> files;

    
    public DataBaseController()
    {
        files=new ArrayList<>();
        String filePath1 = "C:\\Users\\Angel Hernandez\\Documents\\WorkSpace\\JAVA\\Clasificar_Flores_Iris\\Clasificar_Flores_Iris\\src\\main\\java\\dataBase\\irsi.data";
        String filePath2 = "C:\\Users\\Angel Hernandez\\Documents\\WorkSpace\\JAVA\\Clasificar_Flores_Iris\\Clasificar_Flores_Iris\\src\\main\\java\\dataBase\\pruebaAdrian.data";

        
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);

        files.add(file1);
        files.add(file2);   
    }
}
