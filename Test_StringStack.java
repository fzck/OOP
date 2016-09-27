/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class Test_StringStack {
    public static void main(String[] args){
        StringStack stack = new StringStack(20);
        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        
        System.out.println(stack);
        System.out.println(stack.size());
        
        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();
        
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(stack);
        System.out.println(stack.size());
        
    }    
}
