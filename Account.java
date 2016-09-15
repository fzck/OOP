public class Account{
	private int accountNumber;
	private double balance;

	public Account (int n, double b){
		this(n);
		setBalance(b);
	}
	public Account (int acc) {
		this.accountNumber = acc;
	}


	public int getAccountNumber(){
		return accountNumber;
	}
	
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		if(balance < 0.0) {
         // error!
         throw new IllegalArgumentException("Broke af");
      }
		this.balance = balance;
	}

	public void credit(double amount){
		setBalance(balance + amount);

	}

	public void debit(double amount){
		if (balance >= amount){
			setBalance(balance - amount);
		} else {
		// error!
         throw new IllegalArgumentException("amount withdrawn exceeds the curernt balance!");

		}

	}

	public String toString(){
		String str = String.format("A/C no:%d, Balance=$%.2f",accountNumber,balance);
		return str;
	}	
}