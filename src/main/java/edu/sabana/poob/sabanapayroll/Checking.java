package edu.sabana.poob.sabanapayroll;

import java.time.LocalDate;
import java.util.UUID;

public class Checking extends BankAccount {

    public final double DEPOSIT_DISCOUNT = 5000;


    public Checking() {}

    public Checking(UUID employeeId) {
        idEmployee = employeeId;
    }

    @Override
    public double getDepositDiscount() {
        return this.DEPOSIT_DISCOUNT;
    }

    public boolean processCheck(Check check) {
        boolean result = false;

        if (check.getExpirationDate().isAfter(LocalDate.now()) && check.getAmount() > DEPOSIT_DISCOUNT) {
            result = true;
            try {
                setBalance(check.getAmount() - DEPOSIT_DISCOUNT + getBalance());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return result;
    }
}

