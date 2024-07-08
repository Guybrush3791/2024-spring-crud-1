package org.java.crud_test1.db.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastname;

    private int balance;

    public ContoBancario() {

        setBalance(0);
    }

    public ContoBancario(String name, String lastname) {

        this();

        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount)
            throws IllegalArgumentException {

        if (amount < 0)
            throw new IllegalArgumentException("Amount can't be zero or negative");

        balance += amount;
    }

    public void withdraw(int amont)
            throws IllegalArgumentException {

        if (amont < 0)
            throw new IllegalArgumentException("Amount can't be zero or negative");

        if (amont > balance)
            throw new IllegalArgumentException("You don't have enought money to withdraw");

        balance -= amont;
    }

    @Override
    public String toString() {

        return "ContoBancario [\n\tid=" + id + ", \n\tname=" + name + ", \n\tlastname=" + lastname + ", \n\tdeposit="
                + balance + "\n]";
    }
}
