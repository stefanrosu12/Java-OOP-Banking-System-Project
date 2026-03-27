public class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate){
        super(accountNumber,balance);
        this.interestRate = interestRate;
    }
    @Override
    public double calculateInterest(){
        return getBalance() * interestRate;
    }
}
