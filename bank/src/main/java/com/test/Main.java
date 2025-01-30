package com.test;

public class Main {
    public static void main(String[] args) {


        // make example transactions 
        Account account = new Account();
        account.deposit(1000);  
        account.deposit(2000);  
        account.withdraw(500); 
        account.printStatement();// Print the statement
    
    
    }

   
}