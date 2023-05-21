package norman.example.design.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccountBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountBuilder.class);
    private BankAccount bankAccount;

    public BankAccountBuilder() {
        LOGGER.debug("Creating new account.");
        bankAccount = new BankAccount();
    }

    public BankAccountBuilder name(String name) {
        LOGGER.debug("Setting account name: " + name + ".");
        bankAccount.setName(name);
        return this;
    }

    public BankAccountBuilder accountNumber(String accountNumber) {
        LOGGER.debug("Setting account number: " + accountNumber + ".");
        bankAccount.setAccountNumber(accountNumber);
        return this;
    }

    public BankAccountBuilder email(String email) {
        LOGGER.debug("Setting account email: " + email + ".");
        bankAccount.setEmail(email);
        return this;
    }

    public BankAccountBuilder newsletter(boolean newsletter) {
        LOGGER.debug("Setting account newsletter: " + newsletter + ".");
        bankAccount.setNewsletter(newsletter);
        return this;
    }

    public BankAccount build() {
        LOGGER.debug("Returning complete account.");
        return bankAccount;
    }
}
