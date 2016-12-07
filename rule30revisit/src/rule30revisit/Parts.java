package rule30revisit;

public class Parts extends Thread{
	public int start;
    public int end;   
    public int[] previous;
    public int[] current;
    public int j;

    Parts(int[][] cells, int start, int end, int j) {
        previous = new int[cells.length];
        for (int i = 0; i < cells.length; i++){
            previous[i] = cells[j][i];
        }
        this.start = start;
        this.end = end;
        this.j = j;
        this.current = new int[end];
    }
    
   

    private void getcell() {
        for (int i = 0; i < end; i++){
                current[i]= value(i+start);
            }
        }

     int value(int j){
    	
    	int left, right, mid;
        if (j == 0) {
        	left = 0; 
        } else{
        	left =  previous[j-1];
        }
                
    	if (j == previous.length - 1) {
    		right = 0; 
    	} else{
    		right = previous[j+1];
    	}
        mid = previous[j];
        
        if( (left == 1 && mid == 0 && right == 0) || (left == 0 && mid == 1 && right == 1)||
            (left == 0 && mid == 1 && right == 0) ||(left == 0 && mid == 0 && right == 1))
            {return 1;}
        else{
        	return 0;
        }
    }

     public void run() {
         getcell();
     }
	

}
