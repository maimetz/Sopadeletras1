/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Metztoamm
 */
public class ListaPalabras {
    Palabra head;
    Palabra tail;
    
    public void append(Palabra palabra){
        if(head==null){
            this.head = palabra;
            this.tail = palabra;
        }else{
            tail.setNext(palabra);
            tail = palabra;
        }
    }
    
    public Palabra getHead() {
        return head;
    }
    
    public void printList(){
        Palabra current = this.head;
        while(current!=null){
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
