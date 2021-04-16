package edu.sabana.poob.sabanapayroll;

import java.util.UUID;

public abstract class BankAccount {

    public static final int TAX_4_1000 = 4;

    private double balance;
    protected UUID idEmployee;

    /**
     * Inicializa una cuenta.
     */
    public BankAccount() {
        this.balance = 0;
    }

    /**
     *Obtiene el porcentaje del deposito.
     *
     * @return
     */
    public abstract double getDepositDiscount();

    /**
     * Depositar una cantidad de dinero en la cuenta.
     * <br><br>
     * - El dinero a depositar debe ser mayor que el descuento que aplica el banco por defecto, de no ser así, la
     * operación no puede realizarse.<br>
     * - Si el monto a depositar es correcto, debe realizar el descuento y cambiar el valor del balance.
     * <br><br>
     *
     * @param amount El monto a depositar.
     * @return Si la operación fue exitosa.
     */

    public UUID getEmployee() {
        return idEmployee;
    }

    public boolean deposit(double amount) {
        boolean result = false;

        if (amount>getDepositDiscount())
        {
            result=true;
            this.balance=this.balance+amount-getDepositDiscount();
        }

        return result;
    }

    /**
     * Realizar un retiro.
     * <br><br>
     * - Si el monto a retirar sumado al impuesto del 4 x 1000 es inferior al balance de la cuenta, la operación no
     * puede realizarse. <br>
     * - De ser posible, debe realizarse el descuento del balance del monto a retirar y del impuesto.
     * <br><br>
     *
     * @param amount El monto a retirar.
     * @return Si la operación fue exitosa.
     */
    public boolean withdraw(double amount) {
        if (amount * (1 + TAX_4_1000/1000.0) < getBalance()) {
            return false;
        }
        balance -= amount * (1 + TAX_4_1000/1000.0);
        return true;
    }

    /**
     * Devuelve el balance de la cuenta
     *
     * @return El balabce
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws Exception {
        if (balance < 0)
            throw new Exception("Error en el deposito");

        this.balance = balance;
    }
}


