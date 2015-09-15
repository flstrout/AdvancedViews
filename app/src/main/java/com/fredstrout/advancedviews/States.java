package com.fredstrout.advancedviews;


public class State {

    private String sName;
    private String sCapital;

    public State (String _name, String _capital) {
        sName = _name;
        sCapital = _capital;
    }

    public String getName() {
        return sName;
    }

    public String getCapital () {
        return sCapital;
    }

}
