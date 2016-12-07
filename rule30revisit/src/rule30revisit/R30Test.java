package rule30revisit;


public class R30Test {
	 public static final int SIZE = 75;
	
	public static void main(String[] args) {
        
        long mtStart, mtEnd,spStart, spEnd;
        mtStart = System.currentTimeMillis();
        ThreadedR30 mtTest = new ThreadedR30(SIZE);
        mtTest.display();
        mtEnd = System.currentTimeMillis();
        System.out.println("Multithreading =  " + (mtEnd - mtStart));


        spStart = System.currentTimeMillis();
        NoThreadR30 spTest= new NoThreadR30(SIZE);
        spTest.plot();
        spEnd = System.currentTimeMillis();
        System.out.println("Sequential processing =  " + (spEnd - spStart));
    }

}
