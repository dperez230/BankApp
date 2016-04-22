class BankAccount {
	private int accountNum;	        // each bank account should have a unique account number
	private String customerName;	// the owner of the account
	private double balance;		    // the current balance of the account
	private double[] transactions;	// all the transactions (deposits and withdrawals) on this account
	private int numOfTransactions;	// the number of the transactions on the account
	static int SIZE = 50;			//Number of transactions in account
	static int count = 1;			//Keeps track of account numbers and makes sure none are the same
	
	// Constructor with two parameters should initialize the new BankAccount object as follows: 	
	// customerName and balance are initialized with the value of the parameters;
	//you have to generate a unique account number for each new BankAccount object;
	//the opening balance will be the first transaction (deposit) on this account
	//so it must be recorded in the transactions array.
	public BankAccount(String cname, double openingBalance) {
		customerName = cname;
		balance = openingBalance;
		transactions = new double [SIZE];
		transactions[numOfTransactions] = openingBalance;
		numOfTransactions++;
		accountNum = count++;
	}

	// Returns the account number of a bank account.
	public int getAccountNum() {
		return accountNum;
	}

	// Returns a string containing the account number, the customer name and the balance of 
	// a bank account.
	public String getAccountInfo() {
		return ("Account Number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance: " + balance);
	}

	// Returns a string containing the last n transactions of a bank account.
	public String getTransactionInfo(int n) {
		if (n == 0) {
			return ((n+1) + "\tDEPOSIT\t\t" + transactions[n] + "\n");
		}
		else if (n > numOfTransactions - 1) {
			return ("");
		}
		else if (transactions[n - 1] > transactions[n]) {
			return ((n+1) + "\tWITHDRAW\t" + transactions[n] + "\n");
		}
		else if (transactions[n - 1] < transactions[n]) {
			return ((n+1) + "\tDEPOSIT\t\t" + transactions[n] + "\n");
		}
		else {
			return ("");
		}
	}
	
	// Withdraws the given amount from an account. It should also register this withdrawal 
	// as a transaction. If the balance is not enough, it should print a message.
	public void withdraw(double amount) {
		if (((balance) - amount) < 0) {
			System.out.println ("Not enough funds to make the withdraw.\n");
		}
		else {
			balance -= amount;
					
			transactions[numOfTransactions] = amount;
			numOfTransactions++;
		}
	}

	// Deposits the given amount to an account. It should also register this deposit as a transaction. 
	public void deposit(double amount) {
		balance += amount;
				
		transactions[numOfTransactions] = amount;
		numOfTransactions++;
	}
}