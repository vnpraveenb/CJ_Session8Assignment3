/**
 * 
 */
package onlinebanking;



class OnlineBank extends Thread
{
	OnlineBankingDemo bank;
	OnlineBank(OnlineBankingDemo bank)
	{
		this.bank=bank;
	}
	public void run()
	{
		
		bank.deposit(15000);		//Hard coding the deposit amount to 15000
		bank.withdraw(1000);		//Hard coding the deposit amount to 1000
	}

}


 
/**
 * This class implements the basic functions for the Online Banking Application 
 * using synchronization
 * @author Praveen
 *
 */
public class OnlineBankingDemo {
	
 		double accountBalance =0;

		// Implementing the withdraw() method
		/**
		 * @param amount to be withdrawn
		 * @return returns nothing
		 */
		public synchronized void withdraw (double amount)  
		{
			double newAccountBalance;

			if( amount > accountBalance)  // Checks if the withdrawal amount is greater than the account balance

			{
				System.out.println("Not Enough Funds: Transaction Declined");
			}

			else
			{
				newAccountBalance = accountBalance - amount;
				accountBalance = newAccountBalance;
				System.out.println("Current balance after withdrawl of " + amount + " is: " + accountBalance);
			}
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
		
		// Implementing the deposit() method
		
		/**
		 * @param amount to be deposited. Does not accept negative deposits
		 * @return returns nothing
		 */
		public synchronized void deposit(double amount) 
		{
			double newAccountBalance;

			if( amount < 0.0)
			{
				System.out.println("Negative amount cannot be deopisted: Transaction Declined");// can not deposit a negative amount
			}

			else
			{
				System.out.println("The initial account balance is: " + accountBalance); // Initial account balance is 0

				newAccountBalance = accountBalance + amount;
				accountBalance = newAccountBalance;
				System.out.println("Current balance after depositing " + amount + " is: " + accountBalance);
			}

			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OnlineBankingDemo bank = new OnlineBankingDemo(); //Creates object of OnlineBankingDemo class
		OnlineBank onlineBank=new OnlineBank(bank);
		onlineBank.start();
	}

}
