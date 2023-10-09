public class Main {
    
    public static void main(String[] args) {
        BankService bankService = new BankService();
        int savingAccount = bankService.createNewAccount("saving", 500);
        int chequingAccount = bankService.createNewAccount("chequing", 1000);


        System.out.println("Before Transaction:");
        System.out.println("Chequing Account Balance: " + bankService.getAccountFromIndex(chequingAccount).getBalance());
        System.out.println("Saving Account Balance: " + bankService.getAccountFromIndex(savingAccount).getBalance());

        
        bankService.transferMoney(savingAccount, chequingAccount, 150);
        System.out.println("After Transaction:");
        System.out.println("Chequing Account Balance: " + bankService.getAccountFromIndex(chequingAccount).getBalance());
        System.out.println("Saving Account Balance: " + bankService.getAccountFromIndex(savingAccount).getBalance());


    }

}
