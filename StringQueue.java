
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class StringQueue {
    final static int DEFAULT_SIZE = 10;
    
    private String[] elements;
    private int count;
    
    public StringQueue(){
        elements = new String[DEFAULT_SIZE];
        count = 0;
    }
    
    public int size() { return count; }
    
    public void resize(){elements = Arrays.copyOf(elements, count+1);}

    public void enqueue(String item){
        if (count == elements.length){
            resize();
        }
        for (int i = 0; i < count; i++){
            elements[count - i] = elements[count - i - 1]; 
        }
        count++;
        elements[0] = item;
    }
    
    public void enqueue(int i,String item){
        if (count == elements.length){
            resize();
        }
        for (int j = 0; j <= i; j++){
            elements[count - j] = elements[count - j - 1]; 
        }
        count++;
        elements[i] = item;
    }
    
    public String peek(){ return elements[count - 1]; }
       
    public String dequeue(){
        String top = peek();
        count--;
        return top;
    }
    
    public String dequeue(int n){
        if (n > count) { throw new NullPointerException("Cannot dequeue an empty index"); }
        String newTop = "";
        while(n > 0){
            newTop = dequeue();
            n--;
        } 
        return newTop;
    }
    
    public void singit(int space, String item){ enqueue(space, item); }
    
    @Override
    public String toString(){
        String out = "";
        if (count == 0){
            System.out.print("EMPTY");
        }else {
            for (int i = 0; i < count - 1; i++){
                out += elements[count - 1 - i] + ", ";
            }
            out += elements[0]; 
        }
        return out;
    }
}
