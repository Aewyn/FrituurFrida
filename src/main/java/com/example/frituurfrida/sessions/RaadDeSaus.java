package com.example.frituurfrida.sessions;

import com.example.frituurfrida.domain.Saus;
import com.example.frituurfrida.services.SausService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.Random;

@Component
@SessionScope
public class RaadDeSaus implements Serializable {
    private final static long SerialVersionUID = 1L;
    private final static int MAX_VERKEERDE_POGINGEN = 10;
    private String saus;
    private StringBuilder puntjes;
    private int fouten;

    private Random random = new Random();

    public void gok(char letter) {
        var letterIndex = saus.indexOf(letter);
        if (letterIndex == -1) {
            fouten++;
        } else {
            do {
                puntjes.setCharAt(letterIndex, letter);
                letterIndex = saus.indexOf(letter, letterIndex + 1);
            } while (letterIndex != -1);
        }
    }


    public void reset(String saus) {
        this.saus = saus;
        puntjes = new StringBuilder(".".repeat(saus.length()));
        fouten = 0;
    }

    public String getPuntjes() {
        return puntjes.toString();
    }

    public String getSaus() {
        return saus;
    }

    public int getFouten() {
        return fouten;
    }

    public boolean isGewonnen() {
        return puntjes.indexOf(".") == -1;
    }

    public boolean isVerloren() {
        return fouten == MAX_VERKEERDE_POGINGEN;
    }
}
