class Bank {
	private BankAccount[] accounts; // all the bank accounts at this bank
	private int numOfAccounts;		// the number of bank accounts at this bank
	static int SIZE = 100;
		
	// Constructor: A new Bank object initially doesn't contain any accounts.
	public Bank() {
		numOfAccounts = 0;
		accounts = new BankAccount[SIZE];
	}
	
	// Creates a new bank account using the customer name and the opening balance given as parameters
	// and returns the account number of this new account. It also adds this account into the account list
	// of the Bank calling object.
	public int openNewAccount(String customerName, double openingBalance) {
		accounts[numOfAccounts] = new BankAccount(customerName, openingBalance);
		int accountNum = accounts[numOfAccounts].getAccountNum();
		numOfAccounts++;
		return accountNum;
	}
	
	// Withdraws the given amount from the account whose account number is given. If the account is
	// not available at the bank, it should print a message.
	public void withdrawFrom(int accountNum, double amount) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accounts[i].getAccountNum() == accountNum) {
				accounts[i].withdraw(amount);
				return;
			}
		}
		System.out.println ("That account does not exist");
		return;
	}
	
	// Deposits the given amount to the account whose account number is given. If the account is not 	
	// available at the bank, it should print a message.
	public void depositTo(int accountNum, double amount) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accounts[i].getAccountNum() == accountNum) {
				accounts[i].deposit(amount);
			return;
			}
		}
		System.out.println ("That account does not exist");
		return;
	}
	
	// Prints the account number, the customer name and the balance of the bank account whose
	// account number is given. If the account is not available at the bank, it should print a message.
	public void printAccountInfo(int accountNum) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accounts[i].getAccountNum() == accountNum) {
				System.out.println(accounts[i].getAccountInfo());
				return;
			}
		}
		System.out.println ("That account does not exist");
		return;
	}
	
	// Prints the account number, the customer number and the balance of the bank account whose
	// account number is given, together with last n transactions on that account. If the account is not 
	// available at the bank, it should print a message.
	public void printAccountInfo(int accountNum, int n) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accounts[i].getAccountNum() == accountNum) {
				accounts[i].getAccountInfo();
				System.out.println("TRANSACTIONS");
				for (int j = 0; j < (n - 1); j++) {
					System.out.print(accounts[i].getTransactionInfo(j));
				}
				return;
			}
		}
		System.out.println ("That account does not exist");
		return;
	}
}