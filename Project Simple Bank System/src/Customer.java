public class Customer {
    private String name, email;
    private Address address;
    private BankAccount bankAccount;

    public Customer(String name, String email, Address address, BankAccount bankAccount){
        this.name = name;
        this.email = email;
        this.address = new Address(address.getStreet(), address.getCity(), address.getCountry());
        this.bankAccount = bankAccount;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public Address getAddress(){
        return address;
    }

    public BankAccount getBankAccount(){
        return bankAccount;
    }

    public void printDetails(){
        System.out.println("Name: " + name + "\nEmail: " + email + "\nStreet: " + address.getStreet() + "\nCity: " + address.getCity() + "\nCountry: " + address.getCountry() + "\nAccount nr: " + bankAccount.getAccountNumber() + "\nBalance: " + bankAccount.getBalance() + "\nInterest: " + bankAccount.calculateInterest());
    }
}
