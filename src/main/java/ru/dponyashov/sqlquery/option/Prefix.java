package ru.dponyashov.sqlquery.option;

public enum Prefix {
    EMPTY(""),
    AND("AND"),
    OR("OR");
    private final String text;
    Prefix(String text){
        this.text = text;
    }
    public String text(){
        return text;
    }
}
