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
public class Origen {
    private Origen next;
    private Integer x;
    private Integer y;
    
    public Origen(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    
    public void setNext(Origen next) {
        this.next = next;
    }

    public Origen getNext() {
        return next;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    public String toString(){
        return x+" "+y;
    }

}
