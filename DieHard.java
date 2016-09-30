import java.util.*;

public class DieHard{
	public static void main (String[] args){

	Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for ( int i = 1; i <= T; i++ ){
			int	a = sc.nextInt();
			int	b = sc.nextInt();
			int	c = sc.nextInt();

			if ((c % GCD(a, b)) == 0){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	
	}

	private static int GCD(int x, int y) { 
		if(y == 0) { return x; }
	 return GCD(y, x % y); 
	}

}