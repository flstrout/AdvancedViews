package com.fredstrout.advancedviews;

public class States {

    private String sName;
    private String sCapital;
    private String sAbbreviation;

    public States (String _name, String _capital, String _abbrev) {
        sName = _name;
        sCapital = _capital;
        sAbbreviation = _abbrev;
    }

    public String getName() {
        return sName;
    }

    public String getCapital () {
        return sCapital;
    }

    public String getsAbbreviation() {
        return sAbbreviation;
    }

    public  String toString() {
        return sName;
    }

}