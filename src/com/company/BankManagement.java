/*
Name Project: Bank Management
Author: Nunzio Emanuele Sgroi

Description
This program is a simulation of how bank accounts are managed thanks to programming.
I followed the guide below:

Design a class named Account that contains:
• A private int data field named id for the account (default 0).
• A private double data field named balance for the account (default 0).
• A private double data field named annualInterestRate that stores the current interest
rate (default 0). Assume all accounts have the same interest rate.
• A private Date data field named dateCreated that stores the date when the account
was created.
• A no-arg constructor that creates a default account.
• A constructor that creates an account with the specified id and initial balance.
• The accessor and mutator methods for id, balance, and annualInterestRate.
• The accessor method for dateCreated.
• A method named getMonthlyInterestRate() that returns the monthly interest rate.
• A method named withdraw that withdraws a specified amount from the account.
• A method named deposit that deposits a specified amount to the account.
• Implement the class. Write a Java program that creates an Account object with an
account ID of 1122, a balance of $20,000, and an annual interest rate of 4.5%. Use the
withdrawal method to withdraw $2,500, use the deposit method to deposit $3,000, and
print the balance, the monthly interest, and the date when this account was created.
 */

package com.company;

import java.text.NumberFormat;
import java.util.Date;

public class BankManagement {
    public static void main(String[] args) {

        //Test account
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500.0);
        account.deposit(3000.0);
        NumberFormat englishPound = NumberFormat.getCurrencyInstance();
        System.out.println("Balance: " + englishPound.format(account.getBalance()));
        System.out.println("Monthly Interest: " + englishPound.format(account.getMonthlyInterest()));
        System.out.println("Date Created: " + account.getDateCreated());
    }
}

class Account {
    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 0.0;
    private final Date dateCreated;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this();
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    //data of account creation
    public String getDateCreated() {
        return this.dateCreated.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //set annual interest rate value
    public void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    //formula to calculate the monthly amount
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12 ;
    }

    //calculate interest in money
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) { //withdraw amount is taken out the balance amount
        this.balance -= amount;
    }

    public void deposit(double amount) { //deposit amount is added to balance amount
        this.balance += amount;
    }
}
