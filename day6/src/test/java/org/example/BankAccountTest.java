package org.example;

import static org.junit.jupiter.api.Assertions.*;




        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testInitialBalanceIsZero() {
        BankAccount account = new BankAccount();
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(200);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void testWithdrawDecreasesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(300);
        account.withdraw(100);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(150);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }

    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-30));
    }
}
