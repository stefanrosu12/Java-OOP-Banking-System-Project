import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public void printAllCustomers(){
        for(Customer c : customers){
            c.printDetails();
        }
    }

    public void deposit(Customer c, double amount){
        c.getBankAccount().deposit(amount);
    }

    public void withdraw(Customer c, double amount){
        c.getBankAccount().withdraw(amount);
    }
}
