public class CurrentAccount extends BankAccount{
    private double overdraftLimit;
    private double interestRate;
    public CurrentAccount(String accountNumber, double balance, double overdraftLimit, double interestRate){
        super(accountNumber,balance);
        this.overdraftLimit = overdraftLimit;
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void withdraw(double amount){
        if(amount > getBalance() + overdraftLimit){
            throw new RuntimeException("Withdrawal failed. Would exceed overdraft limit");
        }
        setBalance(getBalance() - amount);
    }
}
