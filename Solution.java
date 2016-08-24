import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int[] prev = new int[x];
		int[] curr = new int[x];
		int fill = x/2;
			
		for (int i = 0; i < x; i++){
			if (i != fill){
				System.out.print(0);
				prev[i] = 0;
			} else {
				System.out.print(1);
				prev[i] = 1;
			}
		}
		System.out.println();

			for (int j = 1; j < x; j++){
				for(int i = 0; i < x; i++){
					if (i == 0){
						if (prev[i] == 1 && prev[i+1] == 1) { curr[i] = 1; }
						else if (prev[i] == 1 && prev[i+1] == 0) { curr[i] = 1; }
						else if (prev[i] == 0 && prev[i+1] == 1) { curr[i] = 1; }
						else if (prev[i] == 0 && prev[i+1] == 0) { curr[i] = 0; }
					}
					else if (i == x-1){
						if (prev[i-1] == 1 && prev[i] == 1) { curr[i] = 0; }
						else if (prev[i-1] == 1 && prev[i] == 0) { curr[i] = 1; }
						else if (prev[i-1] ==0 && prev[i] == 1) { curr[i] = 1; }
						else if (prev[i-1] == 0 && prev[i] == 0) { curr[i] = 0; }	
					}
					else if ( (prev[i-1] == 1 && prev[i] == 0 && prev[i+1] == 0 ) ||
						 	(prev[i-1] == 0 && prev[i] == 1 && prev[i+1] == 1 ) ||	
						 	(prev[i-1] == 0 && prev[i] == 1 && prev[i+1] == 0 ) ||	
						 	(prev[i-1] == 0 && prev[i] == 0 && prev[i+1] == 1 ) ){
							curr[i] = 1;
					}
                    else{
						 curr[i] = 0;                       
					}
				}
                
			for(int i = 0; i < x; i++){
				System.out.print(curr[i]);
				prev[i] = curr[i];
			}
			System.out.println();
		}
                
    }
}