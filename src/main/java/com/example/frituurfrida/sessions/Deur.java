package com.example.frituurfrida.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class Deur implements Serializable {
    private final static long SerialVersionUID = 1L;
    private final int index;
    private final boolean metFriet;
    private boolean open;
    public Deur(int index, boolean metFriet){
        this.index = index;
        this.metFriet = metFriet;
    }

    public void open(){
        open = true;
    }
    public int getIndex(){
        return index;
    }
    public boolean isOpen(){
        return open;
    }
    public boolean isMetFriet(){
        return metFriet;
    }
}
