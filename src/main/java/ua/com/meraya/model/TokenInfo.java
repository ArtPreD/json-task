package ua.com.meraya.model;

import ua.com.meraya.util.Convert;

import java.math.BigDecimal;

public class TokenInfo {
    private String symbol;
    private BigDecimal balance;
    private int factor;
    private double rate;

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        String msg = symbol + " : " + Convert.fromWei(balance, factor);
        if (rate != 0.0){
          double usd =  Convert.fromWei(balance, factor).multiply(new BigDecimal(rate)).doubleValue();
          msg = msg.concat(" USD: " + usd);
        }
        return msg;
    }
}