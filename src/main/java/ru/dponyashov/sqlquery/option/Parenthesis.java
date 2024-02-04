package ru.dponyashov.sqlquery.option;

public enum Parenthesis {
    EMPTY(""),
    OPEN("("),
    CLOSE(")");
    private final String text;
    Parenthesis(String text){
        this.text = text;
    }
    public String text(){
        return this.text;
    }
}
