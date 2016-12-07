package rule30revisit;

public class NoThreadR30 {
	long time = System.currentTimeMillis();	
    public int[][] cells;
    public int size;

    NoThreadR30(int size) {
        cells = new int[size][size];
        this.size = size;
    }

    private int cell(int i, int j){
    	int left, mid, right;
    	if (j == 0){
    		left = 0;
    	} else {
    		left = cells[i-1][j-1];
    	}
    	
    	if (j == size - 1){
    		right = 0;
    	} else{
    		right = cells[i-1][j+1];
    	}
    	
		mid = cells[i-1][j];
		
		if( (left == 0 && mid == 1 && right == 0) || (left == 1 && mid == 0 && right == 0) ||
			(left == 0 && mid == 1 && right == 1) || (left == 0 && mid == 0 && right == 1))
		{return 1;}
		else{	
			return 0;
		}
    }
    
    public void plot() {
       
    	//init
        for (int j = 0; j < size; j++){
            cells[0][j] = 0;
        }
        cells[0][size / 2] = 1;
        
        //gets value of cell, (expect: 0 or 1)
        for (int i = 1; i < size; i++){
            for (int j = 0; j < size; j++){
                cells[i][j] = cell(i, j);
            }
        }
        //prints the grid
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }
	

}
