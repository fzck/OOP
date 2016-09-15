/*
 * A Test Driver for the Account class.
 */
public class TestAccount {
   public static void main(String[] args) {
      // Test constructor and toString()
      Account d1 = new Account(2016, 10.0);
      System.out.println(d1);  // toString()
 
      // Test Setters and Getters
      d1.debit(10000.0);
      d1.setBalance(23.0);
      System.out.println(d1);  // run toString() to inspect the modified instance
      System.out.println("account number: " + d1.getAccountNumber());
      System.out.println("balance: " + d1.getBalance());
 
      
      System.out.println(d1);  // toString()
   }
}

