
import Controller.SopaDeLetras;
import java.io.FileNotFoundException;
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
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Archivo archivo = new Archivo();
        String texto = archivo.leerArchivo("INPUT.TXT");
              
        SopaDeLetras sopaDeLetras = new SopaDeLetras(texto);
        sopaDeLetras.Evaluar();
            
    }
}
