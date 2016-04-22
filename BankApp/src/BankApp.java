import java.util.Scanner;

public class BankApp{
	public static void main(String[] args) {
		Bank BankOfDamaris = new Bank();
		int choice;
		String cname;
		double openingbalance;
		int accountID;
		double deposit;
		double withdraw;
		int n;
		
		do {
			System.out.println("*************************************************************************");
			System.out.println("*                          =============                                *");
			System.out.println("*                          ||Bank Menu||                                *");
			System.out.println("*                          =============                                *");
			System.out.println("* 1) Open a new bank account                                            *");
			System.out.println("* 2) Deposit to a bank account                                          *");
			System.out.println("* 3) Withdraw from a bank account                                       *");
			System.out.println("* 4) Print short account information                                    *");
			System.out.println("* 5) Print the detailed account information including last transactions *");
			System.out.println("* 6) Quit                                                               *");
			System.out.println("*************************************************************************");
			System.out.println("Enter a menu code: ");
        
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			scanner.nextLine();
		
			//1.	Ask the user for the customer name and the opening balance of a new bank account,
			//and create this new bank account from that information at the bank. 
			//Print the account number of this new account.
			if (choice == 1) {
				System.out.println("Enter the name of the customer: ");
				cname = scanner.nextLine();
				
				System.out.println("Enter opening balance: ");
				openingbalance = scanner.nextDouble();
				accountID = BankOfDamaris.openNewAccount(cname, openingbalance);
				System.out.println("Account ID for the new account is " + accountID);
			}
			
			//2.	Ask the user for the account number of an account, and a deposit amount.
			//Deposit the given amount to the bank account whose account number is given.
			else if (choice == 2) {
				System.out.println("Enter Account ID: ");
				accountID = scanner.nextInt();
				System.out.println("Enter amount to be DEPOSITED: ");
				deposit = scanner.nextDouble();				
				BankOfDamaris.depositTo(accountID, deposit);
			}
			
			//3.	Ask the user for the account number of an account, and a withdraw amount. 
			//Withdraw the given amount from the bank account whose account number is given. 
			else if (choice == 3) {
				System.out.println("Enter Account ID: ");
				accountID = scanner.nextInt();
				System.out.println("Enter amount to be WITHDRAWN: ");
				withdraw = scanner.nextDouble();
				BankOfDamaris.withdrawFrom(accountID, withdraw);
			}
			
			//4.   Ask the user for the account number of an account,
			//and print the short information (account number, customer name, and balance) about this account.
			else if (choice == 4) {
				System.out.println("Enter Account ID: ");
				accountID = scanner.nextInt();
				BankOfDamaris.printAccountInfo(accountID);
			}
			
			//5.	Ask the user for the account number of an account, and the number of last N transactions.
			//Print the detailed information (account number, customer name, balance, and the last N transactions) about this account.
			else if (choice == 5) {
				System.out.println("Enter Account ID: ");
				accountID = scanner.nextInt();
				
				System.out.println("How many last transactions do you want to see? ");
				n = scanner.nextInt();
				
				BankOfDamaris.printAccountInfo(accountID, n);
			}
			else if (choice == 6) {
				break;
			}
			else {
				System.out.println("That is not a menu option.");
			}
			scanner.close();
		} while (choice != 6);
	}
}