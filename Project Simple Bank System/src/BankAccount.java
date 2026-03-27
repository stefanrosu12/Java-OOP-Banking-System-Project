public abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract double calculateInterest();

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount cannot be negative or null");
        }
        if(amount > 10000){
            throw new IllegalArgumentException("Amount too big to deposit at an ATM");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount cannot be negative or null");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Not enough available funds");
        }
        balance = balance - amount;
    }
}
