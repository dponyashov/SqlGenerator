package ru.dponyashov.sqlquery.option;

public enum Agregate {
    EMPTY(""),
    SUM("sum"),
    COUNT("count"),
    MIN("min"),
    MAX("max");

    private final String text;
    Agregate(String text){
        this.text = text;
    }
    public String text(){
        return text;
    }
}
