/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class Test_StringQueue {
    public static void main(String[] args){
        StringQueue q = new StringQueue();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("Jeremy");
        q.enqueue("Jerome");
        q.enqueue("Florence");
        
        System.out.println(q.peek());
        
        System.out.println(q);
        System.out.println(q.size());
        
        String item1 = q.dequeue();
        String item2 = q.dequeue();
        String item3 = q.dequeue();
        
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(q);
        System.out.println(q.size());
        
        q.singit(1, "Gamie");
        
        System.out.println(q);
        System.out.println(q.size());
        
        System.out.println(q.dequeue(2)); 
        System.out.println(q);
        
    }    
}
