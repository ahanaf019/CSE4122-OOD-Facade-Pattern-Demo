public class ChequingAccount implements IAccount {

    private int balance;
    private int accountNumber;

    
    public ChequingAccount(int initialAmount, int accountNumber) {
        this.balance = initialAmount;
        this.accountNumber = accountNumber;
    }


    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }


    @Override
    public void withdraw(int amount) {
        if(amount > this.balance) {
            System.out.println("ERROR: Insufficient balance to withdraw.");
            return;
        }
        this.balance -= amount;
        System.out.println("SUCCESS: Withdraw complete.");
    }


    @Override
    public void transfer(IAccount toAccount, int amount) {
        if(amount > this.balance) {
            System.out.println("ERROR: Insufficient balance to transfer.");
            return;
        }
        toAccount.deposit(amount);
        this.balance -= amount;
        System.out.println("SUCCESS: Transfer complete.");
    }


    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }


    @Override
    public int getBalance() {
        return this.balance;
    }
    
}
