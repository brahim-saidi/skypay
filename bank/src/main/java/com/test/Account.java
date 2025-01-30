package com.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {

    private List<Object[]> history = new ArrayList<>(); 
    private int balance = 0;


    @Override
    public void deposit(int amount) {
        //checking amount
        if (amount <= 0) {
            throw new RuntimeException("Amount should be more then 0 ");
        }
        
        balance += amount;
        history.add(new Object[]{LocalDate.now(), amount, balance});
    }

    @Override
    public void withdraw(int amount) {

       // checking the amount to withrow 0 < amount < balance  
        if (amount <= 0) {
            throw new RuntimeException("error : amount shouldd be greather thn 0  ");
        }

        
        if (balance < amount) {
            throw new RuntimeException("not enought money (the easist solution for doubt)  ");
        }
        
        balance -= amount;
        history.add(new Object[]{LocalDate.now(), -amount, balance});


    }

    @Override
    public void printStatement() {

        System.out.println("Date     ||Amount||Balance");
        List<Object[]> sortedHistory = new ArrayList<>(history);


        Collections.sort(sortedHistory, (a, b) -> 
        ((LocalDate)b[0]).compareTo((LocalDate)a[0]));


         for (Object[] transaction : sortedHistory) {
            LocalDate date = (LocalDate)transaction[0];
            int amount = (int)transaction[1];
            int balance = (int)transaction[2];
            
            String formattedDate = String.format("%d/%d/%d", 
            date.getDayOfMonth(),
            date.getMonthValue(),
            date.getYear());
        
        System.out.printf("%s||%d||%d%n", 
            formattedDate, 
            amount, 
            balance);
            
        }


    }


}
