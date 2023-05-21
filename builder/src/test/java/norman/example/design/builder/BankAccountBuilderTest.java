package norman.example.design.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountBuilderTest {
    @Test
    void build1() {
        BankAccountBuilder builder = new BankAccountBuilder();
        BankAccount bankAccount = builder.accountNumber("12345").name("Some Guy").email("some.guy@example.com")
                .newsletter(false).build();
        assertEquals("12345", bankAccount.getAccountNumber());
        assertEquals("Some Guy", bankAccount.getName());
        assertEquals("some.guy@example.com", bankAccount.getEmail());
        assertFalse(bankAccount.isNewsletter());
    }

    @Test
    void build2() {
        BankAccountBuilder builder = new BankAccountBuilder();
        BankAccount bankAccount = builder.accountNumber("12345").name("Some Guy").build();
        assertEquals("12345", bankAccount.getAccountNumber());
        assertEquals("Some Guy", bankAccount.getName());
        assertNull(bankAccount.getEmail());
        assertTrue(bankAccount.isNewsletter());
    }
}
