package com.mmcoe.pojo;

public class Accounts {
    private double balance;
    public Accounts(double balance){
        this.balance=balance;
    }

    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Amount should be greater than 0");
        }
        balance+=amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException{
        if(amount<=0){
            throw new IllegalArgumentException("Amount should be greater than 0");
        }
        else if(balance>=amount){
            balance-=amount;
        }
        else{
            throw new InsufficientBalanceException("Insufficient Balance");
        }
    }

    public double getBalance(){
        return balance;
    }
}
