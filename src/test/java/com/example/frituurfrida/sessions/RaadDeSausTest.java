package com.example.frituurfrida.sessions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RaadDeSausTest {
    private RaadDeSaus raden;

    @BeforeEach
    void beforeEach() {
        raden = new RaadDeSaus();
        raden.reset("lol");
    }

    @Test
    void eenNieuwSpel() {
        assertThat(raden.getSaus()).isEqualTo("lol");
        assertThat(raden.getPuntjes()).isEqualTo("...");
        assertThat(raden.getFouten()).isZero();
        assertThat(raden.isGewonnen()).isFalse();
        assertThat(raden.isVerloren()).isFalse();
    }

    @Test
    void eenJuisteLetterRaden() {
        raden.gok('l');
        assertThat(raden.getPuntjes()).isEqualTo("l.l");
        assertThat(raden.getFouten()).isZero();
        assertThat(raden.isGewonnen()).isFalse();
        assertThat(raden.isVerloren()).isFalse();
    }

    @Test
    void eenFouteLetterRaden() {
        raden.gok('z');
        assertThat(raden.getPuntjes()).isEqualTo("...");
        assertThat(raden.getFouten()).isOne();
        assertThat(raden.isGewonnen()).isFalse();
        assertThat(raden.isVerloren()).isFalse();
    }

    @Test
    void hetWoordRaden() {
        raden.gok('l');
        raden.gok('o');
        assertThat(raden.isGewonnen()).isTrue();
        assertThat(raden.isVerloren()).isFalse();
    }

    @Test
    void jeVerliestNa10Fouten() {
        for (var poging = 1; poging <= 10; poging++){
            raden.gok('|');
        }
        assertThat(raden.isGewonnen()).isFalse();
        assertThat(raden.isVerloren()).isTrue();
    }
}