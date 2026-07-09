package com.mmcoe.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmcoe.pojo.Accounts;
import com.mmcoe.pojo.InsufficientBalanceException;

public class TestAccounts {
    
    private Accounts acc;
    @BeforeEach
    public void init(){
        acc=new Accounts(1000);
    }

    @Test
    public void testgetBalance(){
        assertEquals(1000, acc.getBalance());
    }
    @Test
    public void testDeposit(){
        acc.deposit(1000);
        assertEquals(2000, acc.getBalance());
    }

    @Test
    public void testWithdraw() throws InsufficientBalanceException{
        acc.withdraw(1000);
        assertEquals(0, acc.getBalance());
    }
    @Test
    public void testWithdrawBy500() throws InsufficientBalanceException{
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-500));
    }

    @Test
    public void testWithdrawException(){
        assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(2000));
    }

    @Test
    public void testDepositException(){
        Accounts acc=new Accounts(1000);
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-1000));
    }
}
