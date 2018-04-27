
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Metztoamm
 */
public class Archivo {
    //File file;
    
    public String leerArchivo(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File file = new File(path);
                
        FileReader reader = new FileReader(file);
        
        String texto = "";
        int caracter = 0;
        char c;
        
        while(caracter!=-1){
            caracter = reader.read();
            
            c = (char) caracter;
            
            if(caracter!=-1)
                texto = texto.concat(String.valueOf(c));
            
        }
        
        return texto;
        
    }
    
    public File escribirArchivo(String path, String texto) throws FileNotFoundException, IOException{
        
         File file = new File(path);
       
          try ( //crear un archivo
                FileWriter writer = new FileWriter(file) //pide un file, input output error
          ) {
            
            writer.append(texto);
          }

        return file;
    }
   
    
    public void appendText(File file, String texto) throws FileNotFoundException, IOException{
    

          try ( //crear un archivo
                FileWriter writer = new FileWriter(file) //pide un file, input output error
          ) {
            //writer.append("Hola mundo \r\nSalto de linea\r\n");
            writer.append(texto);
          }
    }
    
}


