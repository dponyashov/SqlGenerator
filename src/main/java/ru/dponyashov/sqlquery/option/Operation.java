package ru.dponyashov.sqlquery.option;

public enum Operation {
    EMPTY(""),
    EQ("="),
    NE("<>"),
    LT("<"),
    GT(">"),
    LE("<="),
    GE(">="),
    BT("BETWEEN"),
    IN("IN"),
    LIKE("LIKE");
    private final String text;
    Operation(String text){
        this.text = text;
    }
    public String text(){
        return text;
    }
}
