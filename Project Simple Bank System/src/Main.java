public class Main {
    public static void main(String[] args) {
        Address a = new Address("Bistritei", "Constanta", "Romania");
        BankAccount acc = new SavingsAccount("12", 120000.0,0.5);
        Customer c = new Customer("Alex", "alex02@gmail.com", a, acc);
        Bank bank = new Bank("BRD");

        Address a2 = new Address("Semaforului", "Sibiu", "Romania");
        BankAccount acc2 = new CurrentAccount("13", 1000.0, 500.0, 0.02);
        Customer c2 = new Customer("Mihai", "mihaig13@outlook.com", a2, acc2);

        bank.addCustomer(c);
        bank.deposit(c, 500.0);
        bank.printAllCustomers();
        bank.addCustomer(c2);
        bank.withdraw(c2, 1200.0);
        bank.printAllCustomers();
    }
}