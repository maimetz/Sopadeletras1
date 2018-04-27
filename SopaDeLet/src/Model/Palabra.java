/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Status.DIAGONAL;
import static Model.Status.ERROR;
import static Model.Status.HORIZONTAL;
import static Model.Status.VERTICAL;

/**
 *
 * @author Metztoamm */
public class Palabra {
    Palabra next;
    
    char[] cadena;
    String palabra;
    Origen origen;
    Status status;
    
    ListaOrigenes listaOrigenes;

    public Palabra(char[] cadena){
        this.cadena = cadena;
        this.origen = new Origen(0,0);
        this.status = ERROR;
        
        palabra = "";
        for(int i=0; i<cadena.length; i++){
            palabra = palabra.concat(String.valueOf(cadena[i]));
        }
        
    }

    public Palabra getNext() {
        return next;
    }
    
    public void setNext(Palabra next) {
        this.next = next;
    }

    public Status getStatus() {
        return status;
    }
    
    
    public char getChar(Integer n){
        return cadena[n];
    }
    
    public void IdentificarOrigenes(Integer n, Integer m, char[][] grid){//n columnas, m filas 
        listaOrigenes = new ListaOrigenes();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == cadena[0]){
                    this.listaOrigenes.append(new Origen(i,j));
                }//i es x, j es de las y's
            }
        }
    }
    
    public void Resolver(Integer dimX, Integer dimY, char[][] grid){
        Origen current = listaOrigenes.getHead();

        while(current!=null){
            
            int hDer   = 0;
            int hIzq   = 0;
            int vNorte = 0;
            int vSur   = 0;
            int dSE    = 0;
            int dNO    = 0;
            
            Integer[] x = new Integer[6];
            Integer[] y = new Integer[6];
            
            for(int i=0; i<cadena.length; i++){
                //Horizontal derecha 
                if(isValid(dimX, dimY, current.getX()+i, current.getY())){
                    if(cadena[i] == grid[current.getX()+i][current.getY()])hDer++;
                    
                }
                //Horizontal izquierda
                if(isValid(dimX, dimY, current.getX()-i, current.getY())){
                    System.out.println("En la palabra: "+cadena[i]+ " . En la sopa: "+ grid[current.getX()-i][current.getY()]);
                    if(cadena[i] == grid[current.getX()-i][current.getY()]){
                        hIzq++;
                    System.out.println("Validacion horIzq --> cuenta: "+ hIzq);
                    } 
                }
                //Vertical norte, -i
                if(isValid(dimX, dimY, current.getX(), current.getY()-i)){
                    if(cadena[i] == grid[current.getX()][current.getY()-i]) vNorte++;                    
                }
                //Vertical sur, +i
                if(isValid(dimX, dimY, current.getX(), current.getY()+i)){
                    if(cadena[i] == grid[current.getX()][current.getY()+i]) vSur++;                    
                }
                //Diagonal SE
                if(isValid(dimX, dimY, current.getX()+i, current.getY()+i)){
                    if(cadena[i] == grid[current.getX()+i][current.getY()+i]) dSE++;
                }
                //Diagonal NO
                if(isValid(dimX, dimY, current.getX()-i, current.getY()-i)){
                    if(cadena[i] == grid[current.getX()-i][current.getY()-i]) dNO++;
                }
                
            }
            
            //Este es un origen de la lista de origenes, si algun valor es cierto, el valor del origen es el actual
            
            if(hDer==cadena.length || hIzq==cadena.length){
                this.status = HORIZONTAL; 
                this.origen = new Origen(current.getX()+1, current.getY()+1);
                System.out.println("Se asigno HORIZONTAL");
                return;
            }
            
            if(vNorte==cadena.length || vSur==cadena.length){
                this.status = VERTICAL; 
                this.origen = new Origen(current.getX()+1, current.getY()+1);
                System.out.println("Se asigno VERTICAL");
                return;
            }
            if(dSE==cadena.length || dNO==cadena.length){
                this.status = DIAGONAL; 
                this.origen = new Origen(current.getX()+1, current.getY()+1);
                System.out.println("Se asigno DIAGONAL");
                return;
            }
            
            current = current.getNext();
        }
        
    }
    
    private boolean isValid(Integer dimX, Integer dimY, Integer x, Integer y){
        if(x>=0 && x<dimX && y>=0 && y<dimY)return true;
        return false;
            
    }
    
    public String toString(){
        return this.palabra+" "+origen.toString()+" "+status;
    }
    
    public void printListaOrigenes(){
        listaOrigenes.printList();
    }
}
