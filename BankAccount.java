public class BankAccount {

    private String ownerName;
    private double balance;
    private boolean active;

    public BankAccount(String ownerName, double initialBalance) {
        if (ownerName == null || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.active = true;
    }

    public void deposit(double amount) {
        if (!active) {
            throw new IllegalStateException("Account is closed");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (!active) {
            throw new IllegalStateException("Account is closed");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
    }

    public void closeAccount() {
        this.active = false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
