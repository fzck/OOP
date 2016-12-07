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

    public void display() {
    	for (int j = 0; j < size; j++) {
            if (j == size / 2){
            	 cells[0][j] = 1;
            } else {
            	cells[0][j] = 0;
            }
            
            
            System.out.print(cells[0][j]);
        }
        System.out.println();
        int part;
        if (size < THREAD_COUNT) {
        	part = size; 
        } else {
        	part =  THREAD_COUNT;
        }
        Parts[] parts = new Parts[part];
        int frag = size / part;
        int excess = size % part;

        for (int index = 0; index < size - 1; index++) {
            int start = 0;
            for (int i = 0; i < part; i++) {
                if (i < excess) {
                	parts[i] = new Parts(cells, start, frag + 1, index);
                }
                else{ parts[i] = new Parts(cells, start, frag, index);}
                
                if (i < excess) {
                	start = start + frag + 1;
                	
                } else {
                	start += frag;
                }
                parts[i].start();
                while(parts[i].isAlive()) {
                    try {
                        parts[i].join();
                    } catch(InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
            for(int i = 0, j = 0; i < parts.length; i++) {
                for (int n: parts[i].current) {
                    cells[index+1][j] = n;
                    System.out.print(n);
                    j++;
                }
            }
            System.out.println();
        }
        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }
    
}