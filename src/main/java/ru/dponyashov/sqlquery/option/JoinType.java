package ru.dponyashov.sqlquery.option;

public enum JoinType {
    INNER_JOIN("INNER JOIN"),
    LEFT_JOIN("LEFT JOIN");
    private final String text;
    JoinType(String text){
        this.text = text;
    }
    public String text(){
        return text;
    }
}
