package ua.com.meraya.model;

import ua.com.meraya.util.Convert;

import java.math.BigDecimal;

public class TokenInfo {
    private String symbol;
    private BigDecimal balance;
    private int factor;

    public TokenInfo() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return symbol + " : " + Convert.fromWei(balance, factor);
    }
}