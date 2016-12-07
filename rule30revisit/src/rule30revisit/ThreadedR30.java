package rule30revisit;



public class ThreadedR30 {
	long time = System.currentTimeMillis();
    final static int THREAD_COUNT = 10;
    public int[][] cells;
    public int size;

    public ThreadedR30(int size) {
        cells = new int[size][size];
        this.size = size;
    }
    public void init(){
    	for (int j = 0; j < size; j++) {
        	if (j == size / 2){
        		cells[0][j] = 1;
        	} else {
        		cells[0][j] = 0;
        	}
            System.out.print(cells[0][j]);
        }
    }
    public void display() {
    	init();
    	
        System.out.println();
        int portion; 
        		if(size < THREAD_COUNT) {
        			portion = size; 
        		} else {
        			portion = THREAD_COUNT;
        		}
        Parts[] parts = new Parts[portion];
        int each = size / portion;
        int excess = size % portion;

        for (int k = 0; k < size - 1; k++) {
            int start = 0;
            for (int i = 0; i < portion; i++) {
                      
                if (i < excess){
                	parts[i] = new Parts(cells, start, each + 1, k);
                	start = each + 1;
                } else{
                	parts[i] = new Parts(cells, start, each, k);
                	start += each;
                }
 
                parts[i].start();
                while(parts[i].isAlive()) {
                    try {
                        parts[i].join(); //waits for thread to die
                    } catch(InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
            for(int i = 0, j = 0; i < parts.length; i++) {
                for (int num: parts[i].current) {
                    cells[k+1][j] = num;
                    System.out.print(num);
                    j++;
                }
            }
            System.out.println();
        }
        
        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }
    
	

}
