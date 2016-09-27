
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
public class StringStack {
    final static int DEFAULT_SIZE = 10;
    
    private String[] elements;
    private int size;
    
    public StringStack(){
        this(0);
    }
    
    public StringStack(int size){
        if (size < 0){ throw new IllegalArgumentException ("Size cannot be negative"); }
        elements = new String[size];
        this.size = 0;
    }
    
    public int size() {
        return size;
    }

    public void push(String item){
        if (size == elements.length){
            elements = Arrays.copyOf(elements, size+1);
        }
        for (int i = 0; i < size; i++){
            elements[size - i] = elements[size - i - 1]; 
        }
        size++;
        elements[0] = item;
    }
    
    public String peek(){ return elements[0]; }
       
    public String pop(){
        String top = peek();
        for (int i = 0; i < size; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        return top;
    }
    
    public String pop(int n){
        if (n > size) { throw new NullPointerException("Cannot pop an empty index"); }
        String newTop = "";
        while(n > 0){
            newTop = pop();
            n--;
        } 
        return newTop;
    }
    
    @Override
    public String toString(){
        String out = "";
        if (size == 0){
            System.out.print("EMPTY");
        }else {
            for (int i = 0; i < size - 1; i++){
                out += elements[size - 1 - i] + ", ";
            }
            out += elements[0]; 
        }
        return out;
    }
}
