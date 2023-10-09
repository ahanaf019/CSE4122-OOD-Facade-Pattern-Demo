import java.util.Hashtable;

public class BankService {
    private Hashtable<Integer, IAccount> bankAccounts;
    private int accountNumberGenerator;


    public BankService() {
        this.bankAccounts = new Hashtable<Integer, IAccount>();
        this.accountNumberGenerator = 101;
    }


    public int createNewAccount(String accountType, int initialAmount) {
        IAccount newAccount = null;

        if(accountType.equals("chequing")) {
            newAccount = new ChequingAccount(initialAmount, accountNumberGenerator);
        }

        else if(accountType.equals("saving")) {
            newAccount = new SavingAccount(initialAmount, accountNumberGenerator);
        }

        else if(accountType.equals("investment")) {
            newAccount = new InvestmentAccount(initialAmount, accountNumberGenerator);
        }

        else {
            System.out.println("ERROR: Invalid account type.");
        }
        accountNumberGenerator += 1;

        if(newAccount != null) {
            this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);

            return newAccount.getAccountNumber();
        }

        return -1;
    }


    public void transferMoney(int toAccountIndex, int fromAccountIndex, int amount) {
        IAccount toAccount = this.bankAccounts.get(toAccountIndex);
        IAccount fromAccount = this.bankAccounts.get(fromAccountIndex);

        fromAccount.transfer(toAccount, amount);
    }


    public IAccount getAccountFromIndex(int index) {
        return bankAccounts.get(index);
    }


    public int getAccountsCount() {
        return bankAccounts.size();
    }

}
