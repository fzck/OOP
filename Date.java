public class Date{
	private int month;
	private int day;
	private int year;
	public Date (int y, int m, int d){
		setDate(y,m,d);
	}
	public void setDate (int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int getYear(){
		return year;
	}
	public void setYear( int year){
		if(year < 1000 ||  year > 9999) {
         	// error!
         	throw new IllegalArgumentException("Out of bounds!");
      		}
		this.year = year;
	}
	public int getMonth(){
		return month;
	}
	public void setMonth( int month){
		if(month < 1 || month > 12) {
        		throw new IllegalArgumentException("Out of bounds!");
     		}
      		if(month == 2 && day > 29) {
         		throw new IllegalArgumentException("Out of bounds!");
      		}
      		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 && day == 30) {
         		throw new IllegalArgumentException("Out of bounds!");
      		}
   		this.month = month;
	}
	public int getDay(){
		return day;
	}
	public void setDay( int day){
		if(day < 1 || day > 31) {
         		throw new IllegalArgumentException("Out of bounds!");
      		}
      		if ( (isLeapYear(year)) &&  (day > 29)) {        	
         		throw new IllegalArgumentException("Out of bounds!");
      		}
		this.day = day;
	}
	private boolean isLeapYear(int year) {
   		if (year % 4 == 0) {
  			return true;
 		}
		if (year % 400 == 0) {
        		return true;
    		}
		if (year % 100 == 0) {
        		return false;
    		}
    		return true;
	}
	public String toString(){
		String str = String.format("%02d/%02d/%02d",month,day,year);
		return str;
	}	
}
