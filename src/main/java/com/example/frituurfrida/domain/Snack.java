package com.example.frituurfrida.domain;

import java.math.BigDecimal;

public class Snack {
    private long nummer;
    private String naam;
    private BigDecimal prijs;

    public Snack(long nummer, String naam, BigDecimal prijs) {
        this.nummer = nummer;
        this.naam = naam;
        this.prijs = prijs;
    }

    public long getNummer() {
        return nummer;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return nummer + ": " + naam + ", €" + prijs;
    }
}
