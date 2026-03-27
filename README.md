# 🏦 Java OOP Bank System

A simple banking system built in Java to practice and demonstrate core Object-Oriented Programming concepts.

---

## 📋 Project Structure

```
src/
├── BankAccount.java       # Abstract base class
├── SavingsAccount.java    # Extends BankAccount (5% interest)
├── CurrentAccount.java    # Extends BankAccount (overdraft support)
├── Address.java           # Simple value class
├── Customer.java          # Holds account and address
├── Bank.java              # Manages list of customers
└── Main.java              # Entry point
```

---

## 🧠 OOP Concepts Demonstrated

| Concept | Where |
|---|---|
| **Encapsulation** | Private fields with getters across all classes |
| **Abstraction** | Abstract `BankAccount` with abstract `calculateInterest()` |
| **Inheritance** | `SavingsAccount` and `CurrentAccount` extend `BankAccount` |
| **Polymorphism** | `calculateInterest()` behaves differently per account type |
| **Composition** | `Customer` owns an `Address` (defensive copy in constructor) |
| **Association** | `Customer` holds a reference to a `BankAccount` |
| **Aggregation** | `Bank` holds a list of `Customer` objects |
| **Delegation** | `Bank` delegates deposit/withdraw to account objects |
| **Cohesion** | Each class has a single, focused responsibility |
| **Coupling** | Classes interact through methods, not internal fields |

---

## 🏗️ Class Overview

### `BankAccount` (Abstract)
Base class for all account types. Handles common logic like deposit and withdrawal with validation.
- Throws `IllegalArgumentException` for invalid amounts
- Enforces a max ATM deposit of $10,000
- Prevents overdraft on standard accounts
- Forces subclasses to implement `calculateInterest()`

### `SavingsAccount`
Extends `BankAccount` with a configurable interest rate.
```java
BankAccount acc = new SavingsAccount("ACC001", 1000.0, 0.05); // 5% interest
```

### `CurrentAccount`
Extends `BankAccount` with overdraft support. Overrides `withdraw()` to allow balance to go negative up to the overdraft limit.
```java
BankAccount acc = new CurrentAccount("ACC002", 1000.0, 500.0, 0.02); // $500 overdraft, 2% interest
```

### `Address`
Immutable value class. No setters — address cannot be changed after creation.

### `Customer`
Associates a person with their bank account. Defensively copies the `Address` object to protect internal state.

### `Bank`
Aggregates customers and delegates financial operations to their accounts.

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ, Eclipse, VS Code)

### Run the project
```bash
# Compile
javac src/*.java

# Run
java -cp src Main
```

---

## 💡 Example Usage

```java
Address address = new Address("Bistritei", "Constanta", "Romania");

BankAccount savingsAcc = new SavingsAccount("ACC001", 120000.0, 0.05);
Customer alex = new Customer("Alex", "alex@gmail.com", address, savingsAcc);

BankAccount currentAcc = new CurrentAccount("ACC002", 1000.0, 500.0, 0.02);
Customer john = new Customer("John", "john@gmail.com", address, currentAcc);

Bank bank = new Bank("BRD");
bank.addCustomer(alex);
bank.addCustomer(john);

bank.deposit(alex, 500.0);
bank.withdraw(john, 1200.0); // Works because of overdraft limit

bank.printAllCustomers();
```
